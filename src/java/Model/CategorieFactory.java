/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        /*
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
        */
        
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select * from categorie";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                Categoria cat= new Categoria();
                cat.setNome(set.getString("nome"));
                cat.setCheck(set.getBoolean("selezionata"));
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorie;
    }
}
