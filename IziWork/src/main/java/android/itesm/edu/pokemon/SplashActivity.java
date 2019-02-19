package android.itesm.edu.pokemon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {// a thread in Android
            @Override
            public void run() {
                Intent intent = new Intent( SplashActivity.this  , MainActivity.class  );
                startActivity(intent); // Go, go, go
                finish(); // kill this activity
            }
        },3000); // time in milliseconds

    }



}
