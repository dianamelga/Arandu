package com.fpuna.arandu.Interfaces;

import com.fpuna.arandu.Clases.Audio;

import java.util.ArrayList;

public interface IAudio {

    public interface Model extends IModel {
        public void descargarAudio() throws Exception;
        public void playAudio(String urlAudio) throws Exception;
        public void pauseAudio() throws Exception;
        public Integer getTiempoTranscurrido();
        public Integer getTiempoAudio();




    }

    public interface View extends IView {
        public void showSnackBar(String message);
        public void showMessage(String message);
        public void showReproductor(Audio audio);
        public void showPlay();
        public void showPause();
        public void hidePlay();
        public void hidePause();

        public void cargarAdapter(ArrayList<Audio> audios);


    }

    public interface Presenter {
        public void loadView();
        public void showReproductor(Audio audio);

        public void descargarAudio(String urlAudio);
        public void playAudio(String urlAudio);
        public void pauseAudio();
    }
}
