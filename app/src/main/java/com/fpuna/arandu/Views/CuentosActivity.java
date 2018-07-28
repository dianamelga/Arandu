package com.fpuna.arandu.Views;

import android.content.Context;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.arandu.Adapters.CategoriaAdapterRecyclerView;
import com.fpuna.arandu.Adapters.CuentoAdapterRecyclerView;
import com.fpuna.arandu.Clases.Cuento;
import com.fpuna.arandu.Interfaces.ICuento;
import com.fpuna.arandu.Presenters.CuentoPresenter;
import com.fpuna.arandu.R;

import java.util.ArrayList;

public class CuentosActivity extends AppCompatActivity implements ICuento.View{

    public ICuento.Presenter presenter;
    public View reproductor;
    public ImageButton play;
    public ImageButton pause;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos);
        reproductor = (View) findViewById(R.id.reproductor_audio);

        play = reproductor.findViewById(R.id.button_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.playAudio("");

            }
        });

        pause = reproductor.findViewById(R.id.button_pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.pauseAudio();
            }
        });

        showToolbar(CategoriaAdapterRecyclerView.categoria.getNombreCastellano(), true);
        presenter = new CuentoPresenter(this, CategoriaAdapterRecyclerView.categoria);
        presenter.loadView();
    }

    @Override
    public void showSnackBar(String message) {

        Snackbar.make(getCurrentFocus(), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showReproductor(Cuento cuento) {

        reproductor.setVisibility(View.VISIBLE);
        TextView nombreCuentoAudio = reproductor.findViewById(R.id.nombre_cuento_audio);
        nombreCuentoAudio.setText(cuento.getNombre() + " - "+cuento.getAutor());


    }

    @Override
    public void showPlay() {


        reproductor.findViewById(R.id.button_play).setVisibility(View.VISIBLE);
    }

    @Override
    public void showPause() {

        reproductor.findViewById(R.id.button_pause).setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePlay() {
        reproductor.findViewById(R.id.button_play).setVisibility(View.GONE);
    }

    @Override
    public void hidePause() {

        reproductor.findViewById(R.id.button_pause).setVisibility(View.GONE);
    }


    @Override
    public void cargarAdapter(ArrayList<Cuento> cuentos) {

        RecyclerView cuentoRecycler = findViewById(R.id.cuento_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        cuentoRecycler.setLayoutManager(linearLayoutManager);

        CuentoAdapterRecyclerView cuentoAdapterRecyclerView = new CuentoAdapterRecyclerView(
                cuentos, R.layout.cardview_cuento, this, this.presenter);

        cuentoRecycler.setAdapter(cuentoAdapterRecyclerView);
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
