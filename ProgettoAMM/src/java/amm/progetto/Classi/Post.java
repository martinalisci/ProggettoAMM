/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.progetto.Classi;

/**
 *
 * @author Martina
 */
public class Post {

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
     * @return the autore
     */
    public User getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(User autore) {
        this.autore = autore;
    }
     public enum Type {
        TEXT, IMAGE
    };
    
    private int id;
    private User autore;
    private String contenuto;
    private Type postType;
    
    public Post() {
        id = -1;
        autore = null;
        contenuto = "";
        postType = Type.TEXT;
    }



    /**
     * @return the contenuto
     */
    public String getContenuto() {
        return contenuto;
    }

    /**
     * @param contenuto the contenuto to set
     */
    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * @return the postType
     */
    public Type getPostType() {
        return postType;
    }

    /**
     * @param postType the postType to set
     */
    public void setPostType(Type postType) {
        this.postType = postType;
    }
    

    

}
