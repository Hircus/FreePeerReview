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
public class AutoriFactory {

    private static AutoriFactory singleton;

    private AutoriFactory() {

    }

    public static AutoriFactory getInstance() {
        if (singleton == null) {
            singleton = new AutoriFactory();
        }

        return singleton;
    }

    public List<Utente> getUtenti() {
        List<Utente> utenti = new ArrayList<>();

        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select * from utenti";

            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Utente utente = new Utente();
                utente.setId(set.getInt("idUtente"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("password"));
                utente.setImmagine(set.getString("immagine"));
                utente.setTipo(set.getBoolean("tipoUtente"));
                utente.setEnte(set.getString("ente"));
                utenti.add(utente);
            }

            stmt.close();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return utenti;
    }

    public Utente getUtentebyID(int id) {
        List<Utente> autori = this.getUtenti();

        for (Utente a : autori) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public Utente getUtenteEmailPassword(String pass, String email) {
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utenti where email=? and password=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            //ordine nella stringa sql 1=email 2=password
            stmt.setString(1, email);
            stmt.setString(2, pass);

            ResultSet set = stmt.executeQuery();

            if (set.next()) {
                Utente utente = new Utente();
                utente.setId(set.getInt("idUtente"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("password"));
                utente.setImmagine(set.getString("immagine"));
                utente.setTipo(set.getBoolean("tipoUtente"));
                utente.setEnte(set.getString("ente"));
                utente.setTipo(set.getBoolean("tipoUtente"));
                stmt.close();
                conn.close();
                return utente;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Utente> getUtentiByArticolo(Articolo art) {

        List<Utente> utentiArticoli = new ArrayList<>();

        try {
            Connection conn = DbManager.getInstance().getDbConnection();

            String sql = "select * from utenti inner join autori on autori.idUtente = utenti.idUtente where autori.idArticolo = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, art.getId());

            ResultSet set = stmt.executeQuery();

            while (set.next()) {
                Utente utente = new Utente();
                utente.setId(set.getInt("idUtente"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("password"));
                utente.setImmagine(set.getString("immagine"));
                utente.setTipo(set.getBoolean("tipoUtente"));
                utente.setEnte(set.getString("ente"));
                utente.setTipo(set.getBoolean("tipoUtente"));
                utentiArticoli.add(utente);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utentiArticoli;
    }

    public boolean deleteUtente(int id) {
        Connection conn = null;
        try {
            conn = DbManager.getInstance().getDbConnection();
            conn.setAutoCommit(false);

            String articoliTable, autoriTable;
            PreparedStatement stmt, stmt2;
            List<Articolo> arts = ArticoliFactory.getInstance().getArticoliByAutore(this.getUtentebyID(id));

            for (Articolo a : arts) {
                articoliTable = "delete from articoli where idArticolo = ?;";
                autoriTable = "delete from autori where idArticolo = ?;";

                stmt = conn.prepareStatement(articoliTable);
                stmt2 = conn.prepareStatement(autoriTable);

                stmt.setInt(1, a.getId());
                stmt2.setInt(1, a.getId());

                stmt.executeUpdate();
                stmt2.executeUpdate();
            }

            String utente = "delete from utenti WHERE idUtente=?";

            stmt = conn.prepareStatement(utente);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            stmt.close();
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

    public boolean insertUtente(Utente nuovoUtente) {
        Connection conn = null;
        try {
            conn = DbManager.getInstance().getDbConnection();

            String insert = "insert into utenti (idUtente, nome, cognome, email, password, immagine, ente, tipoUtente)"
                    + "values (default, '" + nuovoUtente.getNome() + "','"
                    + nuovoUtente.getCognome() + "','" + nuovoUtente.getEmail()
                    + "','" + nuovoUtente.getPassword() + "','" + nuovoUtente.getImmagine()
                    + "','" + nuovoUtente.getEnte() + "'," + "true);";

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(insert);

            stmt.close();
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

    public boolean updateUtente(Utente nuovoUtente) {
        Connection conn = null;
        try {
            conn = DbManager.getInstance().getDbConnection();
            PreparedStatement stmt1;
            Statement stmt2 = conn.createStatement();
            String sql1, sql2;

            sql1 = "select * from utenti where nome=?;";

            stmt1 = conn.prepareStatement(sql1);

            stmt1.setString(1, nuovoUtente.getNome());

            ResultSet set = stmt1.executeQuery();

            while (set.next()) {
                nuovoUtente.setId(set.getInt("idUtente"));
            }
            int tipo=-1;
            if(nuovoUtente.getTipo().toString().equals("true")) tipo = 1;
            if(nuovoUtente.getTipo().toString().equals("false")) tipo = 0;
            
            sql2 = "update utenti set nome = '" + nuovoUtente.getNome() + "', cognome = '"
                    + nuovoUtente.getCognome() + "', email = '" + nuovoUtente.getEmail()
                    + "', password = '" + nuovoUtente.getPassword() + "', immagine = '"
                    + nuovoUtente.getImmagine() + "', ente = '" + nuovoUtente.getEnte()
                    + "', tipoUtente = '" + String.valueOf(tipo) + "' where idUtente = "
                    + nuovoUtente.getId() + ";";

            stmt2.executeUpdate(sql2);

            stmt1.close();
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

    public boolean searchUtente(String nomeUtente) {
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            String sql = "select * from utenti where nome=? and cognome=?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            String[] nomeCognome = nomeUtente.split(" ");

            stmt.setString(1, nomeCognome[0]);
            stmt.setString(2, nomeCognome[1]);
            ResultSet set = stmt.executeQuery();

            if (set.next()) {
                stmt.close();
                conn.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
