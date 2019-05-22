/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author antonio
 */
//@WebServlet(name = "Articoli", urlPatterns = {"/articoli.html"})
public class MyPapers extends HttpServlet {

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

        if (session.getAttribute("utenteId") != null) {
            int utenteId = (int) session.getAttribute("utenteId");

            Utente utente = (Utente) session.getAttribute("utente");
            //passo alla jsp una variabile di nome autore, con un id riferito all'oggetto

            List<Articolo> articoli = (List<Articolo>) session.getAttribute("articoli");
            List<Articolo> tuttiArticoli = ArticoliFactory.getInstance().getArticoli();

            int maxArt = tuttiArticoli.size() - 1;
            int maxArtUtente = articoli.size() - 1;

            session.setAttribute("maxArt", maxArt);
            session.setAttribute("maxArtUtente", maxArtUtente);
            session.setAttribute("articoli", articoli);
            session.setAttribute("all", tuttiArticoli);
            //carica una jsp
            if (utente.getTipo().equals("Autore")) {
                request.getRequestDispatcher("M1/articoli.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("M1/gestioneArticoli.jsp").forward(request, response);
            }
        } else { //sennò l'utente non è autenticato
            request.getRequestDispatcher("M1/login.jsp").forward(request, response);

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