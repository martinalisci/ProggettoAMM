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
public class Group {

    private int id;
    private String nome;
    private String urlFoto;
    private ArrayList<Integer> membri;
    
    public Group(){
        id = 0;
        nome = "";
        urlFoto = "";
        membri = new ArrayList<>();
    }
    
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the urlFoto
     */
    public String getUrlFoto() {
        return urlFoto;
    }

    /**
     * @param urlFoto the urlFoto to set
     */
    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
    
     /**
     * @return the membri
     */
    public ArrayList<Integer> getMembri() {
        return membri;
    }

    /**
     * @param membro the membri to set
     */
    public void setMembri(int membro) {
        membri.add(membro);
    }
    
    
}
