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
import java.util.logging.Level;
import java.util.logging.Logger;

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
                utente.setEmail(res.getString("email"));
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
    
    
    public List<UtentiRegistrati> getListaAmiciByUser(int id){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            List<UtentiRegistrati> friends = new ArrayList();
			
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
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
    
            // ciclo sulle righe restituite
            while (res.next()) {
                UtentiRegistrati utente = new UtentiRegistrati();
                utente.setId(res.getInt("id"));
                utente.setNome(res.getString("nome"));
                utente.setCognome(res.getString("cognome"));
                utente.setEmail(res.getString("email"));
                utente.setPassword(res.getString("password"));
                utente.setUrlFotoProfilo(res.getString("urlProfilo"));
                utente.setFraseDescrizione(res.getString("frasePresentazione"));
                utente.setDataNascita(res.getString("dataNascita"));
                
                friends.add(utente);
            }
            
            stmt.close();
            conn.close();
            return friends;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public void deleteUser(int userID){
            Connection conn = null;
            PreparedStatement stmtPosts = null;
            PreparedStatement stmtGroups = null;
            PreparedStatement stmtGroups2 = null;
            PreparedStatement stmtFriends = null;
            PreparedStatement stmtUsers = null;
            try {
           
                conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
                conn.setAutoCommit(false);

                String queryPosts = "DELETE FROM Post "
                           + "WHERE autore = ? OR idUser = ?";
                
                String queryGroups = "DELETE FROM iscrizioni "
                                 + "WHERE idUtenti = ? OR idGruppi IN "
                                 + " (SELECT id FROM Gruppi " 
                                 + " WHERE amministratore = ?)";
                String queryGroups2 = "DELETE FROM gruppi "
                                     + "WHERE amministratore = ?" ;
                
                String queryFriends = "DELETE FROM amicizie "
                                  + "WHERE idUtente1 = ? OR idUtente2 = ?";
                
                String queryUsers = "DELETE FROM Utenti "
                               + "WHERE id = ?";

                // Prepared Statement
                stmtPosts = conn.prepareStatement(queryPosts);
                stmtGroups = conn.prepareStatement(queryGroups);
                stmtGroups2 = conn.prepareStatement(queryGroups2);                
                stmtFriends = conn.prepareStatement(queryFriends);
                stmtUsers = conn.prepareStatement(queryUsers);
                // Si associano i valori
                stmtPosts.setInt(1, userID);
                stmtPosts.setInt(2, userID);
                stmtGroups.setInt(1, userID);
                stmtGroups.setInt(2, userID);
                stmtGroups2.setInt(1, userID);
                stmtFriends.setInt(1, userID);
                stmtFriends.setInt(2, userID);
                stmtUsers.setInt(1, userID);

                // Esecuzione query e rendo la modifica permanente dopo le varie modifiche
                stmtPosts.executeUpdate();
                stmtGroups.executeUpdate();
                stmtGroups2.executeUpdate();
                stmtFriends.executeUpdate();
                stmtUsers.executeUpdate();
                conn.commit();

            } catch (SQLException e) {
                if(conn!=null){
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        Logger.getLogger(UtentiRegistratiFactory.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
            } finally{
                try{
                    if(stmtPosts!=null)
                        stmtPosts.close();
                    if(stmtGroups!=null)
                        stmtGroups.close();
                    if(stmtGroups2!=null)
                        stmtGroups2.close();
                    if(stmtFriends!=null)
                        stmtFriends.close();
                    if(stmtUsers!=null)
                        stmtUsers.close();
                    if(conn!=null){
                        conn.setAutoCommit(true);
                        conn.close();
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(UtentiRegistratiFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
	
    }

        
    public void updateProfilo(UtentiRegistrati user){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
            String query = 
                    "UPDATE utenti SET nome = ?, cognome = ?, email = ?, "
                    + "password = ?, frasePresentazione = ?, urlProfilo = ?, dataNascita = ? "
                    + "WHERE id = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getCognome());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getFraseDescrizione());
            stmt.setString(6, user.getUrlFotoProfilo());
            stmt.setString(7, user.getDataNascita());
            stmt.setInt(8,user.getId());
            // Esecuzione query
           stmt.execute();

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }    
        
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
}
