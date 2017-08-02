package controller;

import dao.NaturezaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Natureza;

public class ManterNaturezaController extends HttpServlet {

    private NaturezaDAO naturezaDAO = new NaturezaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("naturezas", naturezaDAO.obterNaturezas());
            RequestDispatcher view = request.getRequestDispatcher("/manterNatureza.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int idNatureza = Integer.parseInt(request.getParameter("txtIdNatureza"));
            Natureza natureza = naturezaDAO.obterNatureza(idNatureza);
            request.setAttribute("natureza", natureza);
            RequestDispatcher view = request.getRequestDispatcher("/manterNatureza.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int idNatureza = Integer.parseInt(request.getParameter("txtIdNatureza"));
            Natureza natureza = naturezaDAO.obterNatureza(idNatureza);
            request.setAttribute("natureza", natureza);
            RequestDispatcher view = request.getRequestDispatcher("/manterNatureza.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        int idNatureza = Integer.parseInt(request.getParameter("txtIdNatureza"));
        String nome = request.getParameter("txtNomeNatureza");
        try {
            naturezaDAO.gravar(new Natureza(idNatureza, nome));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarNaturezaController");
            view.forward(request, response);

        } catch (ClassNotFoundException ex) {
            throw ex;

        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        int idNatureza = Integer.parseInt(request.getParameter("txtIdNatureza"));
        String nome = request.getParameter("txtNomeNatureza");

        try {
            Natureza natureza = naturezaDAO.obterNatureza(idNatureza);
            natureza.setNome(nome);
            naturezaDAO.gravar(natureza);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarNaturezaController");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            throw ex;

        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw ex;

        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        int idNatureza = Integer.parseInt(request.getParameter("txtIdNatureza"));
        String nome = request.getParameter("txtNomeNatureza");

        try {
            naturezaDAO.excluir(naturezaDAO.obterNatureza(idNatureza));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarNaturezaController");
            view.forward(request, response);

        } catch (ClassNotFoundException ex) {
            throw ex;

        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw ex;
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }

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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {

        } catch (SQLException ex) {

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>}
}
