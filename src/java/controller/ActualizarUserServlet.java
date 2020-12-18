/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.dao.impl.UserDaoImpl;
import database.model.DBUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */
@WebServlet(name = "ActualizarUserServlet", urlPatterns = {"/actualizarUser.do"})
public class ActualizarUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nombre, rut;
            int id;
            nombre = request.getParameter("nameUser");
            rut = request.getParameter("rut");
            id = Integer.parseInt(request.getParameter("idUser"));
            UserDaoImpl udi = new UserDaoImpl();
            DBUser d = new DBUser();
            d.setFullname(nombre);
            d.setRut(rut);
            d.setId(id);
            udi.update(d);
            response.sendRedirect("allHistoryRec.jsp");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActualizarUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
