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
                articolo.setStato(set.getString("stato"));
                articolo.setAutori(AutoriFactory.getInstance().getUtentiByArticolo(articolo));
                articolo.addCategoria(set.getString("categorie"));
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
                Articolo articolo = new Articolo();
                articolo.setId(set.getInt("idArticolo"));
                articolo.setTitolo(set.getString("titolo"));
                articolo.setTesto(set.getString("testo"));
                articolo.setDataByString(set.getString("dataScrittura"));
                articolo.setStato(set.getString("stato"));
                articolo.setImmagine(set.getString("immagine"));
                articolo.setAutori(AutoriFactory.getInstance().getUtentiByArticolo(articolo));
                articolo.addCategoria(set.getString("categorie"));
                articoliAutore.add(articolo);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articoliAutore;
    }

    public boolean insertArticolo(Articolo articolo, Utente utente) {

        try {
            Connection conn = DbManager.getInstance().getDbConnection();

            String sql = "select * from articoli where titolo=?;";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, articolo.getTitolo());
            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                if (set.getString("titolo").equals(articolo.getTitolo())) {
                    return false;
                }
            }

            Statement stmtInsert = conn.createStatement();
            sql = "insert into articoli (idArticolo, titolo, testo, immagine, dataScrittura, categorie, stato) values (default , '"
                    + articolo.getTitolo() + "', '" + articolo.getTesto() + "', '" + articolo.getImmagine() + "', '" + articolo.getData() + "', '" + articolo.getCategorie() + "', 'Aperto');";

            stmtInsert.executeUpdate(sql);

            sql = "select * from articoli where titolo=?;";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, articolo.getTitolo());

            set = stmt.executeQuery();

            while (set.next()) {
                articolo.setId(set.getInt("idArticolo"));
            }

            sql = "insert into autori (idUtente, idArticolo) values(?, ?)";

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, utente.getId());
            stmt.setInt(2, articolo.getId());

            stmt.executeUpdate();

            stmt.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateArticolo(Articolo articolo) {

        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            PreparedStatement stmt1;
            Statement stmt2 = conn.createStatement();
            String sql1, sql2;

            sql1 = "select * from articoli where titolo=?;";
            stmt1 = conn.prepareStatement(sql1);

            stmt1.setString(1, articolo.getTitolo());

            ResultSet set = stmt1.executeQuery();

            while (set.next()) {
                articolo.setId(set.getInt("idArticolo"));
            }

            sql2 = "update articoli set titolo = '" + articolo.getTitolo() + "', testo = '" + articolo.getTesto()
                    + "', immagine = '" + articolo.getImmagine() + "', dataScrittura = '" + articolo.getData() + "', categorie = '" + articolo.getCategorie()
                    + "' where idArticolo = " + articolo.getId() + ";";
            stmt2.executeUpdate(sql2);
            
            for(Utente u: articolo.getAutori()){
                sql2= "update autori set idUtente = '"+ u.getId()+ "' where idArticolo = " + articolo.getId() + ";";
                stmt2.executeUpdate(sql2);
            }

            stmt1.close();
            stmt2.close();
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteArticolo(int id) {
        Connection conn = null;
        try {
            conn = DbManager.getInstance().getDbConnection();
            conn.setAutoCommit(false);

            String articoliTable, autoriTable;
            PreparedStatement stmt, stmt2;

            articoliTable = "delete from articoli where idArticolo = ?;";
            autoriTable = "delete from autori where idArticolo = ?;";

            stmt = conn.prepareStatement(articoliTable);
            stmt2 = conn.prepareStatement(autoriTable);

            stmt.setInt(1, id);
            stmt2.setInt(1, id);

            stmt.executeUpdate();
            stmt2.executeUpdate();
            
            conn.commit();
            conn.setAutoCommit(true);
            stmt.close();
            stmt2.close();
            conn.close();

            return true;
        } catch (SQLException e) {
            Logger.getLogger(AutoriFactory.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(AutoriFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return false;
        }
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

        List<Articolo> articoli = new ArrayList<>();
        List<Articolo> all = this.getArticoli();

        for (Articolo a : all) {
            if (a.getCategorie().contains(category)) {
                articoli.add(a);
            }
        }
        return articoli;
    }
}
