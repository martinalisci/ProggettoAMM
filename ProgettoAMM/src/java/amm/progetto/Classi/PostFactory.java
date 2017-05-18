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
        post1.setId(0);
        post1.setUtente(userFactory.getUserById(0));
        post1.setPostType(Post.Type.TEXT);
        
        Post post2 = new Post();
        post2.setContenuto("img/cibo.jpg");
        post2.setId(1);
        post2.setUtente(userFactory.getUserById(1));
        post2.setPostType(Post.Type.IMAGE);
        
        Post post3 = new Post();
        post3.setContenuto("http://it.wikihow.com/Creare-un-Cappello");
        post3.setId(2);
        post3.setUtente(userFactory.getUserById(2));
        post3.setPostType(Post.Type.TEXT);
        
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
    }
    
    public Post getPostById(int id){
        for(Post post : listaPost){
            if(post.getId() == id){
                return post;
            }
        }
        return null;
    }
    
    public ArrayList getPostByUser(User utente){
        ArrayList<Post> postList = new ArrayList();
        for(Post post : listaPost){
            if(post.getUtente().equals(utente) ){
                postList.add(post);
            }
        }
        return postList;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
    
}
