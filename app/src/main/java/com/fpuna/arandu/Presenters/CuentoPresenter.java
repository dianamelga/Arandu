package com.fpuna.arandu.Presenters;

import android.os.AsyncTask;

import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Clases.Cuento;
import com.fpuna.arandu.Interfaces.ICuento;
import com.fpuna.arandu.Models.CuentoModel;

public class CuentoPresenter implements ICuento.Presenter {
    ICuento.Model model;
    ICuento.View view;
    Categoria categoria;

    public CuentoPresenter(ICuento.View view, Categoria categoria) {
        this.view = view;
        this.model = new CuentoModel();
        this.categoria = categoria;
    }

    @Override
    public void loadView() {
        this.model.setContext(view.getContext());
        this.view.cargarAdapter(categoria.getCuentos());
    }

    @Override
    public void showReproductor(Cuento cuento) {
        this.view.showReproductor(cuento);
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
    }

    @Override
    public void pauseAudio() {

        model.pauseAudio();
        view.showPlay();

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
