/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

/**
 *
 * @author Andreea
 */
public class Post {

   
    
    public enum Type {
        TEXT, IMAGE, LINK;
    };

    private int id;
    private UtentiRegistrati user; //chi pubblica
    private Gruppi gruppi;
    private String content;
    private Type postType;
    private String allegato;
    private String connectionString;
    

    public Post() {
        id = 0;
        user = null;
        content = "";
        postType = Type.TEXT;
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

    /**
     * @return the user
     */
    public UtentiRegistrati getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UtentiRegistrati user) {
        this.user = user;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    
    }
    
     /**
     * @return the allegato
     */
    public String getAllegato() {
        return allegato;
    }

    /**
     * @param allegato the allegato to set
     */
    public void setAllegato(String allegato) {
        this.allegato = allegato;
    }
    
        /**
     * @return the connectionString
     */
    public String getConnectioString() {
        return connectionString;
    }

    /**
     * @param connectionString the connectionString to set
     */
    public void setConnectioString(String connectionString) {
        this.connectionString = connectionString;
    }
    
     /**
     * @return the gruppi
     */
    public Gruppi getGruppi() {
        return gruppi;
    }

    /**
     * @param gruppi the gruppi to set
     */
    public void setGruppi(Gruppi gruppi) {
        this.gruppi = gruppi;
    }
    
}