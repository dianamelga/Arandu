package com.fpuna.arandu.Presenters;

import android.app.Fragment;

import com.fpuna.arandu.Interfaces.ICategoria;
import com.fpuna.arandu.Interfaces.IMain;
import com.fpuna.arandu.Views.CategoriaFragment;
import com.fpuna.arandu.Views.InicioFragment;
import com.stepstone.stepper.Step;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements IMain.Presenter {
    private IMain.View view;

    public MainPresenter(IMain.View view) {
        this.view = view;

    }

    @Override
    public void loadView() {

        try {
            ArrayList<Step> fragmentList = new ArrayList<>();
            ArrayList<String> fragmentTitles = new ArrayList<>();


            fragmentList.add(new InicioFragment());
            fragmentTitles.add("Inicio");

            fragmentList.add(new CategoriaFragment());
            fragmentTitles.add("Categoria");



            this.view.setAdapterStepper(fragmentList, fragmentTitles);
        }catch (Exception e) {
            e.printStackTrace();
            this.view.showMessage(e.getMessage());
        }

    }
}
