/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.controller;

import br.com.listadecasamento.model.Carrinho;
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
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Carrinho carrinho = (Carrinho)request.getSession().getAttribute("Carrinho");
        if (carrinho == null){
            carrinho = new Carrinho();
        }
        request.getSession().setAttribute("Carrinho",carrinho);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        dispatcher.forward(request, response);
    
    }

}
