/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andreea
 */
public class GruppiFactory {
    //Pattern Design Singleton
    private static GruppiFactory singleton;
    private String connectionString;
    
 
    
    public static GruppiFactory getInstance() {
    if (singleton == null) {
        singleton = new GruppiFactory();
    }
    return singleton;
    }
    
    
    
    private GruppiFactory() {}
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    public Gruppi getGruppiById(int id){
        
         try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
            String query = "SELECT * FROM gruppi"
                    + " WHERE id = ?"     
                    ;
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);

            // Esecuzione query
            ResultSet res = stmt.executeQuery();
     
            // ciclo sulle righe restituite
            if (res.next()) {
                Gruppi gruppo = new Gruppi();  
                
                gruppo.setId(res.getInt("id"));
                gruppo.setNome(res.getString("nome"));
                gruppo.setUrlImmagine(res.getString("urlImmagine"));
                gruppo.setAmministratore(res.getInt("amministratore"));
                stmt.close();
                conn.close();
                
                            
                return gruppo;
            }
             
            stmt.close();
            conn.close();
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    
    }
    
    public List<Gruppi> getGruppiByUser(UtentiRegistrati user){
         try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
            String query = "SELECT * FROM gruppi "
                            + "JOIN iscrizioni ON gruppi.id = iscrizioni.idGruppi "
                    + " WHERE idUtenti= ?"     
                    ;
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());

            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            List<Gruppi> gruppiList = new ArrayList();
            // ciclo sulle righe restituite
            while (res.next()) {
                Gruppi gruppo = new Gruppi();  
                
                gruppo.setId(res.getInt("id"));
                gruppo.setNome(res.getString("nome"));
                gruppo.setUrlImmagine(res.getString("urlImmagine"));
                gruppo.setAmministratore(res.getInt("amministratore"));
                
                gruppiList.add(gruppo);
            }
            
             
            stmt.close();
            conn.close();
            return gruppiList;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;                 
    }
}
