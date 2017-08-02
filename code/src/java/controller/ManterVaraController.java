package controller;

import dao.VaraDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vara;

public class ManterVaraController extends HttpServlet {
    private VaraDAO varaDAO = new VaraDAO();
    
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
            request.setAttribute("varas", varaDAO.obterVaras());
            RequestDispatcher view = request.getRequestDispatcher("/manterVara.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            int IdVara = Integer.parseInt(request.getParameter("txtIdVara"));
            Vara vara = varaDAO.obterVara(IdVara);
            request.setAttribute("vara", vara);
            RequestDispatcher view = request.getRequestDispatcher("/manterVara.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            int IdVara = Integer.parseInt(request.getParameter("txtIdVara"));
            Vara vara = varaDAO.obterVara(IdVara);
            request.setAttribute("vara", vara);
            RequestDispatcher view = request.getRequestDispatcher("/manterVara.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        int idVara = Integer.parseInt(request.getParameter("txtIdVara"));
        String nome = request.getParameter("txtNomeVara");
        try {
            varaDAO.gravar(new Vara(idVara, nome));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarVaraController");
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

        int idVara = Integer.parseInt(request.getParameter("txtIdVara"));
        String nome = request.getParameter("txtNomeVara");

        try {
            Vara vara = new Vara(idVara, nome);
            vara.setNome(nome);
            varaDAO.gravar(vara);

            RequestDispatcher view = request.getRequestDispatcher("PesquisarVaraController");
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

        int idVara = Integer.parseInt(request.getParameter("txtIdVara"));
        String nome = request.getParameter("txtNomeVara");

        try {
            varaDAO.excluir(varaDAO.obterVara(idVara));

            RequestDispatcher view = request.getRequestDispatcher("PesquisarVaraController");
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
