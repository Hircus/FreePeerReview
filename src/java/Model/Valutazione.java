/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tobias
 */
public class Valutazione {
    private int id;
    private int stelle;
    private String commAut;
    private String commOrg;

    public Valutazione() {
        this.commAut= "Nessun Commento";
        this.commOrg = "Nessun Commento";
        this.stelle= 1;
    }
    
    public Valutazione(int id, int stelle, String commAut, String commOrg){
        this.id= id;
        this.commAut= commAut;
        this.commOrg = commOrg;
        this.stelle= stelle;
    }

    /**
     * @return the stelle
     */
    public int getStelle() {
        return stelle;
    }

    /**
     * @param stelle the stelle to set
     */
    public void setStelle(int stelle) {
        this.stelle = stelle;
    }

    /**
     * @return the commAut
     */
    public String getCommAut() {
        return commAut;
    }

    /**
     * @param commAut the commAut to set
     */
    public void setCommAut(String commAut) {
        this.commAut = commAut;
    }

    /**
     * @return the commOrg
     */
    public String getCommOrg() {
        return commOrg;
    }

    /**
     * @param commOrg the commOrg to set
     */
    public void setCommOrg(String commOrg) {
        this.commOrg = commOrg;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
