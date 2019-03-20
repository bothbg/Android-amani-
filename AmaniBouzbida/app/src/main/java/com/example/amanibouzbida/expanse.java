package com.example.amanibouzbida;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class expanse {


    private String nom ;
    private Float montant ;
    String date ;
    int id ;

    public expanse(String nom, Float montant, String date, int id) {
        this.nom = nom;
        this.montant = montant;
        this.date = date;
        this.id = id;
    }

    public expanse(String nom, Float montant) {
        this.nom = nom;
        this.montant = montant;
        // code from the internet
        String pattern = "MM/dd/yyyy";

        DateFormat df = new SimpleDateFormat(pattern);
        Date today = Calendar.getInstance().getTime();

        date = df.format(today);
    }



    public String getNom() {
        return nom;
    }

    public Float getMontant() {
        return montant;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }



    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }
}
