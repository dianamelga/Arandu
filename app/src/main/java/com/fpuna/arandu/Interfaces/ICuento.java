package com.fpuna.arandu.Interfaces;

import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Clases.Cuento;

import java.util.ArrayList;

public interface ICuento {

    public interface Model extends IModel {
        public int getCodResultado();
        public String getResultado();
        public void descargarAudio();
        public void playAudio(String urlAudio);
        public void pauseAudio();

        public ArrayList<Cuento> getCuentos();

    }

    public interface View extends IView {
        public void showSnackBar(String message);
        public void showMessage(String message);
        public void showReproductor(Cuento cuento);
        public void showPlay();
        public void showPause();
        public void hidePlay();
        public void hidePause();

        public void cargarAdapter(ArrayList<Cuento> cuentos);

    }

    public interface Presenter {
        public void loadView();
        public void showReproductor(Cuento cuento);

        public void descargarAudio(String urlAudio);
        public void playAudio(String urlAudio);
        public void pauseAudio();
    }
}
