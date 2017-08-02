package controller;

import dao.ComarcaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comarca;

public class ManterComarcaController extends HttpServlet {

    private ComarcaDAO comarcaDAO = new ComarcaDAO();

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
            request.setAttribute("comarcas", comarcaDAO.obterComarcas());
            RequestDispatcher view = request.getRequestDispatcher("/manterComarca.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int idComarca = Integer.parseInt(request.getParameter("txtIdComarca"));
            Comarca comarca = comarcaDAO.obterComarca(idComarca);
            request.setAttribute("comarca", comarca);
            RequestDispatcher view = request.getRequestDispatcher("/manterComarca.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int idComarca = Integer.parseInt(request.getParameter("txtIdComarca"));
            Comarca comarca = ComarcaDAO.obterInstancia().obterComarca(idComarca);
            //            Cargo cargo = CargoDAO.obterInstancia().obterCargo(idCargo);

            request.setAttribute("comarca", comarca);
            RequestDispatcher view = request.getRequestDispatcher("/manterComarca.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        int idComarca = Integer.parseInt(request.getParameter("txtIdComarca"));
        String nome = request.getParameter("txtNomeComarca");
        String uf = request.getParameter("txtUf");
        try {
            comarcaDAO.gravar(new Comarca(idComarca, nome, uf));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarComarcaController");
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

        int idComarca = Integer.parseInt(request.getParameter("txtIdComarca"));
        String nome = request.getParameter("txtNomeComarca");
        String uf = request.getParameter("txtUf");

        try {
            Comarca comarca = new Comarca(idComarca, nome, uf);
            comarcaDAO.gravar(comarca);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarComarcaController");
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

        try {
            int idComarca = Integer.parseInt(request.getParameter("txtIdComarca"));
            String nome = request.getParameter("txtNomeComarca");
            String uf = request.getParameter("txtUf");

            Comarca comarca = ComarcaDAO.obterInstancia().obterComarca(idComarca);
            //(idComarca, nome, uf);
            //            Cargo cargo = CargoDAO.obterInstancia().obterCargo(idCargo);

            ComarcaDAO.obterInstancia().excluir(comarca);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarComarcaController");
            view.forward(request, response);

        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
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
    }// </editor-fold>

}
