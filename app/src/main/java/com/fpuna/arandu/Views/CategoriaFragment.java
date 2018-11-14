package com.fpuna.arandu.Views;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fpuna.arandu.Adapters.CategoriaAdapterRecyclerView;
import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Interfaces.ICategoria;
import com.fpuna.arandu.Presenters.CategoriaPresenter;
import com.fpuna.arandu.R;
import com.fpuna.arandu.Utils.MostrarAlerta;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaFragment extends Fragment implements ICategoria.View, Step {
    public ICategoria.Presenter presenter;
    private ProgressDialog dialogo;
    private RecyclerView categoriaRecycler;
    private ArrayList<Categoria> categorias;

    public CategoriaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoria, container, false);
        this.dialogo = new ProgressDialog(view.getContext());
        presenter = new CategoriaPresenter(this);
        categoriaRecycler = (RecyclerView) view.findViewById(R.id.categoria_recycler);
        return view;
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
        if(this.categorias == null) {
            presenter.consultar();
        }

    }

    @Override
    public void onError(@NonNull VerificationError error) {

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
        MostrarAlerta.mensaje(getContext(), message);
    }

    @Override
    public void cargarAdapter(ArrayList<Categoria> categorias) {


        this.categorias = categorias;
        categoriaRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));

        CategoriaAdapterRecyclerView categoriaAdapterRecyclerView = new CategoriaAdapterRecyclerView(
                categorias, R.layout.cardview_categoria, getActivity());

        categoriaRecycler.setAdapter(categoriaAdapterRecyclerView);
    }

    @Override
    public Context obtContext() {
        return getContext();
    }


}
