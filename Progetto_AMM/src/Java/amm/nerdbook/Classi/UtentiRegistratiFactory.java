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
public class UtentiRegistratiFactory {
     //Pattern Design Singleton
    private static UtentiRegistratiFactory singleton;
    private String connectionString;
    
    public static UtentiRegistratiFactory getInstance() {
    if (singleton == null) {
        singleton = new UtentiRegistratiFactory();
    }
    return singleton;
    }
      
    public UtentiRegistratiFactory(){
      
    }
    
    public UtentiRegistrati getUtentiRegistratiById(int id) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
            String query = 
                      "select * from utenti "
                    + "where id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                UtentiRegistrati utente = new UtentiRegistrati();
                utente.setId(res.getInt("id"));
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setPassword(res.getString("password"));
                utente.setUrlFotoProfilo(res.getString("urlProfilo"));
                utente.setFraseDescrizione(res.getString("frasePresentazione"));
                utente.setDataNascita(res.getString("dataNascita"));


                stmt.close();
                conn.close();
                return utente;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
            String query = 
                      "SELECT id FROM utenti "
                    + "WHERE nome = ? AND password = ?" ;
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user);
            stmt.setString(2, password);
            
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                int id;
                id = res.getInt("id");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
        
    }
    
    
    public List<UtentiRegistrati> getListaAmiciByUser(UtentiRegistrati user){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
            String query =  "SELECT * FROM Utenti " +

                            "JOIN Amicizie ON Utenti.id = Amicizie.idUtente1 " +

                            "WHERE Amicizie.idUtente2 = ? " +

                            "UNION " +

                            "SELECT * FROM Utenti " +

                            "JOIN Amicizie ON Utenti.id = Amicizie.idUtente2 " +

                            "WHERE Amicizie.idUtente1 = ?"; 
                       
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            stmt.setInt(2, user.getId());
            
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
            List<UtentiRegistrati> utenti = new ArrayList();
            // ciclo sulle righe restituite
            while (res.next()) {
                UtentiRegistrati utente = new UtentiRegistrati();
                utente.setId(res.getInt("id"));
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setPassword(res.getString("password"));
                utente.setUrlFotoProfilo(res.getString("urlProfilo"));
                utente.setFraseDescrizione(res.getString("frasePresentazione"));
                utente.setDataNascita(res.getString("dataNascita"));
                
                utenti.add(utente);
            }
            
            stmt.close();
            conn.close();
            return utenti;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
}
