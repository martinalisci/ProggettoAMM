/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.progetto.Classi;

import java.util.ArrayList;

/**
 *
 * @author Martina
 */
public class UserFactory {
    private static UserFactory singleton;
    
    public static UserFactory getInstance(){
        if (singleton == null) {
            singleton = new UserFactory();
        }
        return singleton;
    }
    
    private ArrayList<User> listaUtenti = new ArrayList<User>();
    
    public UserFactory(){
        
        User utente1 = new User();
        utente1.setNome("Cappellaio");
        utente1.setCognome("Matto");
        utente1.setPassword("123");
        utente1.setUrlFotoProfilo("img/cappellaio.jpg");
        utente1.setId(0);
        
        User utente2 = new User();
        utente2.setNome("Stregatto");
        utente2.setCognome("Gatto");
        utente2.setPassword("123");
        utente2.setUrlFotoProfilo("img/stregatto.jpg");
        utente2.setId(1);
        
        User utente3 = new User();
        utente3.setNome("Pinco");
        utente3.setCognome("Panco");
        utente3.setPassword("123");
        utente3.setUrlFotoProfilo("img/pincopanco.jpg");
        utente3.setId(2);
        
        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
    }
    
    public User getUserById(int id) {
        for (User utente : this.listaUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }
    
    public ArrayList<User> getUserByNome(String nome){
        ArrayList<User> userList = new ArrayList();
        for (User utente : this.listaUtenti) {
            if ((utente.getNome()).equals(nome)){
                userList.add(utente);
            }
        }
        return userList;
    }
    
    public ArrayList<User> getUserByCognome(String cognome){
        ArrayList<User> userList = new ArrayList();
        for (User utente : this.listaUtenti) {
            if ((utente.getCognome()).equals(cognome))
                userList.add(utente);
        }
        return userList;
    }
    
    
    
}
