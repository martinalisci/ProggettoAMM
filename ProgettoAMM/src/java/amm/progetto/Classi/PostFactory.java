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
public class PostFactory {
    private static PostFactory singleton;
    private String connectionString;
    
    public static PostFactory getInstance(){
        if (singleton == null){
            singleton = new PostFactory();
        }
        return singleton;
    }
    
     public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
  
    private PostFactory(){
    }
   
    public ArrayList <Post> getPostByAutore(User usr){
        ArrayList<Post> listaPost = new ArrayList<Post>();
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = 
                      "select * from posts "
                    + "join posttype on posts.type = posttype_id " //spazio
                    + "where author = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, usr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Post current = new Post();
                //imposto id del post
                current.setId(res.getInt("post_id"));
                
                //impost il contenuto del post
                current.setContenuto(res.getString("contenuto"));
                
                //imposto il tipo del post
                current.setPostType(this.postTypeFromString(res.getString("posttype_nome")));

                //imposto l'autore del post
                current.setAutore(usr);
                
                listaPost.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaPost;
    }
    
    public void addPost(Post post){
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "ammdb");
            
            String query = 
                      "insert into posts (post_id, contenuto, type, author) "
                    + "values (default, ? , ? , ? )";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setString(1, post.getContenuto());

            stmt.setInt(2, this.postTypeFromEnum(post.getPostType()));
            
            stmt.setInt(3, post.getAutore().getId());
            
            // Esecuzione query
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
 
     private Post.Type postTypeFromString(String type){
        
        if(type.equals("IMAGE"))
            return Post.Type.IMAGE;
        
        return Post.Type.TEXT;
    }
    
    private int postTypeFromEnum(Post.Type type){
        //È realizzabile in modo più robusto rispetto all'hardcoding degli indici
        if(type == Post.Type.TEXT)
                return 1;
            else
                return 2;
    }
    
}
