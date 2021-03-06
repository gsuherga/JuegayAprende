package com.example.android.juegayaprende;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*
    Variables globales para puntos y número de preguntas. Global variables for points and number of questions.
     */

    int recuento = 0;
    int acertadas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void juega(View view){


        Random r = new Random();
        int formato =  r.nextInt();
        Intent intent;

        /*
            Aquí decidimos formato vertical o apaisado de forma aleatoria. To choose horizontal or vertical activity.
         */

        if (formato % 2 == 0){
            intent = new Intent(this, horizontal.class);

        } else {
            intent = new Intent(this, vertical.class);

        }
        intent.putExtra("acertadas", acertadas);
        intent.putExtra("recuento", recuento);

        if (intent != null) {

            startActivity(intent);
        }

    }

}
