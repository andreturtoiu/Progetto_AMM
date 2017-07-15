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
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Andreea
 */
public class PostFactory {
    
     //Pattern Design Singleton
    private static PostFactory singleton;
    private String connectionString;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
     
    private PostFactory() {}

    
    //Se sono sulla bacheca dell'utente loggato vedo anche i post dei gruppi,
    public List getPostList(UtentiRegistrati user) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
         String query = "SELECT post.*, postType.nome"
                            + " FROM post "

                            + "JOIN postType ON post.tipo = postType.id "

                            + "WHERE idUser=? OR "

                            + "idGroup IN (SELECT id FROM gruppi "

                                + "JOIN iscrizioni ON Gruppi.id = iscrizioni.idGruppi "

                                + "WHERE idUtenti = ?) "

                            + "ORDER BY post.id DESC" 
                    ;
					
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());
            stmt.setInt(2, user.getId());
            
           
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            List<Post> listaPost = new ArrayList();
            // ciclo sulle righe restituite
            while (res.next()) {
                Post post = new Post();     
                post.setContent(res.getString("contenuto"));
                post.setAllegato(res.getString("allegato"));
                post.setId(res.getInt("id"));
                post.setUser(UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(res.getInt("autore")));
                post.setGruppi(GruppiFactory.getInstance().getGruppiById(res.getInt("idGroup")));
                post.setPostType(postTypeFromString(res.getString("nome")));
                listaPost.add(post);          
            }
             
            stmt.close();
            conn.close();
            
            return listaPost;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
       
    }
   
    public List getPostListbyOtherUser(UtentiRegistrati user){
                try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
         String query = "SELECT post.*, postType.nome"
                            + " FROM post "

                            + "JOIN postType ON post.tipo = postType.id "

                            + "WHERE idUser=? "

                            + "ORDER BY post.id DESC" 
                    ;
					
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, user.getId());

            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            List<Post> listaPost = new ArrayList();
            // ciclo sulle righe restituite
            while (res.next()) {
                Post post = new Post();     
                post.setContent(res.getString("contenuto"));
                post.setAllegato(res.getString("allegato"));
                post.setId(res.getInt("id"));
                post.setUser(UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(res.getInt("autore")));
                post.setGruppi(GruppiFactory.getInstance().getGruppiById(res.getInt("idGroup")));
                post.setPostType(postTypeFromString(res.getString("nome")));
                listaPost.add(post);          
            }
             
            stmt.close();
            conn.close();
            
            return listaPost;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    
    
    
    }
        
    public List getPostListByGroup(Gruppi gruppo) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");

            String query = "SELECT post.*, postType.nome"
                            + " FROM post "

                            + "JOIN postType ON post.tipo = postType.id "

                            + "WHERE idGroup = ? "

                            + "ORDER BY post.id DESC" 
                    ;

            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);

            // Si associano i valori
            stmt.setInt(1, gruppo.getId());

            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            List<Post> listaPost = new ArrayList();
            // ciclo sulle righe restituite
            while (res.next()) {
                Post post = new Post();

                post.setContent(res.getString("contenuto"));
                post.setAllegato(res.getString("allegato"));
                post.setId(res.getInt("id"));
                post.setGruppi(GruppiFactory.getInstance().getGruppiById(res.getInt("idGroup")));
                post.setUser(UtentiRegistratiFactory.getInstance().getUtentiRegistratiById(res.getInt("autore")));
                post.setPostType(postTypeFromString(res.getString("nome")));
                listaPost.add(post);          
            }

            stmt.close();
            conn.close();

            return listaPost;
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
    
     private Post.Type postTypeFromString(String type){    
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        if(type.equals("LINK"))
            return Post.Type.LINK;
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type){
        if(type == Post.Type.TEXT)
                return 1;
        else if(type == Post.Type.IMAGE)
                return 2;
        else 
            return 3;
    }
    
    public void newPost(Post post , int utenteDest, int groupDest){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "Andreea", "1234");
            
            String query = "INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser ) " +
                           "VALUES (default,?,?,?,?,?,?)"
                    ;
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, post.getUser().getId());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getAllegato());
            stmt.setInt(4,postTypeFromEnum(post.getPostType()));
            if(groupDest != -1)
                stmt.setInt(5, groupDest);
            else 
                stmt.setString(5, null);
            
            if(utenteDest != -1)
                stmt.setInt(6, utenteDest);
            else 
                stmt.setString(6, null);
             
            // Esecuzione query
            stmt.execute();
   
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
        
}