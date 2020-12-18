/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.dao.impl.HistoryDaoImpl;
import database.model.DBHistory;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ShowAllHistoryServlet", urlPatterns = {"/ShowAllHistory.do"})
public class ShowAllHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            HistoryDaoImpl dbhs = new HistoryDaoImpl();

            out.println("<ol>");
            for (DBHistory record : dbhs.getAll()) {

                out.println("<li>Nombre: " + record.getUserName() + "</li>");
                out.println("<li>Rut: " + record.getUserRut() + "</li>");
                out.println("<li>Fecha Registro: " + record.getRegisterDate() + "</li>");
                out.println("<a>--------------------------------------------------</a>");
                out.println("</ol>");

            }

            response.sendRedirect("allHistoryRec.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(ShowAllHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShowAllHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
