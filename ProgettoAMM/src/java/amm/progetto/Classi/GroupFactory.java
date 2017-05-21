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
public class GroupFactory {
    private static GroupFactory singleton;
    private String connectionString;
    
    public static GroupFactory getInstance(){
        if(singleton==null){
            singleton = new GroupFactory();
        }
        return singleton;
    }
    
     public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
    private GroupFactory(){ 
    }

    public ArrayList getGruppoByMembro(User utente){
        ArrayList<Group> groupList = new ArrayList();
        try{
            Connection conn = DriverManager.getConnection(connectionString, "adminUser","admin");
            String query = "select * from gruppi "+
                    "join gruppi on membri.id_gruppo = gruppi.gruppo_id"
                    +"join utenti on membri.id_utente = utenti.utente_id"
                    +"where utente_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,utente.getId()); //il primo punto di domanda viene sostituito con id
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                Group current = new Group();
                current.setId(res.getInt("gruppo_id"));
                current.setNome(res.getString("nome"));
                current.setUrlFoto(res.getString("urlFotoProfilo"));

                groupList.add(current);
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return groupList;
    }
 
}
