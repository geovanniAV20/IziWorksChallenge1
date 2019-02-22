package android.itesm.edu.pokemon.adapters;

import android.content.Context;
import android.content.Intent;
import android.itesm.edu.pokemon.R;
import android.itesm.edu.pokemon.Work_Card;
import android.itesm.edu.pokemon.model.WorkCard;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class WorksRecycleAdapter
        extends RecyclerView.Adapter<WorksRecycleAdapter.WorkRecordHolder>{

    private Context context;
    private List<WorkCard> cards;
    RequestOptions options;

    public WorksRecycleAdapter(Context context, List<WorkCard> cards) {
        this.context = context;
        this.cards = cards;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.load_card).error(R.drawable.load_card);
    }

    @NonNull
    @Override
    public WorkRecordHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate( R.layout.activity_poke_card,viewGroup,false);
        final WorkRecordHolder workRecordHolder = new WorkRecordHolder(view);
        workRecordHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                WorkCard workCard = cards.get(workRecordHolder.getAdapterPosition());
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(context, Work_Card.class);
                it.putExtra("works", workCard);
                context.startActivity(it);
            }
        });
        return workRecordHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkRecordHolder workRecordHolder, int i) {
        workRecordHolder.name.setText(cards.get(i).getNombre());
        workRecordHolder.id.setText(cards.get(i).getDias().toString());
        workRecordHolder.artist.setText(cards.get(i).getSalario());

        Glide.with(context).load(cards.get(i).getImageUrl()).apply(options).into(workRecordHolder.image);
    }

    @Override
    public int getItemCount() {

        return cards.size();
    }

    public static class WorkRecordHolder extends RecyclerView.ViewHolder{

        TextView id, name, artist;
        ImageView image;

        public WorkRecordHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_card);
            name = itemView.findViewById(R.id.card_name);
            artist = itemView.findViewById(R.id.author_card);
            image = itemView.findViewById(R.id.card);
        }
    }
}
