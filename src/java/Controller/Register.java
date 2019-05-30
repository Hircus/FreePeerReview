/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
//@WebServlet(name = "Register", urlPatterns = {"/registrazione.html"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Object id= session.getAttribute("utenteId");
        String titolo;
        String button1;
        String button2;
        Utente utente;
        
        if (id == null) {
            utente= new Utente();
            
            titolo="REGISTRAZIONE";
            button1="REGISTRATI";
            button2="ESCI";
            
            session.setAttribute("button2", button2);
        }else{
            utente = (Utente) session.getAttribute("utente");
            titolo="PROFILO";
            button1="SALVA";
        }
        
        session.setAttribute("titolo", titolo);
        session.setAttribute("button1", button1);
        session.setAttribute("utente", utente);
        request.getRequestDispatcher("M1/profilo.jsp").forward(request, response);
        
        if (request.getParameter("check") != null) {

            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String email = request.getParameter("email");
            String foto = request.getParameter("foto");
            String password = request.getParameter("password");
            String ente = request.getParameter("ente");

            Utente nuovoUtente = new Utente();
            nuovoUtente.setNome(nome);
            nuovoUtente.setCognome(cognome);
            nuovoUtente.setEmail(email);
            nuovoUtente.setImmagine(foto);
            nuovoUtente.setPassword(password);
            nuovoUtente.setEnte(ente);

            if (AutoriFactory.getInstance().insertUtente(nuovoUtente)) {
                request.getRequestDispatcher("M1/login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("M1/error.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
