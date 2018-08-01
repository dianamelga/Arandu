package com.fpuna.arandu;

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
    ICategoria.Presenter presenter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToolbar("Aranduka", false);
        presenter = new CategoriaPresenter(this);
        presenter.consultar();


    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

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
    public Context getContext() {
        return getApplicationContext();
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
