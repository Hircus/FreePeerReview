/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

/**
 *
 * @author antonio
 */
//@WebServlet(name = "WritePaper", urlPatterns = {"/scriviArticolo.html"})
public class WritePaper extends HttpServlet {

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

        Utente utente = (Utente) session.getAttribute("utente");
        
        String head = null, action = null, title = null, nome = null, 
                cognome = null, categorie, immagine = null, data = null, testo = null;
        List<Utente> autori = null;
        if (utente.getTipo() == false) {
            request.getRequestDispatcher("M1/error.jsp").forward(request, response);
        }

        if (request.getParameter("scriviArticolo") != null) {
            Articolo articolo = null;
            List<Articolo> articoli = null;

            head = "SCRIVI ARTICOLO";
            action = "scriviArticolo.html";
        }
        if (request.getParameter("pid") != null) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            Articolo articolo = ArticoliFactory.getInstance().getArticoloId(pid);
            request.setAttribute("articolo", articolo);

            head = "MODIFICA ARTICOLO";
            action = "scriviArticolo.html?pid=${articoli.get(i).getId()";
            title = articolo.getTitolo();
            autori = articolo.getAutori();
            immagine = articolo.getImmagine();
            data = articolo.getData();
            testo = articolo.getTesto();

            if (request.getParameter("salva") != null) {
                String titoloArt = request.getParameter("titolo");
                String immagineArt = request.getParameter("immagine");
                String dataArt = request.getParameter("data");
                String testoArt = request.getParameter("testo");

                articolo.setTitolo(titoloArt);
                articolo.setImmagine(immagineArt);
                articolo.setTesto(testoArt); //bug che modifica la e accentata con altri caratteri (trovata soluzione temporanea)
                articolo.setDataByString(dataArt);
            }
            request.setAttribute("articolo", articolo);
        }
        
        request.setAttribute("head", head);
        request.setAttribute("action", action);
        request.setAttribute("title", title);
        request.setAttribute("nome", nome);
        request.setAttribute("cognome", cognome);
        request.setAttribute("immagine", immagine);
        request.setAttribute("data", data);
        request.setAttribute("testo", testo);
        request.setAttribute("autori", autori);

        request.getRequestDispatcher("M1/scriviArticolo.jsp").forward(request, response);

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
