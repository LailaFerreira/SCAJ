package bean;
   
import model.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
   
  //Este annotation é necessário para que o formulário possa fazer chamadas à métodos desta classe.
  //O atributo name server para dar-lhe um nome, o qual será usado nos formulários web para acessar dados nesta classe.
  @ManagedBean(name = "clienteBean")
   
  //Este annotation define o tipo de escopo de sessão para ViewScoped, ou seja, a sessão permanece enquanto o formulário permanecer aberto.
  @ViewScoped
  public class ClienteBean implements Serializable {
   
      //lista para armazenar os dados (apenas para simular um "banco de dados")
      private static final List<Cliente> dados = new ArrayList();
   
      //atributo que receberá os dados digitados nos campos
      private Cliente cliente;
   
      public Cliente getCliente() {
          return cliente;
      }
   
      public void setCliente(Cliente cliente) {
          this.cliente = cliente;
      }
   
      //ao criar a Bean, um novo Contato é instanciado. Isso acontece toda vez que o formulário é carregado. 
      //Isso acontece devido ao tipo de sessão ser ViewScoped
      public ClienteBean() {
          cliente = new Cliente();
          System.out.println("!");
      }
   
      //Na página, ao clicar em salvar, este método é acionado. Os valores já estão no atributo contato, basta adicioná-lo à lista.
      public void inserir() throws SQLException, ClassNotFoundException {
          dao.ClienteDAO.obterInstancia().gravar(cliente);
          cliente = new Cliente();
      }
   
      public void deletar(Cliente cliente) throws SQLException, ClassNotFoundException {
          dao.ClienteDAO.obterInstancia().excluir(cliente);
      }

      public List<Cliente> getClientes() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return ClienteDAO.obterInstancia().obterClientes();
      }
  }