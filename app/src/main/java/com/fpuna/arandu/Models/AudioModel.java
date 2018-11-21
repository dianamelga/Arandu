package com.fpuna.arandu.Models;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.http.HttpResponseCache;
import android.os.Environment;
import android.util.Log;

import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Interfaces.IAudio;
import com.fpuna.arandu.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.spec.ECField;

public class AudioModel implements IAudio.Model {

    private Context context;
    private MediaPlayer mediaPlayer;
    private int currentPosition;


    @Override
    public void descargarAudio(Audio audio) throws Exception {

        //descarga el audio y lo almacena en carpeta de descargas
        //throw new Exception("Error hecho a propósito...");

        Log.d("debug", "urlAudio");
        URL url = new URL(Constante.urlService+"/"+audio.getUrlAudio());
        HttpURLConnection myConnection = (HttpURLConnection) url.openConnection();
        myConnection.setRequestProperty("Accept","application/json");
        myConnection.setRequestMethod("GET");
        myConnection.setReadTimeout(Constante.timeOutConnection);
        myConnection.setConnectTimeout(Constante.timeOutConnection);

        if(myConnection.getResponseCode() == 200) {
            Log.d("debug", "responseMessage: " +myConnection.getResponseMessage());

            int lenghtOfFile = myConnection.getContentLength();

            InputStream input = new BufferedInputStream(url.openStream());


            File audioFile = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
                // Do something for lollipop and above versions
                File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                audioFile = File.createTempFile("audio_"+audio.getId(), ".mp3", storageDir);
            } else{
                // do something for phones running an SDK before lollipop
                audioFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        +"/audio_"+audio.getId()+".mp3");

            }

            Log.d("debug", audioFile.getAbsolutePath());
            OutputStream output = new FileOutputStream(audioFile.getAbsolutePath());

            byte data[] = new byte[1024];
            long total = 0;

            int count;
            while((count = input.read(data)) != -1) {

                total += count;

                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();

        }else{
            throw new Exception("Error al descargar audio. ResponseCode: "+myConnection.getResponseCode());
        }

        //HttpResponseCache myCache = HttpResponseCache.install(getCacheDir(), 100*1000);

    }

    @Override
    public void playAudio(String fileInfo) throws Exception {

        //recibe el url del audio para reproducir

        if(mediaPlayer == null) {
            String url = Constante.urlService + "/"+fileInfo; // your URL here
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

        if(mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                currentPosition = mediaPlayer.getCurrentPosition();
            }
        }

    }

    @Override
    public void stopAudio() throws Exception {

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
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
