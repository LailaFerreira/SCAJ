package bean;
   
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.Instancia;
   
  //Este annotation é necessário para que o formulário possa fazer chamadas à métodos desta classe.
  //O atributo name server para dar-lhe um nome, o qual será usado nos formulários web para acessar dados nesta classe.
  @ManagedBean(name = "instanciaBean")
   
  //Este annotation define o tipo de escopo de sessão para ViewScoped, ou seja, a sessão permanece enquanto o formulário permanecer aberto.
  @ViewScoped
  public class InstanciaBean implements Serializable {
   
      private Instancia instancia;
   
      public Instancia getInstancia() {
          return instancia;
      }
   
      public void setInstancia(Instancia instancia) {
          this.instancia = instancia;
      }
   
      //ao criar a Bean, um novo Contato é instanciado. Isso acontece toda vez que o formulário é carregado. 
      //Isso acontece devido ao tipo de sessão ser ViewScoped
      public InstanciaBean() {
          instancia = new Instancia();
          System.out.println("!");
      }
   
      //Na página, ao clicar em salvar, este método é acionado. Os valores já estão no atributo contato, basta adicioná-lo à lista.
      public void inserir() throws SQLException, ClassNotFoundException {
          instancia.setIdInstancia(3);
          dao.InstanciaDAO.obterInstancia().gravar(instancia);
          instancia = new Instancia();
      }
   
      public void deletar(Instancia instancia) throws SQLException, ClassNotFoundException {
          dao.InstanciaDAO.obterInstancia().excluir(instancia);
      }

      public List<Instancia> getInstancias() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return dao.InstanciaDAO.obterInstancia().obterInstancias();
      }
  }