package bean;
   
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.NaturezaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.Natureza;
   
  @ManagedBean(name = "naturezaBean")
   
  @ViewScoped
  public class NaturezaBean implements Serializable {
   
      private Natureza natureza;
   
      public Natureza getNatureza() {
          return natureza;
      }
   
      public void setNatureza(Natureza natureza) {
          this.natureza = natureza;
      }
   
      
      public NaturezaBean() {
          natureza = new Natureza();
          System.out.println("!");
      }
   
      //Na página, ao clicar em salvar, este método é acionado. Os valores já estão no atributo contato, basta adicioná-lo à lista.
      public void inserir() throws SQLException, ClassNotFoundException {
          natureza.setIdNatureza(3);
          dao.NaturezaDAO.obterInstancia().gravar(natureza);
          natureza = new Natureza();
      }
   
      public void deletar(Natureza natureza) throws SQLException, ClassNotFoundException {
          dao.NaturezaDAO.obterInstancia().excluir(natureza);
      }

      public List<Natureza> getNaturezas() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return NaturezaDAO.obterInstancia().obterNaturezas();
      }
  }