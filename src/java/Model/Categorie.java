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
public class Categorie {
    
    private List<String> categorie;

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
        
    public Categorie(){
        categorie= new ArrayList<>();
        categorie.add("IA");
        categorie.add("WEB");
        categorie.add("Java");
        categorie.add("Python");
        categorie.add("OOP");
        categorie.add("Calcolatori");
    }
}
