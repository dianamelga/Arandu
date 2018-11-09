package com.fpuna.arandu.Interfaces;

import com.fpuna.arandu.Clases.Categoria;

import java.util.ArrayList;

public interface ICategoria {

    public interface Model extends IModel {

        public void consultar() throws Exception;
        public ArrayList<Categoria> getCategorias();
    }

    public interface View extends  IView {

        public void showProgressDialog(String message);
        public void dismissProgressDialog();
        public void showMessage(String message);

        public void cargarAdapter(ArrayList<Categoria> categorias);
    }

    public interface Presenter {
        public void consultar();

    }
}
