/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipery03
 */
public class Carrinho {
    private float total;
    private ArrayList<ItemCarrinho> itens;
    
    public Carrinho(){
        itens = new ArrayList<>();
        total = 0.0f;                
    }
    
    public void add(Passeio passeio){
        
        boolean flag = false;
        for(ItemCarrinho item : this.itens){ 
            if(item.getPasseio().getId() == passeio.getId()){
                item.setQtde(item.getQtde() + 1);
                flag = true;
                break;
            }            
        }
        if(!flag){
            ItemCarrinho it = new ItemCarrinho();
            it.setPasseio(passeio);
            it.setQtde(1);
            itens.add(it);
        }    
            
        Float preco = passeio.getPreco();
        total+= preco;
     
    }

    
    public void remover(int idProduto){
        ItemCarrinho item=null;
        float qtde=0;
        for (ItemCarrinho it : itens){
            if (it.getPasseio().getId() == idProduto){
                item = it;
                qtde = it.getQtde();
                break;
            }
        }
        total -= item.getPasseio().getPreco() * qtde;
        itens.remove(item);
    }
    
    public float getTotal(){
        return this.total;
    }
    public List<ItemCarrinho> getItens(){
        return this.itens;
    }
    
}

