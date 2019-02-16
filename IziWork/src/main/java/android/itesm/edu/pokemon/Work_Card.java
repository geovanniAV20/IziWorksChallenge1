package android.itesm.edu.pokemon;

import android.app.ActionBar;
import android.itesm.edu.pokemon.model.WorkCard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Work_Card extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work__card);
        WorkCard workCard = (WorkCard) getIntent().getSerializableExtra("pokemon");
        loadPokemon(workCard);
    }

    private void loadPokemon(WorkCard workCard){
        TextView nombre, salario, direccion, descripcion, dias;
        ImageView image;

        nombre = findViewById(R.id.nombre);
        salario = findViewById(R.id.salario);
        direccion = findViewById(R.id.direccion);
        descripcion = findViewById(R.id.descripcion);
        dias = findViewById(R.id.dias);
        image = findViewById(R.id.image);

        RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);

        nombre.setText(workCard.getNombre());
        salario.setText("Salario: " + workCard.getSalario());
        direccion.setText("Dirección: " + workCard.getDireccion());
        descripcion.setText("Descripción: " + workCard.getDescripcion());
        dias.setText("Días:" + workCard.getDias().toString());

        Glide.with(this).load(workCard.getImageUrl()).apply(options).into(image);
    }
}
