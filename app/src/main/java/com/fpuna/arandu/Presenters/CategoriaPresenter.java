package com.fpuna.arandu.Presenters;

import android.os.AsyncTask;
import android.util.Log;

import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Interfaces.ICategoria;
import com.fpuna.arandu.Models.CategoriaModel;

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
                String mensaje = throwable.getMessage();
                if(throwable instanceof ConnectException ||
                        throwable.getMessage().contains("EHOSTUNREACH"))  {
                    mensaje = "Servidor no disponible.";
                }else if(throwable instanceof SocketTimeoutException)  {
                    if (throwable.getMessage() != null) {
                        if (throwable.getMessage().contains("failed to connect to") ||
                                throwable instanceof SSLException ||
                                throwable instanceof  UnknownHostException) {
                            mensaje = "Sin conexión.";
                        }
                    }else {
                        mensaje = "El servidor tardó mucho en responder.";
                    }
                }else if(throwable instanceof SocketException) {
                    if (throwable.getMessage() != null){
                        if (throwable.getMessage().contains("ECONNREFUSED") ||
                                throwable.getMessage().contains("refused")){
                            mensaje = "Servicio no disponible";
                        }
                    }
                }

                view.showMessage(mensaje);
            }else{
                loadView();
            }

        }
    }
}
