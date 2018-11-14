package com.fpuna.arandu.Adapters;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import java.util.List;



public class MyStepperAdapter extends AbstractFragmentStepAdapter {

    //private static final String CURRENT_STEP_POSITION_KEY = "1";

    private  List<Step> ListaFragment;
    private  List<String> ListaTitulos;

    public void addFrament(Step fragment){
        ListaFragment.add(fragment);
        ListaTitulos.add("Titulo");
    }



    public MyStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context, List<Step> Steps, List<String> Titulos) {
        super(fm, context);
        ListaFragment = Steps;
        ListaTitulos = Titulos;
    }

    @Override
    public Step createStep(@IntRange(from = 0L) int position) {

        if (this.context != null){
            Toast.makeText(this.context,"Position:" + position, Toast.LENGTH_SHORT);
        }

        return ListaFragment.get(position);
    }

    @Override
    public int getCount() {
        if (this.context != null){
            Toast.makeText(this.context,"getCount", Toast.LENGTH_SHORT);
        }

        return ListaFragment.size();

    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0L) int position) {
        StepViewModel stepViewModel;

        if (this.context != null){
            Toast.makeText(this.context,"getViewModel", Toast.LENGTH_SHORT);
        }



        stepViewModel = new StepViewModel.Builder(context).setTitle(ListaTitulos.get(position)).create();




        return  stepViewModel;

        //return new StepViewModel.Builder(context).setTitle(ListaTitulos.get(position)).create();
    }

    public  List<Step> getListaFragment() {
        return ListaFragment;
    }

    public  List<String> getListaTitulos() {
        return ListaTitulos;
    }
}
