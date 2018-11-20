package com.fpuna.arandu.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Interfaces.IAudio;
import com.fpuna.arandu.R;

import java.util.ArrayList;

public class CuentoAdapterRecyclerView extends RecyclerView.Adapter<CuentoAdapterRecyclerView.CuentoViewHolder> {

    private ArrayList<Audio> audios;
    private int resource;
    private Activity activity;
    private IAudio.Presenter presenter;
    private Audio audio;


    public CuentoAdapterRecyclerView(ArrayList<Audio> audios, int resource, Activity activity, IAudio.Presenter presenter) {
        this.audios = audios;
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
        audio = audios.get(position);
        holder.nombreCuento.setText(audio.getTitulo());
        holder.autorCuento.setText(audio.getAutor());

        holder.cuento.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                audio = audios.get(position);
                presenter.stopAudio();
                presenter.showReproductor(audio);
                presenter.playAudio(audios.get(position).getUrlAudio());

            }
        });

        holder.botonDownload.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //descarga de audio
                audio = audios.get(position);
                presenter.descargarAudio(audio);
            }
        });

        //holder.botonDownload.setVisibility(View.INVISIBLE);

    }


    public int getItemCount() {
        return audios.size();
    }

    public class CuentoViewHolder extends RecyclerView.ViewHolder {

        private View cuento;
        private TextView nombreCuento;
        private TextView autorCuento;
        private ImageButton botonDownload;

        public CuentoViewHolder(final View itemView) {
            super(itemView);

            cuento = itemView;
            nombreCuento = (TextView) itemView.findViewById(R.id.nombre_cuento);
            autorCuento = (TextView) itemView.findViewById(R.id.nombre_autor);
            botonDownload = (ImageButton) itemView.findViewById(R.id.boton_download);




        }
    }
}
