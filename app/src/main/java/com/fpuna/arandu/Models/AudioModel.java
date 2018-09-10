package com.fpuna.arandu.Models;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.http.HttpResponseCache;
import android.util.Log;

import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Interfaces.IAudio;
import com.fpuna.arandu.R;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.spec.ECField;

public class AudioModel implements IAudio.Model {

    private Context context;
    private MediaPlayer mediaPlayer;
    private int currentPosition;



    @Override
    public void descargarAudio() throws Exception {

        //descarga el audio y lo almacena en carpeta de descargas
        //throw new Exception("Error hecho a propósito...");

        URL url = new URL(Constante.urlService+"/archivos/mp3/");
        HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();
        myConnection.setRequestProperty("Accept","application/json");
        myConnection.setRequestMethod("GET");

        if(myConnection.getResponseCode() == 200) {
            Log.d("debug", "responseMessage: " +myConnection.getResponseMessage());

        }else{
            throw new Exception("Error al descargar audio. ResponseCode: "+myConnection.getResponseCode());
        }

        //HttpResponseCache myCache = HttpResponseCache.install(getCacheDir(), 100*1000);

    }

    @Override
    public void playAudio(String fileInfo) throws Exception {

        //recibe el url del audio para reproducir

        if(mediaPlayer == null) {
            String url = fileInfo; // your URL here
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
        }else{
            this.resumeOnPosition(currentPosition);
        }
    }

    @Override
    public void pauseAudio() throws Exception{
        //pausa el audio que se esta reproduciendo

        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            currentPosition = mediaPlayer.getCurrentPosition();
        }

    }

    @Override
    public void stopAudio() throws Exception {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public void resumeOnPosition(int position) throws Exception {
        if(mediaPlayer != null) {
            this.pauseAudio();
            mediaPlayer.seekTo(position);
            mediaPlayer.start();
            currentPosition = position;
        }
    }

    @Override
    public Integer getTiempoTranscurrido() {
        if(mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }else {
            return 0;
        }
    }

    @Override
    public int getTiempoAudio() {
        if(mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }else{
            return 0;
        }
    }


    @Override
    public void setContext(Context context) {

        this.context = context;
    }


}
