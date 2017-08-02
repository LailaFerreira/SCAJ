package bean;
   
import model.Cargo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.Vara;
   
  //Este annotation é necessário para que o formulário possa fazer chamadas à métodos desta classe.
  //O atributo name server para dar-lhe um nome, o qual será usado nos formulários web para acessar dados nesta classe.
  @ManagedBean(name = "varaBean")
   
  //Este annotation define o tipo de escopo de sessão para ViewScoped, ou seja, a sessão permanece enquanto o formulário permanecer aberto.
  @ViewScoped
  public class VaraBean implements Serializable {
   
      //lista para armazenar os dados (apenas para simular um "banco de dados")
      private static final List<Vara> varas = new ArrayList();
   
      //atributo que receberá os dados digitados nos campos
      private Vara vara;
   
      public Vara getVara() {
          return vara;
      }
   
      public void setVara(Vara vara) {
          this.vara = vara;
      }
   
      //ao criar a Bean, um novo Contato é instanciado. Isso acontece toda vez que o formulário é carregado. 
      //Isso acontece devido ao tipo de sessão ser ViewScoped
      public VaraBean() {
          vara = new Vara();
          System.out.println("!");
      }
   
      //Na página, ao clicar em salvar, este método é acionado. Os valores já estão no atributo contato, basta adicioná-lo à lista.
      public void inserir() throws SQLException, ClassNotFoundException {
          vara.setIdVara(3);
          dao.VaraDAO.obterInstancia().gravar(vara);
          vara = new Vara();
      }
   
      public void deletar(Cargo cargo) throws SQLException, ClassNotFoundException {
          dao.VaraDAO.obterInstancia().excluir(vara);
      }

      public List<Vara> getVaras() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return dao.VaraDAO.obterInstancia().obterVaras();
      }
  }