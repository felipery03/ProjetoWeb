/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.model;

/**
 *
 * @author felipery03
 */
public class ItemCarrinho {
    private Passeio passeio;
    public int qtde;

    /**
     * @return the produto
     */
    public Passeio getPasseio() {
        return passeio;
    }

    /**
     * @param produto the produto to set
     */
    public void setPasseio(Passeio passeio) {
        this.passeio = passeio;
    }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    
}

