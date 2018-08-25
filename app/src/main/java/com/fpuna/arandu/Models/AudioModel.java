package com.fpuna.arandu.Models;

import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import com.fpuna.arandu.Interfaces.ICuento;
import com.fpuna.arandu.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

public class AudioModel implements ICuento.Model {
    private int codResultado;
    private String resultado;
    private Context context;
    private MediaPlayer mediaPlayer = new MediaPlayer();


    public AudioModel() {
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
    public void playAudio(String fileInfo) {
        //recibe el url del audio para reproducir
        //fileInfo = "http://localhost/~luiscapde/mp3/despacito.mp3";
        fileInfo = "http://www.all-birds.com/Sound/white%20geese%20shrt.wav";
        try{
            //mediaPlayer.create(this.context, Uri.parse(fileInfo));
            /*mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(fileInfo);
            mediaPlayer.prepare();*/
            //inicion
            //estos metodos son para cuando el arhivo se guarda dentro de app
            mediaPlayer = MediaPlayer.create(this.context, R.raw.despacito);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            //fin
            mediaPlayer.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void pauseAudio() {
        //pausa el audio que se esta reproduciendo
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
        else{
            mediaPlayer.start();
        }
    }


    @Override
    public void setContext(Context context) {

        this.context = context;
    }

    @Override
    public int  tiempoTranscurrido(){
        int posicion = mediaPlayer.getCurrentPosition();
        return posicion;

    }
}
