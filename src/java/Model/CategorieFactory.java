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
public class CategorieFactory {

    private static CategorieFactory singleton;

    private CategorieFactory() {

    }

    public static CategorieFactory getInstance() {
        if (singleton == null) {
            singleton = new CategorieFactory();
        }
        return singleton;
    }

    public List<Categoria> getCategorie() {
        List<Categoria> categorie = new ArrayList();

        Categoria ia = new Categoria("IA", false);
        Categoria web = new Categoria("WEB", false);
        Categoria java = new Categoria("JAVA", false);
        Categoria python = new Categoria("Python", false);
        Categoria oop = new Categoria("OOP", false);
        Categoria reti = new Categoria("Reti", false);

        categorie.add(ia);
        categorie.add(web);
        categorie.add(java);
        categorie.add(python);
        categorie.add(oop);
        categorie.add(reti);

        return categorie;
    }
}
