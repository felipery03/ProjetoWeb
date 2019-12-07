/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.dao;

import br.com.listadecasamento.model.Convidado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipery03
 */
public class ConvidadoDAO implements GenericDAO{
    
    private DataSource dataSource;
    
    public ConvidadoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    @Override
    public int create(Object o){   
        try
            {
            if (o instanceof Convidado){
                Convidado convidado = (Convidado)o;
                String SQL = "INSERT INTO tblConvidado (id, nome, privilegio) VALUES(null,?, 0)";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, convidado.getName());         
            int res = stm.executeUpdate();
            if(res != 0){
                ResultSet rs = stm.getGeneratedKeys();
                if(rs.next()){
                    convidado.setId(rs.getInt(1));
                }
                rs.close();
            }
            stm.close();
            }
            else{
                throw new RuntimeException("Invalid User Model Object"); 
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao inserir usuário" + ex.getMessage());
        }
        return 0;
    }
    @Override
       public List<Object> read(){
        try{
                String SQL = "SELECT * from tblConvidado WHERE privilegio = 0";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                ResultSet rs = stm.executeQuery();
                ArrayList<Object> result = new ArrayList<Object>();
                while(rs.next()){
                    Convidado convidado = new Convidado();
                    convidado.setId(rs.getInt("id"));
                    convidado.setName(rs.getString("nome"));
                    convidado.setEmail(rs.getString("email"));
                    convidado.setAdmin(rs.getInt("privilegio"));
                    result.add(convidado);
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
    public List<Object> read(Object o){
        try{
            if (o instanceof Convidado){
                Convidado  incompleto = (Convidado)o;
                String SQL = "SELECT * from tblConvidado WHERE nome = ?";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setString(1, incompleto.getName());
                ResultSet rs = stm.executeQuery();
                ArrayList<Object> result = new ArrayList<Object>();
                if(rs.next()){
                    Convidado convidado = new Convidado();
                    convidado.setId(rs.getInt("id"));
                    convidado.setName(rs.getString("nome"));
                    convidado.setEmail(rs.getString("email"));
                    convidado.setAdmin(rs.getInt("privilegio"));
                    result.add(convidado);
                    
                }
                stm.close();
                rs.close();
                return result;
                
            }
            else{
                throw new RuntimeException("Invalid Object");
            }
        }
        catch(SQLException ex){
             System.out.println("Erro ao recuperar o usuário " + ex.getMessage());
        }
        return null;
       
    }
    public void update(Object o){
        try
            {if (o instanceof Convidado){
                Convidado convidado = (Convidado)o;
                String SQL = "UPDATE tblConvidado SET email=? WHERE id = ?;";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, convidado.getEmail());       
                stm.setString(2, String.valueOf(convidado.getId()));
            int res = stm.executeUpdate();
            if(res != 0){
                ResultSet rs = stm.getGeneratedKeys();
                if(rs.next()){
                 //   convidado.setId(rs.getInt(1));
                }
                rs.close();
            }
            stm.close();
            }
            else{
                throw new RuntimeException("Invalid User Model Object"); 
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar usuário" + ex.getMessage());
        }
    
    }
    public void delete(Object o){
         try
            {if (o instanceof Convidado){
                Convidado convidado = (Convidado)o;
                String SQL = "DELETE FROM tblConvidado WHERE nome = ?;";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, convidado.getName());         
            int res = stm.executeUpdate();
            if(res != 0){
                ResultSet rs = stm.getGeneratedKeys();
                if(rs.next()){
                    convidado.setId(rs.getInt(1));
                }
                rs.close();
            }
            stm.close();
            }
            else{
                throw new RuntimeException("Invalid User Model Object"); 
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao remover usuário" + ex.getMessage());
        }
    }

}
