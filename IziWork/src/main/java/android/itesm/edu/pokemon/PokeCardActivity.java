package android.itesm.edu.pokemon;

import android.itesm.edu.pokemon.model.WorkCard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PokeCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_card);
        WorkCard workCard = (WorkCard) getIntent().getSerializableExtra("pokemon");
        loadPokemon(workCard);
    }

    private void loadPokemon(WorkCard workCard){
        TextView id, name, artist;
        ImageView image;

        id = findViewById(R.id.id_card);
        name = findViewById(R.id.card_name);
        artist = findViewById(R.id.author_card);
        image = findViewById(R.id.card);

       RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);

       name.setText(workCard.getNombre());
       id.setText(workCard.getSalario());
       artist.setText(workCard.getDireccion());

        Glide.with(this).load(workCard.getImageUrl()).apply(options).into(image);
    }
}
