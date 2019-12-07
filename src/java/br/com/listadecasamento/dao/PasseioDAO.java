/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.dao;


import br.com.listadecasamento.model.Passeio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipery03
 */
public class PasseioDAO implements GenericDAO{
    
    private DataSource dataSource;
    
    public PasseioDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public int create(Object o){
        return 0;
    }
    public List<Object> read(){
        try{
                String SQL = "SELECT * from tblPasseio";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                ResultSet rs = stm.executeQuery();
                ArrayList<Object> result = new ArrayList<Object>();
                while(rs.next()){
                    Passeio passeio = new Passeio();
                    passeio.setId(rs.getInt("id"));
                    passeio.setTitulo(rs.getString("titulo"));
                    passeio.setPreco(rs.getFloat("preco"));
                    passeio.setUrlFoto(rs.getString("urlFoto"));
                    result.add(passeio);
                }  
                stm.close();
                rs.close();
                return result;
                
            
        }
        catch(SQLException ex){
             System.out.println("Erro ao recuperar o usuário " + ex.getMessage());
        }
        return null;
    }
    public List<Object> read(int id){
        List<Object> result = null;
        try{
            String sql = "SELECT * FROM tblPasseio WHERE id=?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()){
                Passeio p= new Passeio();
                p.setId(rs.getInt("id")); // aqui é o nome da coluna na tablea
                p.setTitulo(rs.getString("titulo"));
                p.setPreco(rs.getFloat("preco"));
                p.setUrlFoto(rs.getString("urlFoto"));
                result.add(p);
            }
            rs.close();
            stm.close();
        }
        catch(Exception ex){
            System.out.println("PASSEIODAO.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
        }
        return result;
    }
    public void update(Object o){
        // nao faz nada
    }
    public void delete(Object o){
        // nao faz nada
    }

}

