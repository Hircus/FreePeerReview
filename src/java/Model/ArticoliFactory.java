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

        Articolo art = new Articolo();
        art.setId(1);
        art.setTitolo("Deep Learning con Python");
        art.setTesto("Python è un ottimo linguaggio");
        art.setImmagine("immagine1.png");
        art.setData(05, 04, 2019);
        art.setValutazione(5);
        Utente gregorio = AutoriFactory.getInstance().getUtentebyID(1);
        art.getAutori().add(gregorio);
        articoli.add(art);

        Articolo art2 = new Articolo();
        art2.setId(2);
        art2.setTitolo("La tecnologia FTTH");
        art2.setTesto("La fibra è molto veloce");
        art2.setImmagine("immagine2.png");
        art2.setData(15, 02, 2019);
        art2.setValutazione(4);
        art2.getAutori().add(gregorio);
        articoli.add(art2);

        Articolo art3 = new Articolo();
        art3.setId(3);
        Utente davide = AutoriFactory.getInstance().getUtentebyID(2);
        art3.setTitolo("Guida al Responsive Design");
        art3.setTesto("Il css è una merda");
        art3.setImmagine("immagine3.png");
        art3.setData(17, 04, 2018);
        art3.setValutazione(3);
        art3.getAutori().add(davide);
        articoli.add(art3);

        Articolo art4 = new Articolo();
        art4.setId(4);
        art4.setTitolo("L'importanza dell'ingegneria del software");
        art4.setTesto("Ingegneria è difficile");
        art4.setImmagine("immagine4.png");
        art4.setData(05, 12, 2017);
        art4.setValutazione(2);
        art4.getAutori().add(davide);
        articoli.add(art4);

        Utente marco = AutoriFactory.getInstance().getUtentebyID(3);
        art2.getAutori().add(marco);
        art4.getAutori().add(marco);
       
        return articoli;
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
