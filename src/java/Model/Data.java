/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author antonio
 */
public class Data {
    
    private int giorno;
    private int mese;
    private int anno;
    
    public Data(int g, int m, int a){
        this.giorno=g;
        this.mese=m;
        this.anno=a;
    }

    /**
     * @return the giorno
     */
    public int getGiorno() {
        return giorno;
    }

    /**
     * @param giorno the giorno to set
     */
    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    /**
     * @return the mese
     */
    public int getMese() {
        return mese;
    }

    /**
     * @param mese the mese to set
     */
    public void setMese(int mese) {
        this.mese = mese;
    }

    /**
     * @return the anno
     */
    public int getAnno() {
        return anno;
    }

    /**
     * @param anno the anno to set
     */
    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    @Override
    public String toString(){
        Integer g=(Integer)giorno;
        Integer m=(Integer)mese;
        Integer a=(Integer)anno;
        return g.toString()+"/"+m.toString()+"/"+a.toString();        
    }
    
    
}
