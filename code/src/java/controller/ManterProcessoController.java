package controller;

import dao.ClienteDAO;
import dao.ComarcaDAO;
import dao.FuncionarioAdvogadoDAO;
import dao.InstanciaDAO;
import dao.NaturezaDAO;
import dao.ProcessoDAO;
import dao.VaraDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Comarca;
import model.FuncionarioAdvogado;
import model.Processo;
import model.Instancia;
import model.Natureza;
import model.Vara;

public class ManterProcessoController extends HttpServlet {
    private FuncionarioAdvogadoDAO funcionarioDAO = new FuncionarioAdvogadoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private VaraDAO varaDAO = new VaraDAO();
    private ComarcaDAO comarcaDAO = new ComarcaDAO();
    private InstanciaDAO instanciaDAO = new InstanciaDAO();
    private NaturezaDAO naturezaDAO = new NaturezaDAO();
    private ProcessoDAO processoDAO = new ProcessoDAO();
           
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
            request.setAttribute("clientes", clienteDAO.obterClientes());
            request.setAttribute("comarcas", comarcaDAO.obterComarcas());
            request.setAttribute("instancias", instanciaDAO.obterInstancias());
            request.setAttribute("naturezas", naturezaDAO.obterNaturezas());
            request.setAttribute("varas", varaDAO.obterVaras());
            RequestDispatcher view = request.getRequestDispatcher("/manterProcesso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int idProcesso = Integer.parseInt(request.getParameter("txtIdProcesso"));
            Processo processo = processoDAO.obterProcesso(idProcesso);
            request.setAttribute("processo", processo);
            request.setAttribute("advogados", funcionarioDAO.obterAdvogados());
            request.setAttribute("clientes", clienteDAO.obterClientes());
            request.setAttribute("comarcas", comarcaDAO.obterComarcas());
            request.setAttribute("instancias", instanciaDAO.obterInstancias());
            request.setAttribute("naturezas", naturezaDAO.obterNaturezas());
            request.setAttribute("varas", varaDAO.obterVaras());
            RequestDispatcher view = request.getRequestDispatcher("/manterProcesso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int idProcesso = Integer.parseInt(request.getParameter("txtIdProcesso"));
            Processo processo = processoDAO.obterProcesso(idProcesso);
            request.setAttribute("processo", processo);
            request.setAttribute("advogados", funcionarioDAO.obterAdvogados());
            request.setAttribute("clientes", clienteDAO.obterClientes());
            request.setAttribute("comarcas", comarcaDAO.obterComarcas());
            request.setAttribute("instancias", instanciaDAO.obterInstancias());
            request.setAttribute("naturezas", naturezaDAO.obterNaturezas());
            request.setAttribute("varas", varaDAO.obterVaras());
            RequestDispatcher view = request.getRequestDispatcher("/manterProcesso.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        int idProcesso = Integer.parseInt(request.getParameter("txtIdProcesso"));
        String numeroProcesso = request.getParameter("txtNumeroProcesso");
        String dataEntrada = request.getParameter("txtDataEntrada");
        String situacao = request.getParameter("txtSituacao");

        Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("txtIdCliente")), null, null, null, null, null);
        FuncionarioAdvogado advogado = new FuncionarioAdvogado(Integer.parseInt(request.getParameter("txtIdAdvogado")), null, null, null);

        Comarca comarca = new Comarca(Integer.parseInt(request.getParameter("txtIdComarca")), null, null);
        Instancia instancia = new Instancia(Integer.parseInt(request.getParameter("txtIdInstancia")), null);
        Natureza natureza = new Natureza(Integer.parseInt(request.getParameter("txtIdNatureza")), null);
        Vara vara = new Vara(Integer.parseInt(request.getParameter("txtIdVara")), null);

        try {
            processoDAO.gravar(new Processo(idProcesso, numeroProcesso, dataEntrada, situacao, cliente, comarca, advogado, instancia, natureza, vara));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarProcessoController");
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

        int idProcesso = Integer.parseInt(request.getParameter("txtIdProcesso"));
        String numeroProcesso = request.getParameter("txtNumeroProcesso");
        String dataEntrada = request.getParameter("txtDataEntrada");
        String situacao = request.getParameter("txtSituacao");

        Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("txtIdCliente")), null, null, null, null, null);
        FuncionarioAdvogado advogado = new FuncionarioAdvogado(Integer.parseInt(request.getParameter("txtIdAdvogado")), null, null, null);

        Comarca comarca = new Comarca(Integer.parseInt(request.getParameter("txtIdComarca")), null, null);
        Instancia instancia = new Instancia(Integer.parseInt(request.getParameter("txtIdInstancia")), null);
        Natureza natureza = new Natureza(Integer.parseInt(request.getParameter("txtIdNatureza")), null);
        Vara vara = new Vara(Integer.parseInt(request.getParameter("txtIdVara")), null);

        try {
            Processo processo = new Processo(idProcesso, numeroProcesso, dataEntrada, situacao, cliente, comarca, advogado, instancia, natureza, vara);
            processo.setDataEntrada(dataEntrada);
            processo.setIdCliente(cliente);
            processo.setIdComarca(comarca);
            processo.setIdFuncionarioAdvogado(advogado);
            processo.setIdInstancia(instancia);
            processo.setIdNatureza(natureza);
            processo.setIdVara(vara);
            processo.setSituacao(situacao);
            processoDAO.gravar(processo);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarProcessoController");
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

        int idProcesso = Integer.parseInt(request.getParameter("txtIdProcesso"));
        try {
            processoDAO.excluir(processoDAO.obterProcesso(idProcesso));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarProcessoController");
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
