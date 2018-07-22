package com.fpuna.arandu.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.R;
import com.fpuna.arandu.Views.CuentosActivity;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import me.grantland.widget.AutofitTextView;

public class CategoriaAdapterRecyclerView extends RecyclerView.Adapter<CategoriaAdapterRecyclerView.CategoriaViewHolder> {
    private ArrayList<Categoria> categorias;
    private int resource; //recurso o cardview layout
    private Activity activity;
    public static Categoria categoria;

    public CategoriaAdapterRecyclerView(ArrayList<Categoria> categorias, int resource, Activity activity) {
        this.categorias = categorias;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull

    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new CategoriaViewHolder(view);
    }


    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, final int position) {
        //aca se trabaja con la lista de elementos, asignamos los datos al cardview

        categoria = categorias.get(position);
        //Picasso.with(activity.getApplicationContext()).load(categoria.getImagen()).into(holder.imagenCategoria);
        holder.labelCategoriaGuarani.setText(categoria.getNombreGuarani());
        holder.labelCategoriaCastellano.setText(categoria.getNombreCastellano());

        int resourceImage = R.drawable.leyenda;
        switch (categoria.getId()) {
            case 1:
                resourceImage = R.drawable.nino;
                break;
            case 2:
                resourceImage = R.drawable.adulto;
                break;
            case 3:
                resourceImage = R.drawable.mito;
                break;
            case 4:
                resourceImage = R.drawable.leyenda;
                break;
            case 5:
                resourceImage = R.drawable.poesia;
                break;
            case 6:
                resourceImage = R.drawable.fabula;
                break;

        }

        Picasso.with(activity.getApplicationContext()).load(resourceImage).into(holder.imagenCategoria);

        holder.imagenCategoria.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                categoria = categorias.get(position);
                Intent intent = new Intent(activity, CuentosActivity.class);
                activity.startActivity(intent);
            }
        });


    }


    public int getItemCount() {
        return categorias.size();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {

        //todos los views que componen al cardview

        private ImageView imagenCategoria;
        private AutofitTextView labelCategoriaGuarani;
        private AutofitTextView labelCategoriaCastellano;

        public CategoriaViewHolder(View itemView) {
            super(itemView);


            imagenCategoria = (ImageView) itemView.findViewById(R.id.imagen_categoria);
            labelCategoriaGuarani = (AutofitTextView) itemView.findViewById(R.id.label_categoria_guarani);
            labelCategoriaCastellano = (AutofitTextView) itemView.findViewById(R.id.label_categoria_castellano);

            labelCategoriaGuarani.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(activity.getApplicationContext(), labelCategoriaGuarani.getText().toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
