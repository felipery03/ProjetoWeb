/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.dao;

import java.util.List;

/**
 *
 * @author felipery03
 */
public interface GenericDAO {
    public int create(Object o);
    public List<Object> read();
    public void update(Object o);
    public void delete(Object o);
    
    
}
