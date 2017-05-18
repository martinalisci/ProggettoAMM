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
public class PostFactory {
    private static PostFactory singleton;
    private String connectionString;
    
    public static PostFactory getInstance(){
        if (singleton == null){
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    private PostFactory(){
        UserFactory userFactory = UserFactory.getInstance();
        
        Post post1 = new Post();
        post1.setContenuto("bla bla bla");
        post1.setId_destinatario(0);
        post1.setId_autore(0);
        post1.setPostType(Post.Type.TEXT);
        
        Post post2 = new Post();
        post2.setContenuto("img/cibo.jpg");
        post2.setId_destinatario(1);
        post2.setId_autore(1);
        post2.setPostType(Post.Type.IMAGE);
        
        Post post3 = new Post();
        post3.setContenuto("http://it.wikihow.com/Creare-un-Cappello");
        post3.setId_destinatario(2);
        post3.setId_autore(2);
        post3.setPostType(Post.Type.TEXT);
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }
    
    public ArrayList<Post> getPostById_destinatario(int id){
        ArrayList<Post> postList = new ArrayList();
        for(Post post : listaPost){
            if(post.getId_destinatario() == id){
               postList.add(post);
            }
        }
        return postList;
    }
    
    public ArrayList <Post> getPostById_autore(int id){
        ArrayList<Post> postList = new ArrayList();
        for(Post post : listaPost){
            if(post.getId_autore() == id){
               postList.add(post);
            }
        }
        return postList;
    }
    
    public void addPost(Post post){
        listaPost.add(post);
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
}
