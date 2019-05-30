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
                articoli.add(articolo);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return articoli;
    }

    public List<Articolo> getArticoliByAutore(Utente a) {

        List<Articolo> articoliAutore = new ArrayList<>();
        
        try {
            Connection conn = DbManager.getInstance().getDbConnection();

            String sql = "select * from articoli inner join autori on autori.idArticolo = articoli.idArticolo where autori.idUtente = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, a.getId());

            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Articolo art= new Articolo();
                art.setId(set.getInt("idArticolo"));
                art.setTitolo(set.getString("titolo"));
                art.setTesto(set.getString("testo"));
                art.setDataByString(set.getString("dataScrittura"));
                art.setImmagine(set.getString("immagine"));
                art.setAutori(AutoriFactory.getInstance().getUtentiByArticolo(art));
                articoliAutore.add(art);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
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
