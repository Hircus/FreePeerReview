/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author tobias
 */
public class ValutazioniFactory {
    
    private static ValutazioniFactory singleton;
    
    public ValutazioniFactory(){
    
    }
    
    public static ValutazioniFactory getInstance(){
        if(singleton==null){
            singleton= new ValutazioniFactory();
        }
        return singleton;
    }
    
    public List<Valutazione> getValutazioni(){
        List<Valutazione> valutazioni= new ArrayList<>();
        
        /*
        Valutazione val1= new Valutazione(1, 3, "Fa schifo", "E' bello");
        Valutazione val2= new Valutazione(2, 2, "E' bello", "Fa schifo");
        Valutazione val3= new Valutazione(3, 5, "E' bello", "E' bello");
        Valutazione val4= new Valutazione(4, 1, "Fa schifo", "Fa schifo");*/
        
        Valutazione val1= new Valutazione();
        val1.setId(1);
        val1.setStelle(3);
        val1.setCommAut("Fa schifo");
        val1.setCommOrg("E' bello");
        
        Valutazione val2= new Valutazione();
        val2.setId(2);
        val2.setStelle(2);
        val2.setCommAut("E'bello");
        val2.setCommOrg("Fa schifo");
        
        Valutazione val3= new Valutazione();
        val3.setId(3);
        val3.setStelle(5);
        val3.setCommAut("E' bello");
        val3.setCommOrg("E' bello");
        
        Valutazione val4= new Valutazione();
        val4.setId(4);
        val4.setStelle(1);
        val4.setCommAut("Fa schifo");
        val4.setCommOrg("Fa schifo");
        
        valutazioni.add(val1);
        valutazioni.add(val2);
        valutazioni.add(val3);
        valutazioni.add(val4);
        
        return valutazioni;
    }
    
    public Valutazione getValutazioneById(int id){
       List<Valutazione> valutazioni= ValutazioniFactory.getInstance().getValutazioni();
       Valutazione val= new Valutazione();
       
       for (Valutazione v : valutazioni){
           if(v.getId()==id){
               return val;
           }
       }
       return null;
    }
}
