/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author antonio
 */
public class Articolo {

    private int id;
    private List<Utente> autori;
    private List<String> categorie;
    private String titolo;
    private String testo;
    private String immagine;
    private Data data;
    private int valutazione;

    public Articolo() {
        this.autori = new ArrayList<>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the autori
     */
    public List<Utente> getAutori() {
        return autori;
    }

    /**
     * @param autori the autori to set
     */
    public void setAutori(List<Utente> autori) {
        this.autori = autori;
    }

    /**
     * @return the categorie
     */
    public List<String> getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(List<String> categorie) {
        this.categorie = categorie;
    }

    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * @return the immagine
     */
    public String getImmagine() {
        return immagine;
    }

    /**
     * @param immagine the immagine to set
     */
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param g
     * @param m
     * @param a
     */
    public void setData(int g, int m, int a) {
        this.data = new Data(g, m ,a);
    }

    /**
     * @return the valutazione
     */
    public int getValutazione() {
        return valutazione;
    }

    /**
     * @param valutazione the valutazione to set
     */
    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }
}
