package com.fpuna.arandu.Presenters;

import android.os.AsyncTask;

import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Interfaces.ICuento;
import com.fpuna.arandu.Models.AudioModel;

public class AudioPresenter implements ICuento.Presenter {
    ICuento.Model model;
    ICuento.View view;
    Categoria categoria;

    public AudioPresenter(ICuento.View view, Categoria categoria) {
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

        model.playAudio(urlAudio);
        view.showPause();
        view.hidePlay();
    }

    @Override
    public void pauseAudio() {

        model.pauseAudio();
        view.showPlay();
        view.hidePause();

    }

    public class AsyncDescarga extends AsyncTask<Void, Void, Void>{

        private String urlAudio;

        public AsyncDescarga(String urlAudio) {
            this.urlAudio = urlAudio;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            model.descargarAudio();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(model.getCodResultado() == Constante.OK) {
                view.showSnackBar("Audio desargado.");
            }else{
                view.showSnackBar("No se pudo descargar el audio.");
            }
        }
    }

}
