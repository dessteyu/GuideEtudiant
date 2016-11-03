package com.example.bayembaye.guideetudiant.objectes;

import android.app.AlertDialog;

/**
 * Created by bayembaye on 31/10/2016.
 */
public class Aide {
    private String nomAide;
    private int num_img;

    public Aide(String nomAide,int num_img){
        this.num_img = num_img;
        this.nomAide = nomAide;
    }
    public Aide(){}

    public String getNomAide() {
        return nomAide;
    }

    public void setNomAide(String nomAide) {
        this.nomAide = nomAide;
    }

    public int getNum_img() {
        return num_img;
    }

    public void setNum_img(int num_img) {
        this.num_img = num_img;
    }
}
