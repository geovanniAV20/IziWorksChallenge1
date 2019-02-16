package android.itesm.edu.pokemon;


import android.itesm.edu.pokemon.adapters.PokemonRecycleAdapter;
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

    private final String JSON_URL = "https://api.myjson.com/bins/kb4ca" ;

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
                    List<String> dias = new ArrayList<>();

                    for (int i = 0; i < cardsJSON.length(); i++)
                    {
                        jsonObject = cardsJSON.getJSONObject(i);
                        WorkCard workCard = new WorkCard();
                        workCard.setNombre(jsonObject.getString("nombre"));
                        workCard.setSalario(jsonObject.getString("salario"));
                        workCard.setDireccion(jsonObject.getString("direccion"));
                        workCard.setImageUrl(jsonObject.getString("descripcion"));

                        JSONArray jsonArrayDias = jsonObject.getJSONArray("dias");
                        for (int j = 0; j < jsonArrayDias.length(); j++) {
                            dias.add(jsonArrayDias.getString(j));
                        }

                        workCard.setDias(dias);
                        cards.add(workCard);
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

    private void setRecyclerView(List<WorkCard> workCards)
    {
        PokemonRecycleAdapter pokemonRecycleAdapter = new PokemonRecycleAdapter(this, workCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pokemonRecycleAdapter);

    }

}
