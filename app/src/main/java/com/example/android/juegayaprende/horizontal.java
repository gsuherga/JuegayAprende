package com.example.android.juegayaprende;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by jesus on 1/04/17.
 */

public class horizontal extends AppCompatActivity {

    //Recuperamos el número de preguntas acertadas y respondidas.

    //Variables para los puntos.
    int acertadas;
    int recuento;

    //Variables para saber si sumar puntos o no si el usuario cambia de decisión.
    boolean sumarPuntoEdificio = true;
    boolean sumarPuntoCiudad = true;
    boolean restarPuntoEdificio = false;
    boolean restarPuntoCiudad = false;

    // Variables para la foto y los radiobotones
    int Imagen;
    int Imagen0;
    String radioButton1,radioButton2,radioButton4,radioButton5;
    String correctae ="0", correctac ="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal);
        Intent intent = getIntent();
        acertadas = intent.getIntExtra("acertadas",0);
        recuento = intent.getIntExtra("recuento",0);

        // JESUS
        //generar();

        // JAVI
        this.generar();

    }


    public void generar() {

        // Creamos un vector con las imágenes disponibles
        int [] imagenes = {R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9};

        // JESUS
        // Creamos un vector con los edificios disponibles
//       Resources edif = getResources();
//       String[] edificio = edif.getStringArray(R.array.edificio);
//
//       // Creamos un vector con las ciudades disponibles
//
//        Resources ciud = getResources();
//        String[] ciudades = ciud.getStringArray(R.array.ciudad);

        // JAVI
        Resources resources = getResources();
        // Creamos un vector con los edificios disponibles
        String[] edificio = resources.getStringArray(R.array.edificio);
        // Creamos un vector con las ciudades disponibles
        String[] ciudades = resources.getStringArray(R.array.ciudad);


        // Aqui decimos donde queremos que ponga la imagen
        ImageView image = (ImageView) (findViewById(R.id.foto_horizontal));

        // Aqui elegimos una foto al azar
        Random fotos = new Random();
        int f = fotos.nextInt(imagenes.length);
        image.setImageResource(imagenes[f]);
        Imagen = imagenes[f];
        Imagen0 = imagenes[0];


        // Aqui elegimos respuestas al azar: un edificio y una ciudad. La opcion "ninguna" esta siempre disponible por si ninguna respuesta es correcta.
        int opciones = 1;

        do {

            Random RespEdificios = new Random();
            int r = RespEdificios.nextInt(edificio.length);

            if (opciones == 1) {
                TextView radiobutton = (TextView) (findViewById(R.id.primera));
                radiobutton.setText(edificio[r]);
                radioButton1 = edificio[r];
            }else if(opciones == 2){
                TextView radiobutton = (TextView) (findViewById(R.id.segunda));
                radiobutton.setText(edificio[r]);
                radioButton2 = edificio[r];
            }else if(opciones == 3){
                TextView radiobutton = (TextView) (findViewById(R.id.tercera));
                radiobutton.setText(R.string.Ninguna);

            }
            opciones = opciones + 1;

        }while(opciones <= 3);



        opciones = 1;

        do {

            Random RespCiudades = new Random();
            int i = RespCiudades.nextInt(ciudades.length);

            if (opciones == 1) {
                TextView radiobutton = (TextView) (findViewById(R.id.cuarta));
                radiobutton.setText(ciudades[i]);
                radioButton4 = ciudades[i];
            }else if(opciones == 2){
                TextView radiobutton = (TextView) (findViewById(R.id.quinta));
                radiobutton.setText(ciudades[i]);
                radioButton5 = ciudades[i];
            }else if(opciones == 3){
                TextView radiobutton = (TextView) (findViewById(R.id.sexta));
                radiobutton.setText(R.string.Ninguna);
            }
            opciones = opciones +1;
        }while(opciones <= 3);

        // JESUS
        if (Imagen == Imagen0) {

            correctae = getString(R.string.Pasaje);
            correctac = getString(R.string.Albacete);

        } else if (Imagen == Imagen0 + 1) {

            correctae = getString(R.string.Alcazar);
            correctac = getString(R.string.Sevilla);

        } else if (Imagen == Imagen0 + 2) {

            correctae = getString(R.string.Plaza);
            correctac = getString(R.string.Sevilla);

        } else if (Imagen == Imagen0 + 3) {

            correctae = getString(R.string.Alhambra);
            correctac = getString(R.string.Granada);

        }else if (Imagen == Imagen0 + 4) {

            correctae = getString(R.string.Basilica);
            correctac = getString(R.string.Barcelona);

        }else if (Imagen == Imagen0 + 5) {

            correctae = getString(R.string.Catedral);
            correctac = getString(R.string.Leon);

        }else if (Imagen == Imagen0 + 6) {

            correctae = getString(R.string.Catedral);
            correctac = getString(R.string.Sevilla);

        }else if (Imagen == Imagen0 + 7) {

            correctae = getString(R.string.Mezquita);
            correctac = getString(R.string.Cordoba);

        }else if (Imagen == Imagen0 + 8) {

            correctae = getString(R.string.Plaza);
            correctac = getString(R.string.Madrid);
        }

        // JAVI
/*        String[] edificiosCorrectos = {getString(R.string.Pasaje), getString(R.string.Alcazar), getString(R.string.Plaza), getString(R.string.Alhambra), getString(R.string.Basilica), getString(R.string.Catedral), getString(R.string.Catedral), getString(R.string.Mezquita), getString(R.string.Plaza)};
        String[] ciudadesCorrectas = {getString(R.string.Albacete), getString(R.string.Sevilla), getString(R.string.Sevilla), getString(R.string.Granada), getString(R.string.Barcelona), getString(R.string.Leon), getString(R.string.Sevilla), getString(R.string.Cordoba), getString(R.string.Madrid)};

        correctae = edificiosCorrectos[Imagen];
        correctac = ciudadesCorrectas[Imagen]; */
    }

    public void Edificios (View view) {
        //Boton marcada para el edificio
        boolean marcadoe = ((RadioButton) view).isChecked();

        // JAVI
        // Comprobamos si esta marcado el boton solo una vez y fuera del switch.
        // Creamos metodos para sumar y restar aciertos.
        if (marcadoe) {
            switch (view.getId()) {

                case R.id.primera:
                    if (radioButton1.equals(correctae) && sumarPuntoEdificio == true) {
                        this.sumarEdificioAcertado();
                    }else if(!radioButton1.equals(correctae) && restarPuntoEdificio == true){
                        this.restarEdificioAcertado();
                    }
                    break;

                case R.id.segunda:
                    if (radioButton2.equals(correctae) && sumarPuntoEdificio == true) {
                        this.sumarEdificioAcertado();
                    }else if(!radioButton2.equals(correctae) && restarPuntoEdificio == true){
                        this.restarEdificioAcertado();
                    }
                    break;

                case R.id.tercera:
                    if (!radioButton1.equals(correctae) && !radioButton2.equals(correctae) && sumarPuntoEdificio == true) {
                        this.sumarEdificioAcertado();
                    }else if(radioButton1.equals(correctae) || radioButton2.equals(correctae) && restarPuntoEdificio == true){
                        this.restarEdificioAcertado();
                    }
                    break;
            }
        }

        // JESUS
        //Para ver si el edificio es correcto
//        switch (view.getId()) {
//            case R.id.primera:
//                if (marcadoe) {
//
//                    if (radioButton1.equals(correctae) && sumarPuntoEdificio == true) {
//                        acertadas = acertadas + 1;
//                        sumarPuntoEdificio = false;
//                        restarPuntoEdificio = true;
//                    }else if(!radioButton1.equals(correctae) && restarPuntoEdificio == true){
//                        acertadas = acertadas - 1;
//                        sumarPuntoEdificio = true;
//                        restarPuntoEdificio = false;
//                    }
//                }
//                break;
//            case R.id.segunda:
//                if (marcadoe) {
//                    if (radioButton2.equals(correctae) && sumarPuntoEdificio == true) {
//                        acertadas = acertadas + 1;
//                        sumarPuntoEdificio = false;
//                        restarPuntoEdificio = true;
//                    }else if(!radioButton2.equals(correctae) && restarPuntoEdificio == true){
//                        acertadas = acertadas - 1;
//                        sumarPuntoEdificio = true;
//                        restarPuntoEdificio = false;
//                    }
//                }
//                break;
//            case R.id.tercera:
//                if (marcadoe) {
//                    if (!radioButton1.equals(correctae) && !radioButton2.equals(correctae) && sumarPuntoEdificio == true) {
//                        acertadas = acertadas + 1;
//                        sumarPuntoEdificio = false;
//                        restarPuntoEdificio = true;
//                    }else if(radioButton1.equals(correctae) || radioButton2.equals(correctae) && restarPuntoEdificio == true){
//                        acertadas = acertadas - 1;
//                        sumarPuntoEdificio = true;
//                        restarPuntoEdificio = false;
//                    }
//                }
//                break;
//        }

    }

    // JAVI
    public void sumarEdificioAcertado() {
        acertadas = acertadas + 1;
        sumarPuntoEdificio = false;
        restarPuntoEdificio = true;
    }

    // JAVI
    public void restarEdificioAcertado() {
        acertadas = acertadas - 1;
        sumarPuntoEdificio = true;
        restarPuntoEdificio = false;
    }

    public void ciudades (View view) {

        //Boton marcada para la ciudad
        boolean marcadoc = ((RadioButton) view).isChecked();

        // JAVI
        // Comprobamos si esta marcado el boton solo una vez y fuera del switch.
        // Creamos metodos para sumar y restar aciertos.
        if (marcadoc) {
            switch (view.getId()) {
                case R.id.cuarta:
                    if (radioButton4.equals(correctac) && sumarPuntoCiudad == true) {
                        this.sumarCiudadAcertado();
                    }else if(!radioButton4.equals(correctae) && restarPuntoCiudad == true){
                        this.restarCiudadAcertado();
                    }
                    break;
                case R.id.quinta:
                    if (radioButton5.equals(correctac) && sumarPuntoCiudad == true) {
                        this.sumarCiudadAcertado();
                    }else if(!radioButton5.equals(correctae) && restarPuntoCiudad ==true){
                        this.restarCiudadAcertado();
                    }
                    break;
                case R.id.sexta:
                    if (!radioButton4.equals(correctac) && !radioButton5.equals(correctac) && sumarPuntoCiudad == true) {
                        this.sumarCiudadAcertado();
                    }else if(radioButton4.equals(correctae) || radioButton5.equals(correctae) && restarPuntoCiudad == true){
                        this.restarCiudadAcertado();
                    }
                    break;
            }
        }

//        switch (view.getId()) {
//        case R.id.cuarta:
//            if (marcadoc) {
//                if (radioButton4.equals(correctac) && sumarPuntoCiudad == true) {
//                    acertadas = acertadas + 1;
//                    sumarPuntoCiudad = false;
//                    restarPuntoCiudad = true;
//                }else if(!radioButton4.equals(correctae) && restarPuntoEdificio == true){
//                    acertadas = acertadas - 1;
//                    restarPuntoEdificio = false;
//                    sumarPuntoEdificio = true;
//                }
//            }
//            break;
//        case R.id.quinta:
//            if (marcadoc) {
//                if (radioButton5.equals(correctac) && sumarPuntoCiudad == true) {
//                    acertadas = acertadas + 1;
//                    sumarPuntoCiudad = false;
//                    restarPuntoCiudad = true;
//                }else if(!radioButton5.equals(correctae) && restarPuntoEdificio ==true){
//                    acertadas = acertadas - 1;
//                    restarPuntoEdificio = false;
//                    sumarPuntoEdificio = true;
//                }
//            }
//            break;
//        case R.id.sexta:
//            if (marcadoc) {
//                if (!radioButton4.equals(correctac) && !radioButton5.equals(correctac) && sumarPuntoCiudad == true) {
//                    acertadas = acertadas + 1;
//                    sumarPuntoCiudad = false;
//                    restarPuntoCiudad = true;
//                }else if(radioButton4.equals(correctae) || radioButton5.equals(correctae) && restarPuntoEdificio ==true){
//                    acertadas = acertadas - 1;
//                    restarPuntoEdificio = false;
//                    sumarPuntoEdificio = true;
//                }
//            }
//            break;
//    }

    }

    public void sumarCiudadAcertado() {
        acertadas = acertadas + 1;
        sumarPuntoCiudad = false;
        restarPuntoCiudad = true;
    }

    public void restarCiudadAcertado() {
        acertadas = acertadas - 1;
        restarPuntoCiudad = false;
        sumarPuntoCiudad = true;
    }


    public void seguir(View view) {
        sumarPuntoCiudad = true;
        sumarPuntoEdificio = true;
        restarPuntoCiudad = false;
        restarPuntoEdificio = false;
        recuento = recuento +2;

        if (recuento == 20){
            mostrarPuntos(acertadas,recuento);

        }else {

            Random r = new Random();
            int formato = 2; //r.nextInt();

            // Aqui decidimos formato vertical o apaisado de forma aleatoria.
            if (formato % 2 == 0){
                Intent otrapregunta = new Intent(horizontal.this, horizontal.class);
                otrapregunta.putExtra("acertadas", acertadas);
                otrapregunta.putExtra("recuento",recuento);
                startActivity(otrapregunta);

            }else{
                Intent otrapregunta = new Intent(horizontal.this, vertical.class);
                otrapregunta.putExtra("acertadas", acertadas);
                otrapregunta.putExtra("recuento",recuento);

                startActivity(otrapregunta);
            }
        }

    }

    public void mostrarPuntos(int acertadas, int recuento){
        TextView puntuacion = (TextView) findViewById(R.id.Puntuacion);
        puntuacion.setText(getString(R.string.puntos)+acertadas+"\n"+getString(R.string.fallos)+(recuento-acertadas)+"\n"+getString(R.string.pulsa));
        puntuacion.setVisibility(View.VISIBLE);
    }

    public void reiniciar(View view) {
        final Context context = this;
        Intent intent = new Intent(context, MainActivity.class);
        TextView puntuacion = (TextView) findViewById(R.id.Puntuacion);
        puntuacion.setVisibility(View.INVISIBLE);
        startActivity(intent);
    }


}