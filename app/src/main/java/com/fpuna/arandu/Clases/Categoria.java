package com.fpuna.arandu.Clases;


import java.util.ArrayList;

public class Categoria {

    private Integer id;
    private String imagen; //preparamos para que reciba una url
    private String nombreGuarani;
    private String nombreCastellano;
    private ArrayList<Audio> audios;



    public void setId(Integer id) {
        this.id = id;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombreGuarani(String nombreGuarani) {
        this.nombreGuarani = nombreGuarani;
    }

    public void setNombreCastellano(String nombreCastellano) {
        this.nombreCastellano = nombreCastellano;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public Integer getId() {
        return this.id;
    }


    public String getNombreGuarani() {
        return this.nombreGuarani;
    }


    public String getNombreCastellano() {
        return this.nombreCastellano;
    }


    public String getImagen() {
        return this.imagen;
    }


    public ArrayList<Audio> getAudios() {
        return this.audios;
    }




}
