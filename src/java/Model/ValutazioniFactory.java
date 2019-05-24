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
        
        String comm1= "Ottima scrittura";
        String comm2= "Pessima argomentazione";
        
        Valutazione val1= new Valutazione();
        val1.setId(1);
        val1.setStelle(3);
        val1.setCommAut(comm2);
        val1.setCommOrg(comm1);
        
        Valutazione val2= new Valutazione();
        val2.setId(2);
        val2.setStelle(2);
        val2.setCommAut("E'bello");
        val2.setCommOrg(comm2);
        
        Valutazione val3= new Valutazione();
        val3.setId(3);
        val3.setStelle(5);
        val3.setCommAut(comm1);
        val3.setCommOrg(comm1);
        
        Valutazione val4= new Valutazione();
        val4.setId(4);
        val4.setStelle(1);
        val4.setCommAut(comm2);
        val4.setCommOrg(comm2);
        
        valutazioni.add(val1);
        valutazioni.add(val2);
        valutazioni.add(val3);
        valutazioni.add(val4);
        
        return valutazioni;
    }
    
    public Valutazione getValutazioneById(int id){
       List<Valutazione> valutazioni= ValutazioniFactory.getInstance().getValutazioni();
       
       for (Valutazione v : valutazioni){
           if(v.getId()==id){
               return v;
           }
       }
       return null;
    }
}
