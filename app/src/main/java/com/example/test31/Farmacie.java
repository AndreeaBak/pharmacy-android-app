package com.example.test31;

import java.io.Serializable;

public class Farmacie implements Serializable {
    private String numeFarmacie;
    private String adresa;
    private String zona;
    private int numarAngajati;

    public Farmacie() {
    }

    public Farmacie(String numeFarmacie, String adresa, String zona, int nr) {
        this.numeFarmacie = numeFarmacie;
        this.adresa = adresa;
        this.zona = zona;
        this.numarAngajati = nr;
    }

    public String getNumeFarmacie() {
        return numeFarmacie;
    }

    public void setNumeFarmacie(String numeFarmacie) {
        this.numeFarmacie = numeFarmacie;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getIdFarmacie() {
        return numarAngajati;
    }

    public void setIdFarmacie(int idFarmacie) {
        this.numarAngajati = idFarmacie;
    }

    @Override
    public String toString() {
        return "Farmacie{" +
                "numeFarmacie='" + numeFarmacie + '\'' +
                ", adresa='" + adresa + '\'' +
                ", zona='" + zona + '\'' +
                ", idFarmacie=" + numarAngajati +
                '}';
    }
}
