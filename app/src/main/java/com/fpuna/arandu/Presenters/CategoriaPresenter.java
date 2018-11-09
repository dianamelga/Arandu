package com.fpuna.arandu.Presenters;

import android.os.AsyncTask;
import android.util.Log;

import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Interfaces.ICategoria;
import com.fpuna.arandu.Models.CategoriaModel;
import com.fpuna.arandu.Utils.ErrorMessage;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

public class CategoriaPresenter implements ICategoria.Presenter {
    private ICategoria.Model model;
    private ICategoria.View view;

    public CategoriaPresenter(ICategoria.View view) {
        this.view = view;
        this.model = new CategoriaModel();
    }

    @Override
    public void consultar() {


        AsyncCategoria asyncCategoria = new AsyncCategoria();
        asyncCategoria.execute();

    }


    private void loadView() {

        view.cargarAdapter(model.getCategorias());

    }

    private class AsyncCategoria extends AsyncTask<Void, Void, Void> {

        private Throwable throwable;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            view.showProgressDialog("Preparando audios...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            model.setContext(view.obtContext());
            try {
                model.consultar();
            } catch (Exception e) {
                e.printStackTrace();
                throwable = e;
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            view.dismissProgressDialog();
            if(throwable != null) {
                ErrorMessage errorMessage = new ErrorMessage();
                view.showMessage(errorMessage.get(throwable));
            }else{
                loadView();
            }

        }
    }
}
