/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.progetto.Classi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public UserFactory(){
    }
 
    public ArrayList getListaUtenti(){
        ArrayList<User> listaUtenti = new ArrayList<User>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "adminUser", "admin");
            
            String query = "select * from utenti ";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);          
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            // ciclo sulle righe restituite
            while (res.next()) {
                
                User current = new User();
                current.setId(res.getInt("utente_id"));
                current.setNome(res.getString("nome"));
                current.setCognome("cognome");
                current.setUsername("username");
                current.setPassword("password");
                current.setUrlFotoProfilo("urlFotoProfilo");
                
                listaUtenti.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUtenti;
    }

    public User getUserById(int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "adminUser","admin");
            String query = "select * from utenti "+"where utente_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
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

public int getIdByUserAndPassword(String username,String password){
    try{
        Connection conn = DriverManager.getConnection(connectionString, "adminUser","admin");
        String query = "select utente_id from utenti "+"where username = ? and password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1,username); //il primo punto di domanda viene sostituito con user       
        stmt.setString(2,password);
        ResultSet res = stmt.executeQuery();
         if(res.next()){
            int id = res.getInt("utente_id");
            stmt.close();
            conn.close();
            return id;
        }
        stmt.close();
        conn.close();
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    return -1;
}

}