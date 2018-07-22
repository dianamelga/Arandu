package com.fpuna.arandu.Models;

import android.content.Context;

import com.fpuna.arandu.Clases.Cuento;
import com.fpuna.arandu.Interfaces.ICuento;

import java.util.ArrayList;

public class CuentoModel implements ICuento.Model {
    private int codResultado;
    private String resultado;
    private ArrayList<Cuento> cuentos;
    private Context context;

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
    }

    @Override
    public void pauseAudio() {

        //pausa el audio que se esta reproduciendo
    }

    @Override
    public ArrayList<Cuento> getCuentos() {
        return this.cuentos;
    }

    @Override
    public void setContext(Context context) {

        this.context = context;
    }
}
