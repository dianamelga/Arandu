package com.fpuna.arandu.Interfaces;

import com.stepstone.stepper.Step;

import java.util.ArrayList;

public interface IMain {

    public interface Model extends IModel {


    }

    public interface Presenter  {
        public void loadView();

    }

    public interface View extends IView {
        public void setAdapterStepper(ArrayList<Step> fragments, ArrayList<String> titles);
        public void showProgressDialog(String message);
        public void dismissProgressDialog();
        public void showMessage(String message);
    }
}
