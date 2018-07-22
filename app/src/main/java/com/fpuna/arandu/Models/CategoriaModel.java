package com.fpuna.arandu.Models;

import android.content.Context;

import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Clases.Cuento;
import com.fpuna.arandu.Interfaces.ICategoria;

import java.util.ArrayList;

public class CategoriaModel implements ICategoria.Model {

    private int codResultado;
    private String resultado;
    private ArrayList<Categoria> categorias;
    private Context context;

    @Override
    public void consultar() {
        //consumir webService y cargar los datos a los atributos de la clase

        cargaDatosDePrueba();
    }

    @Override
    public int getCodResultado() {
        return this.codResultado;
    }

    @Override
    public String getResultado() {
        return this.resultado;
    }

    @Override
    public ArrayList<Categoria> getCategorias() {
        return this.categorias;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    private void cargaDatosDePrueba(){
        String urlAudio = ""; //aca pone un link de audio para hacer tus pruebas
        this.categorias = new ArrayList<>();
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setImagen("");
        categoria.setNombreCastellano("Cuento infantil");
        categoria.setNombreGuarani("Mombe'ura mitambeguara");

        ArrayList<Cuento> cuentos = new ArrayList<>();
        Cuento cuento = new Cuento();
        cuento.setId(1);
        cuento.setIdCategoria(1);
        cuento.setNombre("Pira'i");
        cuento.setAutor("Maria Georgina Gonzalez Moran");
        cuento.setAudio("");
        cuentos.add(cuento);

        categoria.setCuentos(cuentos);

        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(2);
        categoria.setImagen("");
        categoria.setNombreCastellano("Cuento para adulto");
        categoria.setNombreGuarani("Mombe'ura kakuaape guara");

        cuentos = new ArrayList<>();

        cuento = new Cuento();
        cuento.setId(1);
        cuento.setIdCategoria(2);
        cuento.setNombre("Silla de rueda pyahu");
        cuento.setAutor("Alcibiades Britez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(2);
        cuento.setIdCategoria(2);
        cuento.setNombre("España-pe jeho");
        cuento.setAutor("Alcibiades Britez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(3);
        cuento.setIdCategoria(2);
        cuento.setNombre("Ykua Bolaños");
        cuento.setAutor("Alcibiades Britez");
        cuento.setAudio(urlAudio);
        cuentos.add(cuento);

        categoria.setCuentos(cuentos);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(3);
        categoria.setImagen("");
        categoria.setNombreCastellano("Mito");
        categoria.setNombreGuarani("Kaso ndaha'eiva ojehuva'ekue");

        cuentos = new ArrayList<>();
        cuento = new Cuento();
        cuento.setId(1);
        cuento.setIdCategoria(3);
        cuento.setNombre("Ao ao rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(2);
        cuento.setIdCategoria(3);
        cuento.setNombre("Ka'a Jaryi rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(3);
        cuento.setIdCategoria(3);
        cuento.setNombre("Kurupi rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(4);
        cuento.setIdCategoria(3);
        cuento.setNombre("Luiso rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(5);
        cuento.setIdCategoria(3);
        cuento.setNombre("Pombero rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(6);
        cuento.setIdCategoria(3);
        cuento.setNombre("Pora rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(7);
        cuento.setIdCategoria(3);
        cuento.setNombre("Jasy jatere rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(8);
        cuento.setIdCategoria(3);
        cuento.setNombre("Bruja rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        categoria.setCuentos(cuentos);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(4);
        categoria.setImagen("");
        categoria.setNombreCastellano("Leyenda");
        categoria.setNombreGuarani("Mombe'u yma");

        cuentos = new ArrayList<>();
        cuento = new Cuento();
        cuento.setId(1);
        cuento.setIdCategoria(4);
        cuento.setNombre("Pa'i sume rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(2);
        cuento.setIdCategoria(4);
        cuento.setNombre("Ka'a sume rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(3);
        cuento.setIdCategoria(4);
        cuento.setNombre("Tupasy Caacupe rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(4);
        cuento.setIdCategoria(4);
        cuento.setNombre("Kurusu Bartolo rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(5);
        cuento.setIdCategoria(4);
        cuento.setNombre("Kurusu Pablito rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(6);
        cuento.setIdCategoria(4);
        cuento.setNombre("Karau rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(7);
        cuento.setIdCategoria(4);
        cuento.setNombre("Mba'eichapa ka'i ou raka'e ko yvy ape ari");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);


        cuento = new Cuento();
        cuento.setId(8);
        cuento.setIdCategoria(4);
        cuento.setNombre("Mainumby'i rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(9);
        cuento.setIdCategoria(4);
        cuento.setNombre("Jatytaru rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(10);
        cuento.setIdCategoria(4);
        cuento.setNombre("Ypakarai lago rehegua");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        categoria.setCuentos(cuentos);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(5);
        categoria.setImagen("");
        categoria.setNombreCastellano("Poesia");
        categoria.setNombreGuarani("Ñe'epoty");

        cuentos = new ArrayList<>();
        cuento = new Cuento();
        cuento.setId(1);
        cuento.setIdCategoria(5);
        cuento.setNombre("Guajaki sapukai");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(2);
        cuento.setIdCategoria(5);
        cuento.setNombre("Pyhare mbovye");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(3);
        cuento.setIdCategoria(5);
        cuento.setNombre("Nde jepoyhu");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(4);
        cuento.setIdCategoria(5);
        cuento.setNombre("Mba'e kañymby");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(5);
        cuento.setIdCategoria(5);
        cuento.setNombre("Ara ohasa");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(6);
        cuento.setIdCategoria(5);
        cuento.setNombre("Ne ra'anga");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(7);
        cuento.setIdCategoria(5);
        cuento.setNombre("Ka'aru hungy");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        categoria.setCuentos(cuentos);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(6);
        categoria.setImagen("");
        categoria.setNombreCastellano("Cuento popular y fabula");
        categoria.setNombreGuarani("Kaso ha mongaru");

        cuentos = new ArrayList<>();
        cuento = new Cuento();
        cuento.setId(1);
        cuento.setIdCategoria(6);
        cuento.setNombre("Ka'i veve");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(2);
        cuento.setIdCategoria(6);
        cuento.setNombre("Ka'i ome'ero guare chipa repykue");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(3);
        cuento.setIdCategoria(6);
        cuento.setNombre("Ka'i omboaguararo guare jakarepe");
        cuento.setAutor("Feliciano Acosta");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(4);
        cuento.setIdCategoria(6);
        cuento.setNombre("Peru oñemoiro guare pelotape");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(5);
        cuento.setIdCategoria(6);
        cuento.setNombre("Pychai omonguera Principe-pe");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(6);
        cuento.setIdCategoria(6);
        cuento.setNombre("Gua'i oho jeyramo guare hogape");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(7);
        cuento.setIdCategoria(6);
        cuento.setNombre("Kachike imitaveramo guare ita'yragui");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(8);
        cuento.setIdCategoria(6);
        cuento.setNombre("Jaguarete oñemomanoramo guare");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(9);
        cuento.setIdCategoria(6);
        cuento.setNombre("Jagua ha mbarakaja ndaikatui oñogama");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(10);
        cuento.setIdCategoria(6);
        cuento.setNombre("Tujuju ojapokaramo guare itrahera");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);

        cuento = new Cuento();
        cuento.setId(11);
        cuento.setIdCategoria(6);
        cuento.setNombre("Ka'ipe oñe'eramo guare hupa");
        cuento.setAutor("Domingo Adolfo Aguilera Gimenez");
        cuento.setAudio("");
        cuentos.add(cuento);
        categoria.setCuentos(cuentos);
        this.categorias.add(categoria);

        this.codResultado = Constante.OK;
        this.resultado = "OK";
    }
}
