/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.controller;

import br.com.listadecasamento.dao.DataSource;
import br.com.listadecasamento.dao.PedidoDAO;
import br.com.listadecasamento.model.Carrinho;
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
public class FinalizaPedidoServelet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
     String page = "/pedidoConcluido.jsp";
     
     try{
            String msg= request.getParameter("txtmsg");
            Pedido pedido = (Pedido)request.getSession().getAttribute("Pedido");
            pedido.setStatus(1);           
            
            DataSource ds = new DataSource();
            PedidoDAO pedidoDAO = new PedidoDAO(ds);
            pedidoDAO.update(pedido);
   
            ds.getConnection().close();
        }
        catch(Exception ex){
            System.out.println("Erro para atualizar o Status Pedido " + ex);
            page = "/error.jsp";
        }
        
        
                    
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }



}
