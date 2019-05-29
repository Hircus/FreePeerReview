/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class ArticoliFactory {

    private static ArticoliFactory singleton;

    private ArticoliFactory() {
    }

    public static ArticoliFactory getInstance() {
        if (singleton == null) {
            singleton = new ArticoliFactory();
        }

        return singleton;
    }

    public List<Articolo> getArticoli() {

        List<Articolo> articoli = new ArrayList<>();

        /*
        Utente gregorio = AutoriFactory.getInstance().getUtentebyID(1);
        Utente marco = AutoriFactory.getInstance().getUtentebyID(3);
        
        Articolo art = new Articolo();
        Articolo art2 = new Articolo();
        Articolo art3 = new Articolo();
        Articolo art4 = new Articolo();
        
        art.setId(1);
        art.setTitolo("Deep Learning con Python");
        art.setTesto("Python e' un ottimo linguaggio");
        art.setImmagine("immagine1.png");
        art.setData(05, 04, 2019);
        art.setValutazione(ValutazioniFactory.getInstance().getValutazioneById(1));
        art.getCategorie().get(3).setCheck(true);
        articoli.add(art);

        art2.setId(2);
        art2.setTitolo("La tecnologia FTTH");
        art2.setTesto("La fibra e' molto veloce");
        art2.setImmagine("immagine2.png");
        art2.setData(15, 02, 2019);
        art2.setValutazione(ValutazioniFactory.getInstance().getValutazioneById(2));
        art2.getCategorie().get(5).setCheck(true);
        art2.getAutori().add(gregorio);
        articoli.add(art2);

        art3.setId(3);
        art3.setTitolo("Guida al Responsive Design");
        art3.setTesto("Il css e' una merda");
        art3.setImmagine("immagine3.png");
        art3.setData(17, 04, 2018);
        art3.setValutazione(ValutazioniFactory.getInstance().getValutazioneById(3));
        art3.getCategorie().get(1).setCheck(true);
        articoli.add(art3);
        
        art4.setId(4);
        art4.setTitolo("Il linguaggio Object Oriented");
        art4.setTesto("Java e' un linguaggio OOP");
        art4.setImmagine("immagine4.png");
        art4.setData(05, 12, 2017);
        art4.setValutazione(ValutazioniFactory.getInstance().getValutazioneById(4));
        art4.getCategorie().get(4).setCheck(true);
        articoli.add(art4);
        
        art.getAutori().add(gregorio);
        art2.getAutori().add(marco);
        art3.getAutori().add(gregorio);
        art4.getAutori().add(marco);*/
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select * from articoli";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Articolo articolo = new Articolo();
                articolo.setId(set.getInt("idArticolo"));
                articolo.setTitolo(set.getString("titolo"));
                articolo.setTesto(set.getString("testo"));
                articolo.setImmagine(set.getString("immagine"));
                articolo.setDataByString(set.getString("dataScrittura"));
                setAutori(articolo);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return articoli;
    }
    
    public void setAutori(Articolo articolo){
        
        try {
            Connection conn = DbManager.getInstance().getDbConnection();

            String sql = "select * from autore where idArticolo=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, articolo.getId());
            
            ResultSet set = stmt.executeQuery(sql);
            
            while (set.next()) {
                Utente temp=AutoriFactory.getInstance().getUtentebyID(set.getInt("idUtente"));
                articolo.getAutori().add(temp);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public List<Articolo> getArticoliByAutore(Utente a) {

        List<Articolo> articoliAutore = new ArrayList<>();
        List<Articolo> all = this.getArticoli();

        for (Articolo l : all) {
            for (Utente k : l.getAutori()) {
                if (k.equals(a)) {

                    articoliAutore.add(l);
                }
            }
        }
        return articoliAutore;
    }

    public Articolo getArticoloId(int id) {
        List<Articolo> all = this.getArticoli();
        for (Articolo l : all) {
            if (l.getId() == id) {
                return l;
            }
        }

        return null;
    }

    public List<Articolo> getArticolobyCategory(String category) {

        List<Articolo> cat = new ArrayList<>();
        List<Articolo> all = this.getArticoli();
        for (Articolo l : all) {
            if (l.getCategorie().contains(category)) {
                cat.add(l);
            }
        }
        return cat;
    }
}
