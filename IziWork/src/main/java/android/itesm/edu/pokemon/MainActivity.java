package android.itesm.edu.pokemon;


import android.itesm.edu.pokemon.adapters.WorksRecycleAdapter;
import android.itesm.edu.pokemon.model.WorkCard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://api.myjson.com/bins/18sw8u" ;

    private JsonObjectRequest request;
    private RequestQueue requestQueue;
    private List<WorkCard> cards;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleView);
        jsonrequest();
    }

    private void jsonrequest()
    {
        request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray cardsJSON = response.getJSONArray("trabajos");
                    JSONObject jsonObject = null;


                    for (int i = 0; i < cardsJSON.length(); i++)
                    {
                        jsonObject = cardsJSON.getJSONObject(i);
                        WorkCard workCard = new WorkCard();
                        workCard.setNombre(jsonObject.getString("nombre"));
                        workCard.setSalario(jsonObject.getString("salario"));
                        workCard.setDireccion(jsonObject.getString("direccion"));
                        workCard.setDescripcion(jsonObject.getString("descripcion"));

                        JSONArray jsonArrayDias = jsonObject.getJSONArray("dias");
                        ArrayList<String> dias = new ArrayList<>();
                        for (int j = 0; j < jsonArrayDias.length(); j++) {

                            String string = jsonArrayDias.getString(j);
                            dias.add(string);
                        }

                        workCard.setDias(dias);
                        cards.add(workCard);
                        //dias.clear();
                    }
                }catch (JSONException jsonException){
                    jsonException.printStackTrace();
                }

                setRecyclerView(cards);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error del POKE serve", Toast.LENGTH_LONG).show();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setRecyclerView(List<WorkCard> wordCards)
    {
        WorksRecycleAdapter worksRecycleAdapter = new WorksRecycleAdapter(this, wordCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(worksRecycleAdapter);

    }

}
