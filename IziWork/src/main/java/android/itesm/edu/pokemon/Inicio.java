package android.itesm.edu.pokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void goWorks(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goHorario(View view){
        Intent intent = new Intent(this, Horario.class);
        startActivity(intent);

    }

    public void goPerfil(View view){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);

    }
}
