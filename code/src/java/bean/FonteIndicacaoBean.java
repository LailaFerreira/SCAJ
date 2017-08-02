package bean;
   
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.FonteIndicacao;
   
  //Este annotation é necessário para que o formulário possa fazer chamadas à métodos desta classe.
  //O atributo name server para dar-lhe um nome, o qual será usado nos formulários web para acessar dados nesta classe.
  @ManagedBean(name = "fonteIndicacaoBean")
   
  //Este annotation define o tipo de escopo de sessão para ViewScoped, ou seja, a sessão permanece enquanto o formulário permanecer aberto.
  @ViewScoped
  public class FonteIndicacaoBean implements Serializable {
   
      private FonteIndicacao fonteIndicacao;
   
      public FonteIndicacao getFonteIndicacao() {
          return fonteIndicacao;
      }
   
      public void setFonteIndicacao(FonteIndicacao fonteIndicacao) {
          this.fonteIndicacao = fonteIndicacao;
      }
   
    
      public FonteIndicacaoBean() {
          fonteIndicacao = new FonteIndicacao();
      }
   
      public void inserir() throws SQLException, ClassNotFoundException {
          fonteIndicacao.setIdFonteIndicacao(3);
          dao.FonteIndicacaoDAO.obterInstancia().gravar(fonteIndicacao);
          fonteIndicacao = new FonteIndicacao();
      }
   
      public void deletar(FonteIndicacao fonteIndicacao) throws SQLException, ClassNotFoundException {
          dao.FonteIndicacaoDAO.obterInstancia().excluir(fonteIndicacao);
      }

      public List<FonteIndicacao> getFonteIndicacoes() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return dao.FonteIndicacaoDAO.obterInstancia().obterFonteIndicacoes();
      }
  }