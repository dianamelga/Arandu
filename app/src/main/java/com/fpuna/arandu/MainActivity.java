package com.fpuna.arandu;

import android.Manifest;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMain.View,  StepperLayout.StepperListener {
    public IMain.Presenter presenter;
    private ProgressDialog dialogo;
    private StepperLayout mStepperLayout;
    private String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WAKE_LOCK
    };
    public static final int MULTIPLE_PERMISSIONS = 107;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dialogo = new ProgressDialog(this);

        mStepperLayout = (StepperLayout) findViewById(R.id.stepper);

        presenter = new MainPresenter(this);
        presenter.loadView();


    }



    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(getApplicationContext(), p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkPermissions()) {

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MULTIPLE_PERMISSIONS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "El programa se cerro ya que no cuenta con todos los permisos para su ejecución", Toast.LENGTH_LONG).show();
                    finishAffinity();
                }
            }
        }
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
