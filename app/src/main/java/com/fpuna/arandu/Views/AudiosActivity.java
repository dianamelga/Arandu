package com.fpuna.arandu.Views;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.arandu.Adapters.CategoriaAdapterRecyclerView;
import com.fpuna.arandu.Adapters.CuentoAdapterRecyclerView;
import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Interfaces.IAudio;
import com.fpuna.arandu.Presenters.AudioPresenter;
import com.fpuna.arandu.R;
import com.fpuna.arandu.Utils.MostrarAlerta;

import java.util.ArrayList;

public class AudiosActivity extends AppCompatActivity implements IAudio.View{

    private IAudio.Presenter presenter;
    private View reproductor;
    private  ImageButton play;
    private ImageButton pause;
    private ImageButton stop;
    private SearchView mSearchView;
    private Audio audio;
    private ProgressDialog dialogo;
    private SeekBar seekBarAudio;
    private ArrayList<Audio> audios;
    private boolean changeListAudio = true;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audios);
        reproductor = (View) findViewById(R.id.reproductor_audio);
        this.dialogo = new ProgressDialog(this);
        play = reproductor.findViewById(R.id.button_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.playAudio(audio.getUrlAudio());


            }
        });

        pause = reproductor.findViewById(R.id.button_pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.pauseAudio();
            }
        });

        stop = reproductor.findViewById(R.id.button_stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.stopAudio();
            }
        });

        seekBarAudio = reproductor.findViewById(R.id.seekBarAudio);
        seekBarAudio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUSer) {

                if(fromUSer) {
                    presenter.resumeOnPosition(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


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


        MostrarAlerta.mensaje(this, message);
    }

    @Override
    public void showReproductor(Audio audio) {

        this.audio = audio;
        reproductor.setVisibility(View.VISIBLE);
        TextView nombreCuentoAudio = reproductor.findViewById(R.id.nombre_cuento_audio);
        nombreCuentoAudio.setText(audio.getTitulo() + " - "+ audio.getAutor());


    }

    @Override
    public void showProgressMessage(String message) {

        dialogo.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialogo.setMessage(message);
        dialogo.setCancelable(false);
        dialogo.setMax(50);
        dialogo.show();
    }

    @Override
    public void hideProgressMessage() {
        if(dialogo != null) {
            dialogo.dismiss();
        }
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

        if(changeListAudio) {
            this.audios = audios;
        }
        RecyclerView cuentoRecycler = findViewById(R.id.cuento_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        cuentoRecycler.setLayoutManager(linearLayoutManager);

        CuentoAdapterRecyclerView cuentoAdapterRecyclerView = new CuentoAdapterRecyclerView(
                audios, R.layout.cardview_cuento, this, this.presenter);

        cuentoRecycler.setAdapter(cuentoAdapterRecyclerView);
    }

    @Override
    public void setSeekBarMaxSize(int seekBarMaxSize) {
        if(this.seekBarAudio != null)
        this.seekBarAudio.setMax(seekBarMaxSize);
    }

    @Override
    public void setSeekBarProgress(int progress) {
        if(this.seekBarAudio != null)
            this.seekBarAudio.setProgress(progress);
    }

    @Override
    public void setRunnable(Runnable runnable) {
        runOnUiThread(runnable);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_toolbar, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) AudiosActivity.this.getSystemService(Context.SEARCH_SERVICE);
        mSearchView = (SearchView) searchItem.getActionView();


        if (mSearchView != null) {
            mSearchView.setSearchableInfo(searchManager.getSearchableInfo(AudiosActivity.this.getComponentName()));
            mSearchView.setQueryHint(getResources().getString(R.string.buscar));
            SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener()
            {
                public boolean onQueryTextChange(String newText)
                {
                    //filtrar los audios
                    filtrarAudios(newText);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        presenter.stopAudio();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.stopAudio();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopAudio();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.stopAudio();
    }

    private void filtrarAudios(String text) {

        this.changeListAudio = false;
        if(this.audios != null){
            if(text.isEmpty()) {

               this.cargarAdapter(this.audios);
            }else{

                ArrayList<Audio> audiosFiltrados = new ArrayList<>();
                for(Audio audio : this.audios) {
                    if(audio.getTitulo().toUpperCase().contains(text.toUpperCase())) {
                        audiosFiltrados.add(audio);
                    }
                }

                this.cargarAdapter(audiosFiltrados);
            }
        }
        this.changeListAudio = true;
    }


}
