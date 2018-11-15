package com.fpuna.arandu;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
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
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.fpuna.arandu.Adapters.CategoriaAdapterRecyclerView;
import com.fpuna.arandu.Adapters.MyStepperAdapter;
import com.fpuna.arandu.Interfaces.ICategoria;
import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Interfaces.IMain;
import com.fpuna.arandu.Presenters.CategoriaPresenter;
import com.fpuna.arandu.Presenters.MainPresenter;
import com.fpuna.arandu.Utils.MostrarAlerta;
import com.fpuna.arandu.Views.InformacionActivity;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMain.View,  StepperLayout.StepperListener {
    public IMain.Presenter presenter;
    private ProgressDialog dialogo;
    private StepperLayout mStepperLayout;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dialogo = new ProgressDialog(this);

        mStepperLayout = (StepperLayout) findViewById(R.id.stepper);

        presenter = new MainPresenter(this);
        presenter.loadView();


    }


    @Override
    public void setAdapterStepper(ArrayList<Step> fragments, ArrayList<String> titles) {
        MyStepperAdapter myStepperAdapter = new MyStepperAdapter(getSupportFragmentManager(),
                this, fragments, titles);

        mStepperLayout.setAdapter(myStepperAdapter);

        mStepperLayout.setListener(this);
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


        MostrarAlerta.mensaje(this, message);
    }


    @Override
    public Context obtContext() {
        return this;
    }




    @Override
    public void onCompleted(View completeButton) {

    }

    @Override
    public void onError(VerificationError verificationError) {

    }

    @Override
    public void onStepSelected(int newStepPosition) {

    }

    @Override
    public void onReturn() {

    }
}
