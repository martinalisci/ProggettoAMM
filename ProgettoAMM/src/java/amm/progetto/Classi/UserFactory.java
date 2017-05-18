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
    private String connectionString;
    
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
        utente1.setUsername("cappellaio");
        utente1.setFrase("bla bla");
        
        User utente2 = new User();
        utente2.setNome("Stregatto");
        utente2.setCognome("Gatto");
        utente2.setPassword("123");
        utente2.setUrlFotoProfilo("img/stregatto.jpg");
        utente2.setId(1);
        utente2.setUsername("stregatto");
        utente2.setFrase("bla bla");
        
        User utente3 = new User();
        utente3.setNome("Pinco");
        utente3.setCognome("Panco");
        utente3.setPassword("123");
        utente3.setUrlFotoProfilo("img/pincopanco.jpg");
        utente3.setId(2);
        utente3.setUsername("pincopanco");
        utente3.setFrase("bla bla");
        
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
    
    public int getIdByUserAndPassword(String username, String password){
        
        for(User utente : this.listaUtenti){
            if(utente.getUsername().equals(username) && utente.getPassword().equals(password)){
                return utente.getId();
            }
        }
        return -1;
    }
    
    public ArrayList getListaUtenti(){
        return listaUtenti;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
}

/*
public User getUserById(int id){
    try{
        Connection conn = DriverManager.getConnection(connectionString, "adminUser","admin");
        String query = "select * from utenti "+"where utente_id = ?";
        PreparedStatement stmt = conn.preparedStatement(query);
        stmt.setInt(1,id); //il primo punto di domanda viene sostituito con id
        ResultSet res = stmt.executeQuery();
        if(res.next()){
            User current = new User();
            current.setId(res.getInt("utente_id"));
            current.setUsername(res.getString("username"));
            current.setNome(res.getString("nome"));
            current.setCognome(res.getString("cognome"));
            current.setPassword(res.getString("password"));
            current.setUrlFotoProfilo(res.getString("urlProfilo"));
            
            stmt.close();
            conn.close();
            return current;
        }
        stmt.close();
        conn.close();
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    return null;
}

*/

/*
public int getIdByUserAndPassword(String username,String password){
    try{
        Connection conn = DriverManager.getConnection(connectionString, "adminUser","admin");
        String query = "select utente_id from utenti "+"where username = ? and password = ?";
        PreparedStatement stmt = conn.preparedStatement(query);
        stmt.setString(1,username); //il primo punto di domanda viene sostituito con user       
        stmt.setString(2,password);
        ResultSet res = stmt.executeQuery();
         if(res.next()){
            User current = new User();
            current.setId(res.getInt("utente_id"));
            current.setNome(res.getString("nome"));
            current.setUsername(res.getString("username"));
            current.setCognome(res.getString("cognome"));
            current.setPassword(res.getString("password"));
            current.setUrlFotoProfilo(res.getString("urlProfilo"));
            
            stmt.close();
            conn.close();
            return current.utente_id;
        }
        stmt.close();
        conn.close();
    }
}
*/

/*
public ArrayList<User> getUserByNome(String nome){
        ArrayList<User> userList = new ArrayList();
        for (User utente : this.listaUtenti) {
            if ((utente.getNome()).equals(nome)){
                userList.add(utente);
            }
        }
        return userList;

        try{
            Connection conn = DriverManager.getConnection(connectionString, "adminUser","admin");
            String query = "select * from utenti "+"where nome = ?";
            PreparedStatement stmt = conn.preparedStatement(query);
            stmt.setString(1,nome);
            ResultSet res = stmt.executeQuery();
             if(res.next()){
                ArrayList<User> userList = new ArrayList();
                User current = new User();
                current.setId(res.getInt("utente_id"));
                current.setNome(res.getString("nome"));
                current.setUsername(res.getString("username"));
                current.setCognome(res.getString("cognome"));
                current.setPassword(res.getString("password"));
                current.setUrlFotoProfilo(res.getString("urlProfilo"));
                userList.add(current);
                stmt.close();
                conn.close();
                return userList;
            }
            stmt.close();
            conn.close();
        }



    }

*/
