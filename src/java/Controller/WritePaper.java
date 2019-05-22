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

        if (request.getParameter("pid") == null) {
            request.getRequestDispatcher("M1/error.jsp").forward(request, response);
        } else {
            int pid = Integer.parseInt(request.getParameter("pid"));

            Utente utente = (Utente) session.getAttribute("utente");

            Articolo articolo = ArticoliFactory.getInstance().getArticoloId(pid);
            request.setAttribute("articolo", articolo);

            if (request.getParameter("salva") != null) {
                String titolo = request.getParameter("titolo");
                String immagine = request.getParameter("immagine");
                String data = request.getParameter("data");
                String testo = request.getParameter("testo");

                articolo.setTitolo(titolo);
                articolo.setImmagine(immagine);
                articolo.setTesto(testo); //bug che modifica la e accentata con altri caratteri (trovata soluzione temporanea)
                articolo.setDataByString(data);
            }
            request.setAttribute("articolo", articolo);

            request.getRequestDispatcher("M1/scriviArticolo.jsp").forward(request, response);
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
