package com.fpuna.arandu.Views;

import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.arandu.Adapters.CategoriaAdapterRecyclerView;
import com.fpuna.arandu.Adapters.CuentoAdapterRecyclerView;
import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Interfaces.ICuento;
import com.fpuna.arandu.Presenters.AudioPresenter;
import com.fpuna.arandu.R;

import java.util.ArrayList;

public class AudiosActivity extends AppCompatActivity implements ICuento.View{

    ICuento.Presenter presenter;
    View reproductor;
    ImageButton play;
    ImageButton pause;
    SearchView mSearchView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios);
        reproductor = (View) findViewById(R.id.reproductor_audio);

        play = reproductor.findViewById(R.id.button_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.playAudio(CuentoAdapterRecyclerView.audio.getUrlAudio());


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
        presenter = new AudioPresenter(this, CategoriaAdapterRecyclerView.categoria);
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
    public void showReproductor(Audio audio) {

        reproductor.setVisibility(View.VISIBLE);
        TextView nombreCuentoAudio = reproductor.findViewById(R.id.nombre_cuento_audio);
        nombreCuentoAudio.setText(audio.getNombre() + " - "+ audio.getAutor());


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
    public void cargarAdapter(ArrayList<Audio> audios) {

        RecyclerView cuentoRecycler = findViewById(R.id.cuento_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        cuentoRecycler.setLayoutManager(linearLayoutManager);

        CuentoAdapterRecyclerView cuentoAdapterRecyclerView = new CuentoAdapterRecyclerView(
                audios, R.layout.cardview_cuento, this, this.presenter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_toolbar, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) AudiosActivity.this.getSystemService(Context.SEARCH_SERVICE);
        mSearchView = (SearchView) searchItem.getActionView();


        if (mSearchView != null) {
            mSearchView.setSearchableInfo(searchManager.getSearchableInfo(AudiosActivity.this.getComponentName()));

            SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener()
            {
                public boolean onQueryTextChange(String newText)
                {
                    //filtrar las categorias
                    return true;
                }

                public boolean onQueryTextSubmit(String query)
                {
                    return true;
                }
            };

            mSearchView.setOnQueryTextListener(queryTextListener);
        }
        return super.onCreateOptionsMenu(menu);

    }
}
