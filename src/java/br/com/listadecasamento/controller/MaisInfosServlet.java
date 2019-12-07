/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.controller;

import br.com.listadecasamento.dao.DataSource;
import br.com.listadecasamento.dao.PedidoDAO;
import br.com.listadecasamento.model.Carrinho;
import br.com.listadecasamento.model.Convidado;
import br.com.listadecasamento.model.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felipery03
 */
public class MaisInfosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("Carrinho");
        Convidado convidado = (Convidado)request.getSession().getAttribute("User");
        Pedido pedido = new Pedido();
        pedido.setCarrinho(carrinho);
        pedido.setIdConvidado(convidado.getId());
        String page = "/maisInfos.jsp";
        
         try{
             
            DataSource ds = new DataSource();
            PedidoDAO convidadoDAO = new PedidoDAO(ds);
            int idPedido = convidadoDAO.create(pedido);
            pedido.setId(idPedido);
                          
            request.getSession().setAttribute("Pedido", pedido);
            ds.getConnection().close();
        }
        catch(Exception ex){
            System.out.println("Erro para criar novo pedido " + ex);
            page = "/error.jsp";
        }
    
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
        
    }
}
