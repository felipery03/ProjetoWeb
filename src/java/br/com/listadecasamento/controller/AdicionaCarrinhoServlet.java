/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.controller;

import br.com.listadecasamento.dao.DataSource;
import br.com.listadecasamento.dao.PasseioDAO;
import br.com.listadecasamento.model.Carrinho;
import br.com.listadecasamento.model.Passeio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felipery03
 */
public class AdicionaCarrinhoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Carrinho carrinho;
        Passeio passeio = null;
        carrinho = (Carrinho)request.getSession().getAttribute("Carrinho");
        if (carrinho == null){
            carrinho = new Carrinho();
        }
      //  Produto produto = (Produto)request.getSession().getAttribute("DetalheProduto");
       // float qtde = Float.parseFloat(request.getParameter("txtQtde"));
        
        
        
        
        try{
            DataSource ds = new DataSource();
            PasseioDAO dao = new PasseioDAO(ds);
            List<Object> lista = dao.read(Integer.parseInt(request.getParameter("id")));
            ds.getConnection().close();
            if (!lista.isEmpty()){
                 passeio = (Passeio)lista.get(0);
         
               
            }
            
        }
        catch(Exception ex){
            System.out.println("Erro :" + ex);
        }
        
//        Passeio produto = (Produto)request.getSession().getAttribute("DetalheProduto");
//        float qtde = Float.parseFloat(request.getParameter("txtQtde"));
        //carrinho.add(produto,qtde);
        request.getSession().setAttribute("Carrinho", carrinho);
        System.out.println("teste " + passeio.getTitulo());
         
         carrinho.add(passeio); 
         //request.getSession().setAttribute("DetalhesPasseio",passeio);
        request.getSession().setAttribute("Carrinho", carrinho);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        dispatcher.forward(request, response);
    }/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Carrinho carrinho;
        carrinho = (Carrinho)request.getSession().getAttribute("Carrinho");
        if (carrinho == null){
            carrinho = new Carrinho();
        }
        Passeio produto = (Passeio)request.getSession().getAttribute("DetalheProduto");
        //float qtde = Float.parseFloat(request.getParameter("txtQtde"));
        carrinho.add(produto);
        request.getSession().setAttribute("Carrinho", carrinho);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        dispatcher.forward(request,response);     
    }*/
}
