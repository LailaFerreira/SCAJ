package controller;

import dao.PessoaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

public class ManterPessoaController extends HttpServlet {

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
            request.setAttribute("pessoas", pessoaDAO.obterPessoas(""));
            RequestDispatcher view = request.getRequestDispatcher("/manterPessoa.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));
            Pessoa pessoa = pessoaDAO.obterPessoa(idPessoa);
            request.setAttribute("pessoa", pessoa);
            RequestDispatcher view = request.getRequestDispatcher("/manterPessoa.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));
            Pessoa pessoa = pessoaDAO.obterPessoa(idPessoa);
            request.setAttribute("pessoa", pessoa);
            RequestDispatcher view = request.getRequestDispatcher("/manterPessoa.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        int idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String rg = request.getParameter("txtRg");
        String telefoneResidencial = request.getParameter("txtTelefoneResidencial");
        String email = request.getParameter("txtEmail");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumeroResidencial");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUf");
        String cep = request.getParameter("txtCep");

        try {
            pessoaDAO.gravar(new Pessoa(idPessoa, nome, cpf, rg, telefoneResidencial, email, dataNascimento, logradouro, numero, complemento, bairro, cidade, uf, cep));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarPessoaController");
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

        int idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));
        String nome = request.getParameter("txtNome");
        String cpf = request.getParameter("txtCpf");
        String rg = request.getParameter("txtRg");
        String telefoneResidencial = request.getParameter("txtTelefoneResidencial");
        String email = request.getParameter("txtEmail");
        String dataNascimento = request.getParameter("txtDataNascimento");
        String logradouro = request.getParameter("txtLogradouro");
        String numero = request.getParameter("txtNumeroResidencial");
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUf");
        String cep = request.getParameter("txtCep");

        try {
            Pessoa pessoa = pessoaDAO.obterPessoa(idPessoa);
            pessoa.setBairro(bairro);
            pessoa.setCep(cep);
            pessoa.setCidade(cidade);
            pessoa.setComplemento(complemento);
            pessoa.setCpf(cpf);
            pessoa.setDataNascimento(dataNascimento);
            pessoa.setEmail(email);
            pessoa.setLogradouro(logradouro);
            pessoa.setNome(nome);
            pessoa.setNumero(numero);
            pessoa.setRg(rg);
            pessoa.setTelefoneResidencial(telefoneResidencial);
            pessoa.setUf(uf);
            pessoaDAO.gravar(pessoa);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarPessoaController");
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

        int idPessoa = Integer.parseInt(request.getParameter("txtIdPessoa"));

        try {
            pessoaDAO.excluir(pessoaDAO.obterPessoa(idPessoa));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarPessoaController");
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
