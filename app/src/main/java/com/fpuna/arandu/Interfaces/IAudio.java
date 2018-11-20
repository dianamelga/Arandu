package com.fpuna.arandu.Interfaces;

import com.fpuna.arandu.Clases.Audio;

import java.util.ArrayList;

public interface IAudio {

    public interface Model extends IModel {
        public void descargarAudio(Audio audio) throws Exception;
        public void playAudio(String urlAudio) throws Exception;
        public void pauseAudio() throws Exception;
        public void stopAudio() throws Exception;
        public void resumeOnPosition(int position) throws Exception;
        public Integer getTiempoTranscurrido();
        public int getTiempoAudio();




    }

    public interface View extends IView {
        public void showSnackBar(String message);
        public void showMessage(String message);
        public void showReproductor(Audio audio);
        public void showProgressMessage(String message);
        public void hideProgressMessage();
        public void showPlay();
        public void showPause();
        public void hidePlay();
        public void hidePause();

        public void cargarAdapter(ArrayList<Audio> audios);
        public void setSeekBarMaxSize(int seekBarMaxSize);
        public void setSeekBarProgress(int progress);
        public void setRunnable(Runnable runnable);


    }

    public interface Presenter {
        public void loadView();
        public void showReproductor(Audio audio);

        public void descargarAudio(Audio audio);
        public void playAudio(String urlAudio);
        public void pauseAudio();
        public void stopAudio();
        public void resumeOnPosition(int position);
    }
}
