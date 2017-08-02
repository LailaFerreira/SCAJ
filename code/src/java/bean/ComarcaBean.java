package bean;
   
import model.Comarca;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.ComarcaDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
   
  //Este annotation é necessário para que o formulário possa fazer chamadas à métodos desta classe.
  //O atributo name server para dar-lhe um nome, o qual será usado nos formulários web para acessar dados nesta classe.
  @ManagedBean(name = "comarcaBean")
   
  //Este annotation define o tipo de escopo de sessão para ViewScoped, ou seja, a sessão permanece enquanto o formulário permanecer aberto.
  @ViewScoped
  public class ComarcaBean implements Serializable {
   
      //lista para armazenar os dados (apenas para simular um "banco de dados")
      private static final List<Comarca> dados = new ArrayList();
   
      //atributo que receberá os dados digitados nos campos
      private Comarca comarca;
   
      public Comarca getComarca() {
          return comarca;
      }
   
      public void setComarca(Comarca comarca) {
          this.comarca = comarca;
      }
   
      //ao criar a Bean, um novo Contato é instanciado. Isso acontece toda vez que o formulário é carregado. 
      //Isso acontece devido ao tipo de sessão ser ViewScoped
      public ComarcaBean() {
          comarca = new Comarca();
          System.out.println("!");
      }
   
      //Na página, ao clicar em salvar, este método é acionado. Os valores já estão no atributo contato, basta adicioná-lo à lista.
      public void inserir() throws SQLException, ClassNotFoundException {
          dao.ComarcaDAO.obterInstancia().gravar(comarca);
          comarca = new Comarca();
      }
   
      public void deletar(Comarca comarca) throws SQLException, ClassNotFoundException {
          dao.ComarcaDAO.obterInstancia().excluir(comarca);
      }

      public List<Comarca> getComarcas() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return ComarcaDAO.obterInstancia().obterComarcas();
      }
  }