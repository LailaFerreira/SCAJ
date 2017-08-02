package controller;

import dao.CargoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cargo;

public class ManterCargoController extends HttpServlet {

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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("operacao", "Incluir");

            RequestDispatcher view = request.getRequestDispatcher("/manterCargo.jsp");
            view.forward(request, response);
            
            
        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }

    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");

            int idCargo = Integer.parseInt(request.getParameter("txtIdCargo"));
            Cargo cargo = CargoDAO.obterInstancia().obterCargo(idCargo);

            request.setAttribute("cargo", cargo);
            RequestDispatcher view = request.getRequestDispatcher("/manterCargo.jsp");
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

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");

            int idCargo = Integer.parseInt(request.getParameter("txtIdCargo"));
            Cargo cargo = CargoDAO.obterInstancia().obterCargo(idCargo);

            request.setAttribute("cargo", cargo);
            RequestDispatcher view = request.getRequestDispatcher("/manterCargo.jsp");
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

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        try {
            int idCargo = Integer.parseInt(request.getParameter("txtIdCargo"));
            String nome = request.getParameter("txtNomeCargo");

            Cargo cargo = new Cargo(idCargo, nome);
            CargoDAO.obterInstancia().gravar(cargo);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarCargoController");
            view.forward(request, response);

        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idCargo = Integer.parseInt(request.getParameter("txtIdCargo"));
            String nome = request.getParameter("txtNomeCargo");

            Cargo cargo = new Cargo(idCargo, nome);

            //CargoDAO.obterInstancia().alterar(cargo);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarCargoController");
            view.forward(request, response);

        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }

    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        try {
            int idCargo = Integer.parseInt(request.getParameter("txtIdCargo"));
            String nome = request.getParameter("txtNomeCargo");

            Cargo cargo = CargoDAO.obterInstancia().obterCargo(idCargo);

            CargoDAO.obterInstancia().excluir(cargo);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarCargoController");
            view.forward(request, response);

        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }
        // 
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
    }// </editor-fold>

}
