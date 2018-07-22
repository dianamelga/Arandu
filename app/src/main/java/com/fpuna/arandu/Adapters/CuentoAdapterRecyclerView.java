package com.fpuna.arandu.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fpuna.arandu.Clases.Cuento;
import com.fpuna.arandu.Interfaces.ICuento;
import com.fpuna.arandu.Presenters.CuentoPresenter;
import com.fpuna.arandu.R;

import java.util.ArrayList;

public class CuentoAdapterRecyclerView extends RecyclerView.Adapter<CuentoAdapterRecyclerView.CuentoViewHolder> {

    private ArrayList<Cuento> cuentos;
    private int resource;
    private Activity activity;
    private ICuento.Presenter presenter;
    public static Cuento cuento;


    public CuentoAdapterRecyclerView(ArrayList<Cuento> cuentos, int resource, Activity activity, ICuento.Presenter presenter) {
        this.cuentos = cuentos;
        this.resource = resource;
        this.activity = activity;
        this.presenter = presenter;
    }

    @NonNull

    public CuentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new CuentoViewHolder(view);
    }


    public void onBindViewHolder(@NonNull CuentoViewHolder holder, final int position) {

        //aca se trabaja con la lista de elementos, asignamos los datos al cardview
        cuento = cuentos.get(position);
        holder.nombreCuento.setText(cuento.getNombre());
        holder.autorCuento.setText(cuento.getAutor());

        holder.cuento.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                cuento = cuentos.get(position);
                presenter.showReproductor(cuento);

            }
        });

        holder.botonDownload.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //descarga de audio
                cuento = cuentos.get(position);
                presenter.descargarAudio(cuento.getAudio());
            }
        });

    }


    public int getItemCount() {
        return cuentos.size();
    }

    public class CuentoViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout cuento;
        private TextView nombreCuento;
        private TextView autorCuento;
        private ImageButton botonDownload;

        public CuentoViewHolder(final View itemView) {
            super(itemView);

            cuento = (LinearLayout) itemView.findViewById(R.id.cuento);
            nombreCuento = (TextView) itemView.findViewById(R.id.nombre_cuento);
            autorCuento = (TextView) itemView.findViewById(R.id.nombre_autor);
            botonDownload = (ImageButton) itemView.findViewById(R.id.boton_download_cuento);




        }
    }
}
