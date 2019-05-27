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

        /**
         * Utente Gregorio = new Utente(); Utente Davide = new Utente(); Utente
         * Marco = new Utente();
         *
         * Gregorio.setId(1); Gregorio.setNome("Gregorio");
         * Gregorio.setCognome("Rivano");
         * Gregorio.setEmail("gregorio@gmail.com");
         * Gregorio.setPassword("sushi"); Gregorio.setImmagine("immagine.png");
         * Gregorio.setEnte("Unica"); Gregorio.setTipo("Autore");
         * autori.add(Gregorio);
         *
         * Davide.setId(2); Davide.setNome("Davide");
         * Davide.setCognome("Piras"); Davide.setEmail("davide@gmail.com");
         * Davide.setPassword("costata"); Davide.setImmagine("immagine.png");
         * Davide.setTipo("Organizzatore"); Davide.setEnte("Uniss");
         * autori.add(Davide);
         *
         * Marco.setId(3); Marco.setNome("Marco"); Marco.setCognome("Tomasi");
         * Marco.setEmail("marco@gmail.com"); Marco.setPassword("computer");
         * Marco.setImmagine("immagine.png"); Marco.setTipo("Autore");
         * Marco.setEnte("Unica"); autori.add(Marco);
         *
         */
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select * from utenti";

            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Utente utente = new Utente();
                utente.setId(set.getInt("id"));
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
                utente.setId(set.getInt("id"));
                utente.setNome(set.getString("nome"));
                utente.setCognome(set.getString("cognome"));
                utente.setEmail(set.getString("email"));
                utente.setPassword(set.getString("password"));
                utente.setImmagine(set.getString("immagine"));
                utente.setTipo(set.getBoolean("tipoUtente"));
                utente.setEnte(set.getString("ente"));
                stmt.close();
                conn.close();
                return utente;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Boolean deleteUtente(int id) {
        Connection conn = null;
        try {
            conn = DbManager.getInstance().getDbConnection();
            conn.setAutoCommit(false);

            String articoli = "DELETE FROM articoli WHERE autore = ?";

            PreparedStatement stmt = conn.prepareStatement(articoli);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            String utente = "DELETE FROM utenti WHERE id_utente=?";

            stmt = conn.prepareStatement(utente);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            stmt.close();
            conn.close();
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
        return true;
    }

    public Boolean insertUtente(Utente nuovoUtente) {
        Connection conn = null;
        try {
            /*String insert = "INSERT INTO utenti(id, nome, cognome, email, "
                    + "password, immagine, ente, tipoUtente)VALUES WHEN (default, "
                    + "nome=?, cognome=?, email=?, password=?, immagine=?, ente=?, tipoUtente=?";*/

            conn = DbManager.getInstance().getDbConnection();

            /*String insert = "insert into utenti (id, nome, cognome, email, password, immagine, ente, tipoUtente)
                                values (default, 'antonio', 'cossu', 'cossu@gmail.com', '123', 'foto', 'unica', true);";*/
            String insert = "insert into utenti (id, nome, cognome, email, password, immagine, ente, tipoUtente)\n"
                    + "values (default, '" + nuovoUtente.getNome() + "','" 
                    + nuovoUtente.getCognome() + "','" + nuovoUtente.getEmail() 
                    + "','" + nuovoUtente.getPassword() + "','" + nuovoUtente.getImmagine() 
                    + "','" + nuovoUtente.getEnte() + "'," + "true)";

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
}
