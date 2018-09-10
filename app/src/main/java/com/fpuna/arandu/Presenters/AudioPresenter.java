package com.fpuna.arandu.Presenters;

import android.os.AsyncTask;
import android.os.Handler;

import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Interfaces.IAudio;
import com.fpuna.arandu.Models.AudioModel;

public class AudioPresenter implements IAudio.Presenter {
    IAudio.Model model;
    IAudio.View view;
    Categoria categoria;

    public AudioPresenter(IAudio.View view, Categoria categoria) {
        this.view = view;
        this.model = new AudioModel();
        this.categoria = categoria;
    }

    @Override
    public void loadView() {
        this.model.setContext(view.getContext());
        this.view.cargarAdapter(categoria.getAudios());
    }

    @Override
    public void showReproductor(Audio audio) {
        this.view.showReproductor(audio);
    }


    @Override
    public void descargarAudio(String urlAudio) {
        AsyncDescarga asyncDescarga = new AsyncDescarga(urlAudio);
        asyncDescarga.execute();
    }

    @Override
    public void playAudio(String urlAudio) {

        AsyncPlayAudio play = new AsyncPlayAudio(urlAudio);
        play.execute();
        view.showPause();
        view.hidePlay();

    }

    @Override
    public void pauseAudio() {

        try {
            model.pauseAudio();
        } catch (Exception e) {
            e.printStackTrace();
            this.view.showMessage("Error al pausar audio.");
        }
        view.showPlay();
        view.hidePause();

    }

    @Override
    public void stopAudio() {
        try {
            model.stopAudio();
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.showPlay();
        view.hidePause();
    }

    @Override
    public void resumeOnPosition(int position) {
        try {
            this.model.resumeOnPosition(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class AsyncDescarga extends AsyncTask<Void, Void, Void>{

        private String urlAudio;
        private Throwable throwable;

        public AsyncDescarga(String urlAudio) {
            this.urlAudio = urlAudio;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showProgressMessage("Descargando audio...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                model.descargarAudio();
            } catch (Exception e) {
                e.printStackTrace();
                throwable = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            view.hideProgressMessage();
            if(throwable == null) {
                view.showSnackBar("Audio descargado.");
            }else{
                view.showSnackBar("No se pudo descargar el audio.");
            }
        }
    }

    public class AsyncPlayAudio extends AsyncTask<Void, Void, Void> {
        private String urlAudio;
        private Throwable throwable;

        public AsyncPlayAudio(String urlAudio) {
            this.urlAudio = urlAudio;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                model.playAudio(urlAudio);
            } catch (Exception e) {
                e.printStackTrace();
                throwable = e;
                return null;
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showProgressMessage("Preparando audio...");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            view.hideProgressMessage();
            if(throwable != null) {
                view.showMessage("Hubo un error al tratar de reproducir el audio");
                view.showPlay();
                view.hidePause();
                return;
            }

            view.setSeekBarMaxSize(model.getTiempoAudio());

            view.setRunnable(new Runnable() {
                @Override
                public void run() {
                    Handler handler = new Handler();
                    view.setSeekBarProgress(model.getTiempoTranscurrido());
                    handler.postDelayed(this,100);
                }
            });

        }
    }

}
