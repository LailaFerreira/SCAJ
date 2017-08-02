package bean;
   
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.FuncionarioAdvogadoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.FuncionarioAdvogado;
   
  @ManagedBean(name = "funcionarioBean")
   
  @ViewScoped
  public class FuncionarioBean implements Serializable {
     
      private FuncionarioAdvogado funcionario;
   
      public FuncionarioAdvogado getFuncionario() {
          return funcionario;
      }
   
      public void setFuncionario(FuncionarioAdvogado funcionario) {
          this.funcionario = funcionario;
      }
   
      public FuncionarioBean() {
          funcionario = new FuncionarioAdvogado();
          
      }
   
      public void inserir() throws SQLException, ClassNotFoundException {
          dao.FuncionarioAdvogadoDAO.obterInstancia().gravar(funcionario);
          funcionario = new FuncionarioAdvogado();
      }
   
      public void deletar(FuncionarioAdvogado funcionario) throws SQLException, ClassNotFoundException {
          dao.FuncionarioAdvogadoDAO.obterInstancia().excluir(funcionario);
      }

      public List<FuncionarioAdvogado> getFuncionarios() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return FuncionarioAdvogadoDAO.obterInstancia().obterAdvogados();
      }
  }