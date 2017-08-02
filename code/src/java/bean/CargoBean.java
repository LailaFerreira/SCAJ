package bean;
   
import model.Cargo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.CargoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
   
  //Este annotation é necessário para que o formulário possa fazer chamadas à métodos desta classe.
  //O atributo name server para dar-lhe um nome, o qual será usado nos formulários web para acessar dados nesta classe.
  @ManagedBean(name = "cargoBean")
   
  //Este annotation define o tipo de escopo de sessão para ViewScoped, ou seja, a sessão permanece enquanto o formulário permanecer aberto.
  @ViewScoped
  public class CargoBean implements Serializable {
   
      //lista para armazenar os dados (apenas para simular um "banco de dados")
      private static final List<Cargo> dados = new ArrayList();
   
      //atributo que receberá os dados digitados nos campos
      private Cargo cargo;
   
      public Cargo getCargo() {
          return cargo;
      }
   
      public void setCargo(Cargo cargo) {
          this.cargo = cargo;
      }
   
      //ao criar a Bean, um novo Contato é instanciado. Isso acontece toda vez que o formulário é carregado. 
      //Isso acontece devido ao tipo de sessão ser ViewScoped
      public CargoBean() {
          cargo = new Cargo();
          System.out.println("!");
      }
   
      //Na página, ao clicar em salvar, este método é acionado. Os valores já estão no atributo contato, basta adicioná-lo à lista.
      public void inserir() throws SQLException, ClassNotFoundException {
          cargo.setIdCargo(3);
          dao.CargoDAO.obterInstancia().gravar(cargo);
          cargo = new Cargo();
      }
   
      public void deletar(Cargo cargo) throws SQLException, ClassNotFoundException {
          dao.CargoDAO.obterInstancia().excluir(cargo);
      }

      public List<Cargo> getCargos() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return CargoDAO.obterInstancia().obterCargos();
      }
  }