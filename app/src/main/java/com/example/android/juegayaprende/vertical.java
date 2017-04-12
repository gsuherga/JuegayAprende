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

public class vertical extends AppCompatActivity {

   /*
   Recuperamos el número de preguntas acertadas y respondidas.
    */

    //TODO: JESUS: Controlar si tiene estos valores tras leer los extra del intent.

    /*
    Variables para los puntos.
     */
    int acertadas;
    int recuento;

    /*
    Variables para saber si sumar puntos o no si el usuario cambia de decisión.
     */
    boolean sumarPuntoEdificio = true;
    boolean sumarPuntoCiudad = true;
    boolean restarPuntoEdificio = false;
    boolean restarPuntoCiudad = false;

    /*
    Variables para la foto y los radiobotones
     */

    int Imagen;
    int Imagen0;
    String radioButton1,radioButton2,radioButton4,radioButton5;
    String correctae ="0", correctac ="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertical);
        Intent intent = getIntent();
        acertadas = intent.getIntExtra("acertadas",0);
        recuento = intent.getIntExtra("recuento",0);


        this.generar();
    }

    public void generar() {

        /*
        Creamos un vector con las imágenes disponibles
         */

        int[] imagenes = {R.drawable.v1, R.drawable.v2, R.drawable.v3};


        Resources resources = getResources();
        /*
        Creamos un vector con los edificios disponibles
         */
        String[] edificio = resources.getStringArray(R.array.edificio);
        /*
        Creamos un vector con las ciudades disponibles
         */
        String[] ciudades = resources.getStringArray(R.array.ciudad);

        /*
        Aquí decimos donde queremos que ponga la imagen
         */
        ImageView imagen = (ImageView) (findViewById(R.id.foto_vertical));

        /*
        Aquí elegimos una foto al azar
         */

        Random fotos = new Random();
        int f = fotos.nextInt(imagenes.length);
        imagen.setImageResource(imagenes[f]);
        Imagen = imagenes[f];
        Imagen0 = imagenes[0];

        /*
        Aquí elegimos respuestas al azar: un edificio y una ciudad. La opción "ninguna" está siempre disponible por si ninguna respuesta es correcta.
         */
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

        if (Imagen == Imagen0) {

            correctae = getString(R.string.Acueducto);
            correctac = getString(R.string.Segovia);

        } else if (Imagen == Imagen0 + 1) {

            correctae = getString(R.string.Catedral);
            correctac = getString(R.string.Burgos);

        } else if (Imagen == Imagen0 + 2) {

            correctae = getString(R.string.Catedral);
            correctac = getString(R.string.Santiago);

        }
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
    }

    public void sumarEdificioAcertado() {
        acertadas = acertadas + 1;
        sumarPuntoEdificio = false;
        restarPuntoEdificio = true;
    }

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
                    } else if (!radioButton4.equals(correctae) && restarPuntoCiudad == true) {
                        this.restarCiudadAcertado();
                    }
                    break;
                case R.id.quinta:
                    if (radioButton5.equals(correctac) && sumarPuntoCiudad == true) {
                        this.sumarCiudadAcertado();
                    } else if (!radioButton5.equals(correctae) && restarPuntoCiudad == true) {
                        this.restarCiudadAcertado();
                    }
                    break;
                case R.id.sexta:
                    if (!radioButton4.equals(correctac) && !radioButton5.equals(correctac) && sumarPuntoCiudad == true) {
                        this.sumarCiudadAcertado();
                    } else if (radioButton4.equals(correctae) || radioButton5.equals(correctae) && restarPuntoCiudad == true) {
                        this.restarCiudadAcertado();
                    }
                    break;
            }
        }
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
        recuento = recuento + 2 ;

        if (recuento == 20){
            mostrarPuntos(acertadas,recuento);
        }else {

            Random r = new Random();
            int formato = r.nextInt();

              /*
            Aquí decidimos formato vertical o apaisado de forma aleatoria.
         */

            if (formato % 2 == 0){
                Intent otrapregunta = new Intent(vertical.this, horizontal.class);
                otrapregunta.putExtra("acertadas", acertadas);
                otrapregunta.putExtra("recuento",recuento);
                startActivity(otrapregunta);
            }else{
                Intent otrapregunta = new Intent(vertical.this, vertical.class);
                otrapregunta.putExtra("acertadas", acertadas);
                otrapregunta.putExtra("recuento",recuento);

                startActivity(otrapregunta);
            }
        }

    }

    public void mostrarPuntos(int acertadas, int recuento){
        ImageView seguir = (ImageView) findViewById(R.id.seguir);
        ImageView reiniciar = (ImageView) findViewById(R.id.reiniciar);
        TextView puntuacion = (TextView) findViewById(R.id.Puntuacion);
        seguir.setVisibility(View.INVISIBLE);
        reiniciar.setVisibility(View.INVISIBLE);
        puntuacion.setText(getString(R.string.puntos)+acertadas+"\n"+getString(R.string.fallos)+(recuento-acertadas)+"\n"+getString(R.string.pulsa));
        puntuacion.setVisibility(View.VISIBLE);
    }

    public void reiniciar(View view) {
        ImageView seguir = (ImageView) findViewById(R.id.seguir);
        ImageView reiniciar = (ImageView) findViewById(R.id.reiniciar);
        seguir.setVisibility(View.VISIBLE);
        reiniciar.setVisibility(View.VISIBLE);
        final Context context = this;
        Intent intent = new Intent(context, MainActivity.class);
        TextView puntuacion = (TextView) findViewById(R.id.Puntuacion);
        puntuacion.setVisibility(View.INVISIBLE);
        startActivity(intent);
    }

}
