package com.fpuna.arandu;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.fpuna.arandu.Adapters.CategoriaAdapterRecyclerView;
import com.fpuna.arandu.Interfaces.ICategoria;
import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Presenters.CategoriaPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ICategoria.View {
    public ICategoria.Presenter presenter;
    private ProgressDialog dialogo;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToolbar("Aranduka", false);
        this.dialogo = new ProgressDialog(this);
        presenter = new CategoriaPresenter(this);
        presenter.consultar();


    }


    @Override
    public void showProgressDialog(String message) {
        dialogo.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialogo.setMessage(message);
        dialogo.setCancelable(false);
        dialogo.setMax(50);
        dialogo.show();
    }

    @Override
    public void dismissProgressDialog() {
        if(dialogo != null) {
            dialogo.dismiss();
        }
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cargarAdapter(ArrayList<Categoria> categorias) {

        RecyclerView categoriaRecycler = (RecyclerView) findViewById(R.id.categoria_recycler);

        categoriaRecycler.setLayoutManager(new GridLayoutManager(this, 2));

        CategoriaAdapterRecyclerView categoriaAdapterRecyclerView = new CategoriaAdapterRecyclerView(
                categorias, R.layout.cardview_categoria, this);

        categoriaRecycler.setAdapter(categoriaAdapterRecyclerView);

    }

    @Override
    public Context obtContext() {
        return this;
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        /*para que se vea en versiones anteriores*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        /* en caso de que tenga boton de regreso hacemos que sea visible*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);



    }



}
