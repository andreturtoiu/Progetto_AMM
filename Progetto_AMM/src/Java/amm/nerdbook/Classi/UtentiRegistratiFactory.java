/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.ArrayList;
/**
 *
 * @author Andreea
 */
public class UtentiRegistratiFactory {
     //Pattern Design Singleton
    private static UtentiRegistratiFactory singleton;
    
    public static UtentiRegistratiFactory getInstance() {
    if (singleton == null) {
        singleton = new UtentiRegistratiFactory();
    }
    return singleton;
    }
    
    private ArrayList<UtentiRegistrati> listaUtentiRegistrati = new ArrayList<UtentiRegistrati>();
    
    public UtentiRegistratiFactory(){
        //Creo Utenti Registriati
        
        UtentiRegistrati utente1 = new UtentiRegistrati();
        utente1.setId(0);
        utente1.setNome("Bugs");
        utente1.setCognome("Bunny");
        utente1.setPassword("123");
        utente1.setUrlFotoProfilo("img/bunny.jpg");
        utente1.setFraseDescrizione("");
        utente1.setDataNascita("27/07/1940");
        
        
        UtentiRegistrati utente2 = new UtentiRegistrati();
        utente2.setId(1);
        utente2.setNome("Deadpool");
        utente2.setCognome("");
        utente2.setPassword("456");
        utente2.setUrlFotoProfilo("img/images.jpg");
        //utente2.setFraseDescrizione("");
        utente2.setDataNascita("07/02/1991");
        
        UtentiRegistrati utente3 = new UtentiRegistrati();
        utente3.setId(2);
        utente3.setNome("Jerry");
        utente3.setCognome("");
        utente3.setPassword("789");
        utente3.setUrlFotoProfilo("img/images1.jpg");
        utente3.setFraseDescrizione("");
        utente3.setDataNascita("01/01/1940");
        
        listaUtentiRegistrati.add(utente1);
        listaUtentiRegistrati.add(utente2);
        listaUtentiRegistrati.add(utente3);
    }
    
    public UtentiRegistrati getUtentiRegistratiById(int id) {
        for (UtentiRegistrati utente : this.listaUtentiRegistrati) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String user, String password){
        for(UtentiRegistrati utente : this.listaUtentiRegistrati){
            if(utente.getNome().equals(user) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
}
