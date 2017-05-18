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
     public enum Type {
        TEXT, IMAGE
    };
    
    private int id_destinatario;
    private int id_autore;
    private String contenuto;
    private Type postType;
    
    public Post() {
        id_destinatario = -1;
        id_autore = -1;
        contenuto = "";
        postType = Type.TEXT;
    }

       /**
     * @return the id_destinatario
     */
    public int getId_destinatario() {
        return id_destinatario;
    }

    /**
     * @param id_destinatario the id_destinatario to set
     */
    public void setId_destinatario(int id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    /**
     * @return the id_autore
     */
    public int getId_autore() {
        return id_autore;
    }

    /**
     * @param id_autore the id_autore to set
     */
    public void setId_autore(int id_autore) {
        this.id_autore = id_autore;
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
