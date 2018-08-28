package com.fpuna.arandu.Models;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.fpuna.arandu.Interfaces.IAudio;
import com.fpuna.arandu.R;

import java.security.spec.ECField;

public class AudioModel implements IAudio.Model {

    private Context context;
    private MediaPlayer mediaPlayer = new MediaPlayer();


    public AudioModel() {
        super();
    }


    @Override
    public void descargarAudio() throws Exception {

        //descarga el audio y lo almacena en carpeta de descargas
        throw new Exception("Error hecho a propósito...");
    }

    @Override
    public void playAudio(String fileInfo) throws Exception {
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
    public void pauseAudio() throws Exception{
        //pausa el audio que se esta reproduciendo
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
        else{
            mediaPlayer.start();
        }
    }

    @Override
    public Integer getTiempoTranscurrido() {
        Integer posicion = mediaPlayer.getCurrentPosition();
        return posicion;
    }

    @Override
    public Integer getTiempoAudio() {
        return null;
    }


    @Override
    public void setContext(Context context) {

        this.context = context;
    }


}
