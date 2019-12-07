/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.controller;

import br.com.listadecasamento.dao.ConvidadoDAO;
import br.com.listadecasamento.dao.DataSource;
import br.com.listadecasamento.dao.PedidoDAO;
import br.com.listadecasamento.model.Convidado;
import br.com.listadecasamento.model.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felipery03
 */
public class AtualizaInfoServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = "/finalizarPedido.jsp";
        
        //Atualiza o e-mail
        try{
            String email= request.getParameter("txtemail");
            Convidado convidado = (Convidado)request.getSession().getAttribute("User");
            convidado.setEmail(email);           
            
            DataSource ds = new DataSource();
            ConvidadoDAO convidadoDAO = new ConvidadoDAO(ds);
            convidadoDAO.update(convidado);

            ds.getConnection().close();
        }
        catch(SQLException ex){
            System.out.println("Erro para atualizar as Informações " + ex);
            page = "/error.jsp";
        }
          //Atualiza a mensagem
        try{
            String msg= request.getParameter("txtmsg");
            Pedido pedido = (Pedido)request.getSession().getAttribute("Pedido");
            pedido.setMensagem(msg);           
            
            DataSource ds = new DataSource();
            PedidoDAO pedidoDAO = new PedidoDAO(ds);
            pedidoDAO.update(pedido);
            ds.getConnection().close();
        }
        catch(Exception ex){
            System.out.println("Erro para atualizar as Informações " + ex);
            page = "/error.jsp";
        }
        
        
                    
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }


}
