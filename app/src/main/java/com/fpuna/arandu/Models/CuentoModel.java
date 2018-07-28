package com.fpuna.arandu.Models;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Toast;


import com.fpuna.arandu.Clases.Cuento;
import com.fpuna.arandu.Interfaces.ICuento;

import java.io.IOException;
import java.util.ArrayList;

public class CuentoModel implements ICuento.Model {
    private int codResultado;
    private String resultado;
    private Context context;

    public CuentoModel() {
        super();
    }

    @Override
    public int getCodResultado() {
        return this.codResultado;
    }

    @Override
    public String getResultado() {
        return this.resultado;
    }

    @Override
    public void descargarAudio() {

        //descarga el audio y lo almacena en carpeta de descargas
    }

    @Override
    public void playAudio(String urlAudio) {
        //recibe el url del audio para reproducir
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource(urlAudio);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    @Override
    public void pauseAudio() {

        //pausa el audio que se esta reproduciendo
    }


    @Override
    public void setContext(Context context) {

        this.context = context;
    }
}
