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

    public List<Utente> getAutori() {
        List<Utente> autori = new ArrayList<>();

        Utente Gregorio = new Utente();
        Utente Davide = new Utente();
        Utente Marco = new Utente();

        Gregorio.setId(1);
        Gregorio.setNome("Gregorio");
        Gregorio.setCognome("Rivano");
        Gregorio.setEmail("gregorio@gmail.com");
        Gregorio.setPassword("sushi");
        Gregorio.setImmagine("immagine.png");
        Gregorio.setEnte("Unica");
        Gregorio.setTipo("Autore");
        autori.add(Gregorio);

        Davide.setId(2);
        Davide.setNome("Davide");
        Davide.setCognome("Piras");
        Davide.setEmail("davide@gmail.com");
        Davide.setPassword("costata");
        Davide.setImmagine("immagine.png");
        Davide.setTipo("Organizzatore");
        Davide.setEnte("Uniss");
        autori.add(Davide);

        Marco.setId(3);
        Marco.setNome("Marco");
        Marco.setCognome("Tomasi");
        Marco.setEmail("marco@gmail.com");
        Marco.setPassword("computer");
        Marco.setImmagine("immagine.png");
        Marco.setTipo("Autore");
        Marco.setEnte("Unica");
        autori.add(Marco);

        return autori;
    }

    public Utente getUtentebyID(int id) {
        List<Utente> autori = this.getAutori();

        for (Utente a : autori) {
            if (a.getId() == id) {
                return a;
            }
        }

        return null;
    }

    public Utente getUtenteEmailPassword(String pass, String email) {

        List<Utente> autori = this.getAutori();

        for (Utente a : autori) {
            if (a.getPassword().equals(pass) && a.getEmail().equals(email)) {
                return a;
            }
        }

        return null;
    }
}
