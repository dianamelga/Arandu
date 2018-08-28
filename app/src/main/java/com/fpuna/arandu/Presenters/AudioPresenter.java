package com.fpuna.arandu.Presenters;

import android.os.AsyncTask;

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
        view.showSnackBar("Descargando audio...");
        AsyncDescarga asyncDescarga = new AsyncDescarga(urlAudio);
        asyncDescarga.execute();
    }

    @Override
    public void playAudio(String urlAudio) {

        try {
            model.playAudio(urlAudio);
        } catch (Exception e) {
            e.printStackTrace();
            this.view.showMessage("Error al reproducir audio.");
            return;
        }
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

    public class AsyncDescarga extends AsyncTask<Void, Void, Void>{

        private String urlAudio;
        private Throwable throwable;

        public AsyncDescarga(String urlAudio) {
            this.urlAudio = urlAudio;
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
            if(throwable == null) {
                view.showSnackBar("Audio desargado.");
            }else{
                view.showSnackBar("No se pudo descargar el audio.");
            }
        }
    }

}
