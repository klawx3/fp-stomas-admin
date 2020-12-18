/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.dao.impl.UserLoginDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginCheckServlet", urlPatterns = {"/loginCheck.do"})
public class loginCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name, pass;
        name = request.getParameter("nombre");
        pass = request.getParameter("clave");
       
        
        try {
            UserLoginDaoImpl uldi = new UserLoginDaoImpl();
            if (uldi.isValid(name, pass)) {
                response.sendRedirect("menuPrincipal.jsp");
            } else {
                response.sendError(1,"Clave o Usuario incorrecto");
                               
                
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(loginCheckServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
