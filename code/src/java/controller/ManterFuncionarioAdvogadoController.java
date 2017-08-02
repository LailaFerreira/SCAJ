package controller;

import dao.CargoDAO;
import dao.FuncionarioAdvogadoDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FuncionarioAdvogado;
import model.Cargo;
import model.Pessoa;

public class ManterFuncionarioAdvogadoController extends HttpServlet {

    private CargoDAO cargoDAO = new CargoDAO();
    private FuncionarioAdvogadoDAO funcionarioDAO = new FuncionarioAdvogadoDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();

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
            request.setAttribute("advogados", funcionarioDAO.obterAdvogados());
            request.setAttribute("cargos", cargoDAO.obterCargos());
            request.setAttribute("pessoas", pessoaDAO.obterPessoas(""));
            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionarioAdvogado.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int idFuncionarioAdvogado = Integer.parseInt(request.getParameter("txtIdFuncionarioAdvogado"));
            FuncionarioAdvogado funcionarioAdvogado = funcionarioDAO.obterAdvogado(idFuncionarioAdvogado);
            request.setAttribute("funcionarioAdvogado", funcionarioAdvogado);
            request.setAttribute("cargos", cargoDAO.obterCargos());
            request.setAttribute("pessoas", pessoaDAO.obterPessoas("PessoaAdvogado"));

            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionarioAdvogado.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int idFuncionarioAdvogado = Integer.parseInt(request.getParameter("txtIdFuncionarioAdvogado"));
            FuncionarioAdvogado funcionarioAdvogado = funcionarioDAO.obterAdvogado(idFuncionarioAdvogado);
            request.setAttribute("funcionarioAdvogado", funcionarioAdvogado);
            request.setAttribute("cargos", cargoDAO.obterCargos());
            request.setAttribute("pessoas", pessoaDAO.obterPessoas("PessoaAdvogado"));

            RequestDispatcher view = request.getRequestDispatcher("/manterFuncionarioAdvogado.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int idFuncionarioAdvogado = Integer.parseInt(request.getParameter("txtIdFuncionarioAdvogado"));
        String carteiraOAB = request.getParameter("txtCarteiraOAB");
        Cargo cargo = new Cargo(Integer.parseInt(request.getParameter("txtIdCargo")), null);
        Pessoa pessoa = new Pessoa(Integer.parseInt(request.getParameter("txtIdPessoa")), null, null, null, null, null, null, null, null, null, null, null, null, null);

        try {
            funcionarioDAO.gravar(new FuncionarioAdvogado(idFuncionarioAdvogado, carteiraOAB, cargo, pessoa));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarFuncionarioAdvogadoController");
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
        int idFuncionarioAdvogado = Integer.parseInt(request.getParameter("txtIdFuncionarioAdvogado"));
        String carteiraOAB = request.getParameter("txtCarteiraOAB");
        Cargo cargo = new Cargo(Integer.parseInt(request.getParameter("txtIdCargo")), null);
        Pessoa pessoa = new Pessoa(Integer.parseInt(request.getParameter("txtIdPessoa")), null, null, null, null, null, null, null, null, null, null, null, null, null);

        try {
            FuncionarioAdvogado funcionario = funcionarioDAO.obterAdvogado(idFuncionarioAdvogado);
            funcionario.setCarteiraOAB(carteiraOAB);
            funcionario.setIdCargo(cargo);
            funcionario.setIdPessoa(pessoa);
            funcionarioDAO.gravar(funcionario);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarFuncionarioAdvogadoController");
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
        int idFuncionarioAdvogado = Integer.parseInt(request.getParameter("txtIdFuncionarioAdvogado"));
        String carteiraOAB = request.getParameter("txtCarteiraOAB");
        Cargo cargo = new Cargo(Integer.parseInt(request.getParameter("txtIdCargo")), null);
        Pessoa pessoa = new Pessoa(Integer.parseInt(request.getParameter("txtIdPessoa")), null, null, null, null, null, null, null, null, null, null, null, null, null);

        try {
            funcionarioDAO.excluir(funcionarioDAO.obterAdvogado(idFuncionarioAdvogado));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarFuncionarioAdvogadoController");
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
    }// </editor-fold>
}
