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
public class GruppiFactory {
    //Pattern Design Singleton
    private static GruppiFactory singleton;
    
 
    
    public static GruppiFactory getInstance() {
    if (singleton == null) {
        singleton = new GruppiFactory();
    }
    return singleton;
    }
    
    private ArrayList<Gruppi> listaGruppi = new ArrayList<Gruppi>();
    
    private GruppiFactory() {
        //Creo Gruppi

        //CartoonNetwork
        Gruppi gruppo1 = new Gruppi();
        gruppo1.setId(0);
        gruppo1.setNome("CartoonNetwork");
        gruppo1.setUrlImmagine("img/cn.png");

        //Marvel
        Gruppi gruppo2 = new Gruppi();
        gruppo2.setId(1);
        gruppo2.setNome("Marvel");
        gruppo2.setUrlImmagine("img/marvel.jpg");

        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
    }
    
}
