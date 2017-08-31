package com.crcr.listagatos.pojo;

/**
 * Created by Criro on 06/06/2017.
 */

public class GatoPerfil {

    private int foto_perfil;
    private String nombre;

    private int img1gato;
    private String nlikes1;
    private int img2gato;
    private String nlikes2;
    private int img3gato;
    private String nlikes3;

    public GatoPerfil(int foto_perfil, String nombre, int img1gato, String nlikes1, int img2gato, String nlikes2, int img3gato, String nlikes3){

        this.foto_perfil = foto_perfil;
        this.nombre = nombre;
        this.img1gato = img1gato;
        this.nlikes1 = nlikes1;
        this.img2gato = img2gato;
        this.nlikes2 = nlikes2;
        this.img3gato = img3gato;
        this.nlikes3 = nlikes3;

    }


    public int getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(int foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImg1gato() {
        return img1gato;
    }

    public void setImg1gato(int img1gato) {
        this.img1gato = img1gato;
    }

    public String getNlikes1() {
        return nlikes1;
    }

    public void setNlikes1(String nlikes1) {
        this.nlikes1 = nlikes1;
    }

    public int getImg2gato() {
        return img2gato;
    }

    public void setImg2gato(int img2gato) {
        this.img2gato = img2gato;
    }

    public String getNlikes2() {
        return nlikes2;
    }

    public void setNlikes2(String nlikes2) {
        this.nlikes2 = nlikes2;
    }

    public int getImg3gato() {
        return img3gato;
    }

    public void setImg3gato(int img3gato) {
        this.img3gato = img3gato;
    }

    public String getNlikes3() {
        return nlikes3;
    }

    public void setNlikes3(String nlikes3) {
        this.nlikes3 = nlikes3;
    }
}
