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

    public List<String> getCategorie() {
        List<String> categorie = new ArrayList();
        
        try {
            Connection conn = DbManager.getInstance().getDbConnection();
            Statement stmt = conn.createStatement();

            String sql = "select * from categorie";
            ResultSet set = stmt.executeQuery(sql);

            while (set.next()) {
                String cat;
                cat=set.getString("nome");
                categorie.add(cat);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorie;
    }
}
