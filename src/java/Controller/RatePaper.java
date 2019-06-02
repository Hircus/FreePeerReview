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
import javax.servlet.http.*;

/**
 *
 * @author tobias
 */
public class RatePaper extends HttpServlet {

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
            Utente utente = (Utente) session.getAttribute("utente");

            if (utente.getTipo() == false) {
                request.getRequestDispatcher("M1/error.jsp").forward(request, response);
            }
            Articolo valArticolo = null;
            List<Articolo> all = ArticoliFactory.getInstance().getArticoli();
            List<Articolo> articoli = ArticoliFactory.getInstance().getArticoliByAutore(utente);
            List<Articolo> valArticoli = new ArrayList<>();

            for (Articolo a : all) {
                boolean flag = true;
                for (Articolo b : articoli) {
                    if (a.getTitolo().equals(b.getTitolo())) {
                        flag = false;
                    }
                }
                if(flag) valArticoli.add(a);
            }

            request.setAttribute("valArticoli", valArticoli);
            request.setAttribute("articoli", articoli);

            if (request.getParameter("pid") != null) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                if (pid != 0) {
                    valArticolo = ArticoliFactory.getInstance().getArticoloId(pid);
                    request.setAttribute("valArticolo", valArticolo);
                }
            }
            request.getRequestDispatcher("M1/valutazione.jsp").forward(request, response);
        } else {
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
