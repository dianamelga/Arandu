package com.fpuna.arandu.Models;

import android.content.Context;

import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Interfaces.ICategoria;

import java.util.ArrayList;
import java.util.List;

import ca.cuanti.javautilpy.helpers.json.GJsonDecoder;

public class CategoriaModel implements ICategoria.Model {

    private ArrayList<Categoria> categorias;
    private Context context;

    @Override
    public void consultar() {
        List<CategoriaResponse> catList = GJsonDecoder.getArrayGJson(
                Constante.urlService + "/api/categoria",
                CategoriaResponse[].class
        );

        this.categorias = new ArrayList<>();
        for (CategoriaResponse cr : catList) {
            Categoria categoria = new Categoria();
            categoria.setId(cr.id);
            categoria.setImagen(cr.imagen);
            categoria.setNombreCastellano(cr.nombreCastellano);
            categoria.setNombreGuarani(cr.nombreGuarani);
            categoria.setAudios(cr.audios);

            this.categorias.add(categoria);
        }
    }

    @Override
    public ArrayList<Categoria> getCategorias() {
        return this.categorias;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Clase para hacer mapping con la respuesta del json
     */
    public class CategoriaResponse {

        private Integer id;
        private String imagen; //preparamos para que reciba una url
        private String nombreGuarani;
        private String nombreCastellano;
        private ArrayList<Audio> audios;

    }
}

