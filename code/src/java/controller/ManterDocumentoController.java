package controller;

import dao.ClienteDAO;
import dao.DocumentoDAO;
import dao.ProcessoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Documento;
import model.Processo;

public class ManterDocumentoController extends HttpServlet {

    private DocumentoDAO documentoDAO = new DocumentoDAO();
    private ProcessoDAO processoDAO = new ProcessoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();

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
            request.setAttribute("documentos", documentoDAO.obterDocumentos());
            request.setAttribute("processos", processoDAO.obterProcessos());
            request.setAttribute("clientes", clienteDAO.obterClientes());

            RequestDispatcher view = request.getRequestDispatcher("/manterDocumento.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int idDocumento = Integer.parseInt(request.getParameter("txtIdDocumento"));
            Documento documento = documentoDAO.obterDocumento(idDocumento);
            request.setAttribute("documento", documento);
            request.setAttribute("processos", processoDAO.obterProcessos());
            request.setAttribute("clientes", clienteDAO.obterClientes());

            RequestDispatcher view = request.getRequestDispatcher("/manterDocumento.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int idDocumento = Integer.parseInt(request.getParameter("txtIdDocumento"));
            Documento documento = documentoDAO.obterDocumento(idDocumento);
            request.setAttribute("documento", documento);
            request.setAttribute("processos", processoDAO.obterProcessos());
            request.setAttribute("clientes", clienteDAO.obterClientes());

            RequestDispatcher view = request.getRequestDispatcher("/manterDocumento.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {

        int idDocumento = Integer.parseInt(request.getParameter("txtIdDocumento"));
        String nomeDocumento = request.getParameter("txtNomeDocumento");
        String dataEntrega = request.getParameter("txtDataEntrega");
        String pendencia = request.getParameter("txtPendencia");
        Processo processo = new Processo(Integer.parseInt(request.getParameter("txtIdProcesso")), null, null, null, null, null, null, null, null, null);
        Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("txtIdCliente")), null, null, null, null, null);

        try {
            documentoDAO.gravar(new Documento(idDocumento, nomeDocumento, dataEntrega, pendencia, processo, cliente));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarDocumentoController");
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

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {

        int idDocumento = Integer.parseInt(request.getParameter("txtIdDocumento"));
        String nomeDocumento = request.getParameter("txtNomeDocumento");
        String dataEntrega = request.getParameter("txtDataEntrega");
        String pendencia = request.getParameter("txtPendencia");
        Processo processo = new Processo(Integer.parseInt(request.getParameter("txtIdProcesso")), null, null, null, null, null, null, null, null, null);
        Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("txtIdCliente")), null, null, null, null, null);

        try {
            Documento documento = documentoDAO.obterDocumento(idDocumento);
            documento.setNome(nomeDocumento);
            documento.setDataEntrada(dataEntrega);
            documento.setPendencia(pendencia);
            documento.setIdProcesso(processo);
            documento.setIdCliente(cliente);
            documentoDAO.gravar(documento);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarDocumentoController");
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

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {

        int idDocumento = Integer.parseInt(request.getParameter("txtIdDocumento"));
        String nomeDocumento = request.getParameter("txtNomeDocumento");
        String dataEntrega = request.getParameter("txtDataEntrega");
        String pendencia = request.getParameter("txtPendencia");
        Processo processo = new Processo(Integer.parseInt(request.getParameter("txtIdProcesso")), null, null, null, null, null, null, null, null, null);
        Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("txtIdCliente")), null, null, null, null, null);

        try {
            documentoDAO.excluir(documentoDAO.obterDocumento(idDocumento));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarDocumentoController");
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
