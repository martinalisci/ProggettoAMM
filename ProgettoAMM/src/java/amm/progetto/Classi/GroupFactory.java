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
public class GroupFactory {
    private static GroupFactory singleton;
    
    private static GroupFactory getInstance(){
        if(singleton==null){
            singleton = new GroupFactory();
        }
        return singleton;
    }
    
    private ArrayList<Group> listaGruppi = new ArrayList<Group>();
    
    private GroupFactory(){
        Group gruppo1 = new Group();
        gruppo1.setNome("Mongolfieristi");
        gruppo1.setId(0);
        
        Group gruppo2 = new Group();
        gruppo2.setNome("Ritardatari");
        gruppo2.setId(1);
        
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
        
    }
    
    public Group getGruppoById(int id){
        for(Group gruppo : listaGruppi){
            if(gruppo.getId() == id){
                return gruppo;
            }
        }
        return null;
    }  
    
    public ArrayList getGruppoByNome(String nome){
        ArrayList<Group> groupList = new ArrayList();
        for(Group gruppo : listaGruppi){
            if((gruppo.getNome()).equals(nome)){
                groupList.add(gruppo);
            }
        }
        return groupList;
    }
    
}