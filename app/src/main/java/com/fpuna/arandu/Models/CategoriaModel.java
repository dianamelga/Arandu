package com.fpuna.arandu.Models;

import android.content.Context;

import com.fpuna.arandu.Clases.Audio;
import com.fpuna.arandu.Clases.Categoria;
import com.fpuna.arandu.Clases.Constante;
import com.fpuna.arandu.Interfaces.ICategoria;

import java.util.ArrayList;

public class CategoriaModel implements ICategoria.Model {

    private ArrayList<Categoria> categorias;
    private Context context;

    @Override
    public void consultar() {
        //consumir webService y cargar los datos a los atributos de la clase

        cargaDatosDePrueba();
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
        categoria.setNombreCastellano("Audio infantil");
        categoria.setNombreGuarani("Mombe'ura mitambeguara");

        ArrayList<Audio> audios = new ArrayList<>();
        Audio audio = new Audio();
        audio.setId(1);
        audio.setIdCategoria(1);
        audio.setNombre("Pira'i");
        audio.setAutor("Maria Georgina Gonzalez Moran");
        audio.setUrlAudio("");
        audios.add(audio);

        categoria.setAudios(audios);

        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(2);
        categoria.setImagen("");
        categoria.setNombreCastellano("Audio para adulto");
        categoria.setNombreGuarani("Mombe'ura kakuaape guara");

        audios = new ArrayList<>();

        audio = new Audio();
        audio.setId(1);
        audio.setIdCategoria(2);
        audio.setNombre("Silla de rueda pyahu");
        audio.setAutor("Alcibiades Britez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(2);
        audio.setIdCategoria(2);
        audio.setNombre("España-pe jeho");
        audio.setAutor("Alcibiades Britez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(3);
        audio.setIdCategoria(2);
        audio.setNombre("Ykua Bolaños");
        audio.setAutor("Alcibiades Britez");
        audio.setUrlAudio(urlAudio);
        audios.add(audio);

        categoria.setAudios(audios);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(3);
        categoria.setImagen("");
        categoria.setNombreCastellano("Mito");
        categoria.setNombreGuarani("Kaso ndaha'eiva ojehuva'ekue");

        audios = new ArrayList<>();
        audio = new Audio();
        audio.setId(1);
        audio.setIdCategoria(3);
        audio.setNombre("Ao ao rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(2);
        audio.setIdCategoria(3);
        audio.setNombre("Ka'a Jaryi rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(3);
        audio.setIdCategoria(3);
        audio.setNombre("Kurupi rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(4);
        audio.setIdCategoria(3);
        audio.setNombre("Luiso rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(5);
        audio.setIdCategoria(3);
        audio.setNombre("Pombero rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(6);
        audio.setIdCategoria(3);
        audio.setNombre("Pora rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(7);
        audio.setIdCategoria(3);
        audio.setNombre("Jasy jatere rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(8);
        audio.setIdCategoria(3);
        audio.setNombre("Bruja rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        categoria.setAudios(audios);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(4);
        categoria.setImagen("");
        categoria.setNombreCastellano("Leyenda");
        categoria.setNombreGuarani("Mombe'u yma");

        audios = new ArrayList<>();
        audio = new Audio();
        audio.setId(1);
        audio.setIdCategoria(4);
        audio.setNombre("Pa'i sume rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(2);
        audio.setIdCategoria(4);
        audio.setNombre("Ka'a sume rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(3);
        audio.setIdCategoria(4);
        audio.setNombre("Tupasy Caacupe rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(4);
        audio.setIdCategoria(4);
        audio.setNombre("Kurusu Bartolo rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(5);
        audio.setIdCategoria(4);
        audio.setNombre("Kurusu Pablito rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(6);
        audio.setIdCategoria(4);
        audio.setNombre("Karau rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(7);
        audio.setIdCategoria(4);
        audio.setNombre("Mba'eichapa ka'i ou raka'e ko yvy ape ari");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);


        audio = new Audio();
        audio.setId(8);
        audio.setIdCategoria(4);
        audio.setNombre("Mainumby'i rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(9);
        audio.setIdCategoria(4);
        audio.setNombre("Jatytaru rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(10);
        audio.setIdCategoria(4);
        audio.setNombre("Ypakarai lago rehegua");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        categoria.setAudios(audios);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(5);
        categoria.setImagen("");
        categoria.setNombreCastellano("Poesia");
        categoria.setNombreGuarani("Ñe'epoty");

        audios = new ArrayList<>();
        audio = new Audio();
        audio.setId(1);
        audio.setIdCategoria(5);
        audio.setNombre("Guajaki sapukai");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(2);
        audio.setIdCategoria(5);
        audio.setNombre("Pyhare mbovye");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(3);
        audio.setIdCategoria(5);
        audio.setNombre("Nde jepoyhu");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(4);
        audio.setIdCategoria(5);
        audio.setNombre("Mba'e kañymby");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(5);
        audio.setIdCategoria(5);
        audio.setNombre("Ara ohasa");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(6);
        audio.setIdCategoria(5);
        audio.setNombre("Ne ra'anga");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(7);
        audio.setIdCategoria(5);
        audio.setNombre("Ka'aru hungy");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        categoria.setAudios(audios);
        this.categorias.add(categoria);

        categoria = new Categoria();
        categoria.setId(6);
        categoria.setImagen("");
        categoria.setNombreCastellano("Audio popular y fabula");
        categoria.setNombreGuarani("Kaso ha mongaru");

        audios = new ArrayList<>();
        audio = new Audio();
        audio.setId(1);
        audio.setIdCategoria(6);
        audio.setNombre("Ka'i veve");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(2);
        audio.setIdCategoria(6);
        audio.setNombre("Ka'i ome'ero guare chipa repykue");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(3);
        audio.setIdCategoria(6);
        audio.setNombre("Ka'i omboaguararo guare jakarepe");
        audio.setAutor("Feliciano Acosta");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(4);
        audio.setIdCategoria(6);
        audio.setNombre("Peru oñemoiro guare pelotape");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(5);
        audio.setIdCategoria(6);
        audio.setNombre("Pychai omonguera Principe-pe");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(6);
        audio.setIdCategoria(6);
        audio.setNombre("Gua'i oho jeyramo guare hogape");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(7);
        audio.setIdCategoria(6);
        audio.setNombre("Kachike imitaveramo guare ita'yragui");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(8);
        audio.setIdCategoria(6);
        audio.setNombre("Jaguarete oñemomanoramo guare");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(9);
        audio.setIdCategoria(6);
        audio.setNombre("Jagua ha mbarakaja ndaikatui oñogama");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(10);
        audio.setIdCategoria(6);
        audio.setNombre("Tujuju ojapokaramo guare itrahera");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);

        audio = new Audio();
        audio.setId(11);
        audio.setIdCategoria(6);
        audio.setNombre("Ka'ipe oñe'eramo guare hupa");
        audio.setAutor("Domingo Adolfo Aguilera Gimenez");
        audio.setUrlAudio("");
        audios.add(audio);
        categoria.setAudios(audios);
        this.categorias.add(categoria);

    }
}
