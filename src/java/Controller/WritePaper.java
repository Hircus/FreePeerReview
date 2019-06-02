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
        List<String> categorie = CategorieFactory.getInstance().getCategorie();
        String head = null, titolo, foto, data, testo;
        Articolo articolo = null;

        if (utente.getTipo() == false) {
            request.getRequestDispatcher("M1/error.jsp").forward(request, response);
        }
        if (session.getAttribute("utenteId") == null) {
            request.getRequestDispatcher("login.html").forward(request, response);
        } else {
            if (request.getParameter("pid") != null) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                if (pid != 0) {
                    articolo = ArticoliFactory.getInstance().getArticoloId(pid);
                    head = "MODIFICA ARTICOLO";
                    if (request.getParameter("salva") != null) {
                        titolo = request.getParameter("titolo");
                        foto = request.getParameter("immagine");
                        data = request.getParameter("data");
                        testo = request.getParameter("testo");
                        String[] cat = request.getParameterValues("cat");
                        String autore = request.getParameter("autori");
                        if (AutoriFactory.getInstance().searchUtente(autore)) {
                            if (titolo != null && autore != null && foto != null
                                    && data != null && testo != null) {
                                for (int i = 0; i < cat.length; i++) {
                                    if (!articolo.getCategorie().contains(cat[i])) {
                                        articolo.addCategoria(cat[i]);
                                    }
                                }
                                articolo.setTitolo(titolo);
                                articolo.setImmagine(foto);
                                articolo.setDataByString(data);
                                articolo.setTesto(testo);
                            }
                        }
                        ArticoliFactory.getInstance().updateArticolo(articolo);
                    }
                } else {
                    articolo = new Articolo();
                    head = "SCRIVI ARTICOLO";
                    if (request.getParameter("salva") != null) {
                        titolo = request.getParameter("titolo");
                        foto = request.getParameter("immagine");
                        data = request.getParameter("data");
                        testo = request.getParameter("testo");
                        String[] cat = request.getParameterValues("cat");
                        String autore = request.getParameter("autori");
                        if (AutoriFactory.getInstance().searchUtente(autore)) {
                            if (titolo != null && autore != null && foto != null
                                    && data != null && testo != null) {
                                for (int i = 0; i < cat.length; i++) {
                                    articolo.addCategoria(cat[i]);
                                }
                                articolo.setTitolo(titolo);
                                articolo.setImmagine(foto);
                                articolo.setDataByString(data);
                                articolo.setTesto(testo);
                            }
                        }
                    }
                    ArticoliFactory.getInstance().insertArticolo(articolo, utente);
                }
            } else {
                articolo = new Articolo();
                head = "SCRIVI ARTICOLO";
                if (request.getParameter("salva") != null) {
                    titolo = request.getParameter("titolo");
                    foto = request.getParameter("immagine");
                    data = request.getParameter("data");
                    testo = request.getParameter("testo");
                    String[] cat = request.getParameterValues("cat");
                    String autore = request.getParameter("autori");
                    if (AutoriFactory.getInstance().searchUtente(autore)) {
                        if (titolo != null && autore != null && foto != null
                                && data != null && testo != null) {
                            for (int i = 0; i < cat.length; i++) {
                                articolo.addCategoria(cat[i]);
                            }
                            articolo.setTitolo(titolo);
                            articolo.setImmagine(foto);
                            articolo.setDataByString(data);
                            articolo.setTesto(testo);
                        }
                    }
                }
                ArticoliFactory.getInstance().insertArticolo(articolo, utente);
            }
        }
        request.setAttribute("articolo", articolo);
        request.setAttribute("categorie", categorie);
        request.setAttribute("head", head);

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
