/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.listadecasamento.controller;

import br.com.listadecasamento.dao.ConvidadoDAO;
import br.com.listadecasamento.dao.DataSource;
import br.com.listadecasamento.dao.PasseioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.listadecasamento.model.Convidado;
import br.com.listadecasamento.model.Passeio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipery03
 */
public class LoginServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String pName = request.getParameter("txtname");
            Convidado incompleto = new Convidado();
            incompleto.setName(pName);
            String page = "/error.jsp";
            DataSource ds;
            
            try{ 
                ds = new DataSource();
                ConvidadoDAO convidadoDAO = new ConvidadoDAO(ds);
                List<Object> res = convidadoDAO.read(incompleto);
                if(res != null && res.size() > 0){
                    Convidado convidado = (Convidado)res.get(0);
                    
                    if(convidado.getAdmin() == 1){
                        try{
                            ds = new DataSource();
                            ConvidadoDAO listaConvidadosDAO = new ConvidadoDAO(ds);
                            List<Convidado> res2 = (List<Convidado>)(List<?>)listaConvidadosDAO.read();
                            page = "/admin.jsp";
                            request.setAttribute("ListaConvidados", res2);
                            
                        }
                        catch(Exception ex){
                            request.setAttribute("erroSTR", "Erro ao recuperar lista de convidados");
                        }
                        
                       // 

                    }
                    else{
                        page = "/cotas.jsp";
                        request.getSession().setAttribute("User", res.get(0));
                         ds = new DataSource();
                        PasseioDAO listaPasseiosDAO = new PasseioDAO(ds);
                        List<Passeio> res3 = (List<Passeio>)(List<?>)listaPasseiosDAO.read();
                        request.setAttribute("ListaPasseios", res3);
                        
                    }
                }
                else{
                    request.setAttribute("erroSTR", "Nome Inválido! Digite o nome igual ao do convite!");
                }
                
            }
            catch(Exception ex){
                request.setAttribute("erroSTR", "Erro ao recuperar usuário para login");
            }
            
            RequestDispatcher dispatcher;
            dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
    }

}
