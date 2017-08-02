package controller;

import dao.ClienteDAO;
import dao.FonteIndicacaoDAO;
import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.FonteIndicacao;
import model.Pessoa;

public class ManterClienteController extends HttpServlet {

    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final FonteIndicacaoDAO fonteIndicacaoDAO = new FonteIndicacaoDAO();
    private final PessoaDAO pessoaDAO = new PessoaDAO();

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
            request.setAttribute("pessoas", pessoaDAO.obterPessoas(""));
            request.setAttribute("indicacoes", fonteIndicacaoDAO.obterFonteIndicacoes());

            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
            Cliente cliente = clienteDAO.obterCliente(idCliente);
            request.setAttribute("cliente", cliente);
            request.setAttribute("pessoas", pessoaDAO.obterPessoas("PessoaCliente"));
            request.setAttribute("indicacoes", fonteIndicacaoDAO.obterFonteIndicacoes());

            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));

            Cliente cliente = clienteDAO.obterCliente(idCliente);

            request.setAttribute("cliente", cliente);
            request.setAttribute("pessoas", pessoaDAO.obterPessoas("PessoaCliente"));
            request.setAttribute("indicacoes", fonteIndicacaoDAO.obterFonteIndicacoes());

            RequestDispatcher view = request.getRequestDispatcher("/manterCliente.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
        String carteiraNit = request.getParameter("txtCarteiraNit");
        String profissao = request.getParameter("txtProfissao");
        String estadoCivil = request.getParameter("txtEstadoCivil");
        FonteIndicacao fonteIndicacao = new FonteIndicacao(Integer.parseInt(request.getParameter("txtIdFonteIndicacao")), null);
        Pessoa pessoa = pessoaDAO.obterPessoa(Integer.parseInt(request.getParameter("txtIdPessoa")));

        try {
            clienteDAO.gravar(new Cliente(idCliente, carteiraNit, profissao, estadoCivil, fonteIndicacao, pessoa));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarClienteController");
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

        int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
        String carteiraNit = request.getParameter("txtCarteiraNit");
        String profissao = request.getParameter("txtProfissao");
        String estadoCivil = request.getParameter("txtEstadoCivil");

        FonteIndicacao fonteIndicacao = fonteIndicacaoDAO.obterFonteIndicacao(Integer.parseInt(request.getParameter("txtIdFonteIndicacao")));

        Pessoa pessoa = pessoaDAO.obterPessoa(Integer.parseInt(request.getParameter("txtIdPessoa")));
        try {
            Cliente cliente = clienteDAO.obterCliente(idCliente);
            cliente.setCarteiraNit(carteiraNit);
            cliente.setProfissao(profissao);
            cliente.setEstadoCivil(estadoCivil);
            cliente.setIdFonteIndicacao(fonteIndicacao);
            cliente.setIdPessoa(pessoa);
            clienteDAO.gravar(cliente);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarClienteController");
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

        int idCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
        String carteiraNit = request.getParameter("txtCarteiraNit");
        String profissao = request.getParameter("txtProfissao");
        String estadoCivil = request.getParameter("txtEstadoCivil");

        FonteIndicacao fonteIndicacao = fonteIndicacaoDAO.obterFonteIndicacao(Integer.parseInt(request.getParameter("txtIdFonteIndicacao")));
        Pessoa pessoa = pessoaDAO.obterPessoa(Integer.parseInt(request.getParameter("txtIdPessoa")));

        try {
            Cliente cliente = new Cliente(idCliente, carteiraNit, profissao, estadoCivil, fonteIndicacao, pessoa);
            clienteDAO.excluir(clienteDAO.obterCliente(idCliente));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarClienteController");
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
