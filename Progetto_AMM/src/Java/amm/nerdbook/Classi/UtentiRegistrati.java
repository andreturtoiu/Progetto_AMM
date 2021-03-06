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
public class UtentiRegistrati {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String urlFotoProfilo;
    private String fraseDescrizione;
    private String dataNascita;
	
    public String connectionString;
	
    public UtentiRegistrati() {
        id = 0;
        nome = null;
        cognome = null;
        password = null;
		urlFotoProfilo = null;
		fraseDescrizione = null;
        dataNascita = null;
    }
    
    public boolean completo(){
        if(this.nome !=null && this.cognome != null && 
                this.fraseDescrizione != null && this.urlFotoProfilo != null)
           return true;
        else 
           return false;
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
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    /**
     * @return the fraseDescrizione
     */
    public String getFraseDescrizione() {
        return fraseDescrizione;
    }

    /**
     * @param fraseDescrizione the fraseDescrizione to set
     */
    public void setFraseDescrizione(String fraseDescrizione) {
        this.fraseDescrizione = fraseDescrizione;
    }

    /**
     * @return the dataNascita
     */
    public String getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
	
	public boolean confirmPass(String password){
		return this.password.equals(password);
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

}