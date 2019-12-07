/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.controller;

import br.com.listadecasamento.dao.ConvidadoDAO;
import br.com.listadecasamento.dao.DataSource;
import br.com.listadecasamento.model.Convidado;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdicionaConvidadoServlet extends HttpServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String page = "/admin.jsp";
        try{
            String name = request.getParameter("txtName");
            Convidado convidado = new Convidado();
            convidado.setName(name);
            
            DataSource ds = new DataSource();
            ConvidadoDAO convidadoDAO = new ConvidadoDAO(ds);
            convidadoDAO.create(convidado);
            List<Convidado> res2 = (List<Convidado>)(List<?>)convidadoDAO.read();
                          
            request.setAttribute("ListaConvidados", res2);
            ds.getConnection().close();
        }
        catch(Exception ex){
            System.out.println("Erro para criar novo usuário " + ex);
            page = "/error.jsp";
        }
    
                    
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
      
    }
   

}
