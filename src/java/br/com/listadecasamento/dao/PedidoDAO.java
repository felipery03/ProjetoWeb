/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.dao;

import br.com.listadecasamento.model.Carrinho;
import br.com.listadecasamento.model.ItemCarrinho;
import br.com.listadecasamento.model.Passeio;
import br.com.listadecasamento.model.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author felipery03
 */
public class PedidoDAO implements GenericDAO{
    
    private DataSource dataSource;
    
    public PedidoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public int create(Object o){  
        // Adiciona na table tblPedido
        int result = 0;
        if (o instanceof Pedido){
            Pedido pedido = (Pedido)o;
                Carrinho carrinho = pedido.getCarrinho();
            try
                {
                if (o instanceof Pedido){

                    String SQL = "INSERT INTO tblPedido (id, data, status, valortotal, idconvidado) VALUES(null,current_timestamp(), 0, ?, ?)";
                    PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                    stm.setString(1, String.valueOf(carrinho.getTotal()));
                    stm.setString(2, String.valueOf(pedido.getIdConvidado()));
                int res = stm.executeUpdate();
                if(res != 0){
                    ResultSet rs = stm.getGeneratedKeys();
                    if(rs.next()){
                        result = rs.getInt(1);
                    }
                    rs.close();
                }
                stm.close();
                }

            }
            catch(SQLException ex){
                System.out.println("Erro ao inserir usuário" + ex.getMessage());
            }
            // Adiciona na tabela tblPedidoHasPasseio
             try
                {   String SQL = "INSERT INTO tblPedidoHasPasseio (idpedido, idpasseio, qtd, valortotal) VALUES(?, ?, ?, ?)";
                      for (ItemCarrinho item : carrinho.getItens()) {
                        PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                        Passeio passeio = item.getPasseio();
                        int qtd = item.getQtde();
                        float preco = passeio.getPreco();
                        
                        stm.setString(1, String.valueOf(result));
                        stm.setString(2, String.valueOf(passeio.getId()));
                        stm.setString(3, String.valueOf(qtd));
                        stm.setString(4, String.valueOf(qtd * preco));
                        int res = stm.executeUpdate();
                        stm.close();
                }   
            }
            catch(SQLException ex){
                System.out.println("Erro ao inserir usuário" + ex.getMessage());
            }
        }
        else{
                    throw new RuntimeException("Invalid User Model Object"); 
                }
         return result;
    }
    @Override
       public List<Object> read(){
    
        return null;
    }
    public List<Object> read(Object o){
       
        return null;
       
    }
    @Override
    public void update(Object o){
        try
            {if (o instanceof Pedido){
                Pedido pedido = (Pedido)o;
                String SQL = "UPDATE tblPedido SET mensagem=?, status=? WHERE id = ?;";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, pedido.getMensagem());
                stm.setString(2, String.valueOf(pedido.getStatus()));       
                stm.setString(3, String.valueOf(pedido.getId()));
            stm.executeUpdate();
            stm.close();
            }
            else{
                throw new RuntimeException("Invalid User Model Object"); 
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao atualizar pedido - " + ex.getMessage());
        }
    
    }
    @Override
    public void delete(Object o){

    }

}

