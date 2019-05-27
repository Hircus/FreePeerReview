/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author antonio
 */
public class Utente {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String immagine;
    private String ente;
    private Boolean autore;

    public Utente(){
    }
    
    /**
     * @return the tipo
     */
    public Boolean getTipo() {
        return autore;
    }

    /**
     * @param tipoUtente the tipoUtente to set
     */
    public void setTipo(Boolean tipoUtente) {
        this.autore = tipoUtente;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the ente
     */
    public String getEnte() {
        return ente;
    }

    /**
     * @param ente the ente to set
     */
    public void setEnte(String ente) {
        this.ente = ente;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Utente a) {
        return this.id == a.id;
    }

}
