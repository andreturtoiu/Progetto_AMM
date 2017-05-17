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
public class Gruppi {

    private int id;
    private String nome;
    private String urlImmagine;
    private String connectionString;
    private int amministratore;
    
    public Gruppi(){
        id = 0;
        nome = "";
        urlImmagine = "";
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the urlImmagine
     */
    public String getUrlImmagine() {
        return urlImmagine;
    }

    /**
     * @param urlImmagine the urlImmagine to set
     */
    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
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
     * @return the amministratore
     */
    public int getAmministratore() {
        return amministratore;
    }

    /**
     * @param amministratore the amministratore to set
     */
    public void setAmministratore(int amministratore) {
        this.amministratore = amministratore;
    }
}
