package dao;

import java.sql.SQLException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Documento;

public class DocumentoDAO {

    private static DocumentoDAO instancia = new DocumentoDAO();

    public DocumentoDAO() {
    }

    public static DocumentoDAO obterInstancia() {
        return instancia;
    }

    public List<Documento> obterDocumentos() throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Documento> documentos = null;
        try {
            tx.begin();
            TypedQuery<Documento> query = em.createQuery("select d from Documento d", Documento.class);
            documentos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return documentos;
    }

    public Documento obterDocumento(int idDocumento) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Documento documento = null;
        try {
            tx.begin();
            documento = em.find(Documento.class, idDocumento);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return documento;
    }

    public void gravar(Documento documento) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (documento.getIdDocumento() != null) {
                em.merge(documento);
            } else {
                em.persist(documento);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public void excluir(Documento documento) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Documento.class, documento.getIdDocumento()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }
}
