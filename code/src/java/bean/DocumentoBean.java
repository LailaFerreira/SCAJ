package bean;
   
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import dao.DocumentoDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import model.Documento;
   
 @ManagedBean(name = "documentoBean")
   
  @ViewScoped
  public class DocumentoBean implements Serializable {
     
      private Documento documento;
   
      public Documento getDocumento() {
          return documento;
      }
   
      public void setDocumento(Documento documento) {
          this.documento = documento;
      }
   
      public DocumentoBean() {
          documento = new Documento();
      }
   
      public void inserir() throws SQLException, ClassNotFoundException {
          dao.DocumentoDAO.obterInstancia().gravar(documento);
          documento = new Documento();
      }
   
      public void deletar(Documento documento) throws SQLException, ClassNotFoundException {
          dao.DocumentoDAO.obterInstancia().excluir(documento);
      }

      public List<Documento> getDocumentos() throws ServletException, IOException, ClassNotFoundException, SQLException {
          return DocumentoDAO.obterInstancia().obterDocumentos();
      }
  }