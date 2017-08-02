package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.FonteIndicacao;

public class FonteIndicacaoDAO {

    private static FonteIndicacaoDAO instancia = new FonteIndicacaoDAO();

    public FonteIndicacaoDAO() {
    }

    public static FonteIndicacaoDAO obterInstancia() {
        return instancia;
    }

    public List<FonteIndicacao> obterFonteIndicacoes() throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<FonteIndicacao> fontes = null;
        try {
            tx.begin();
            TypedQuery<FonteIndicacao> query = em.createQuery("select f from FonteIndicacao f", FonteIndicacao.class);
            fontes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return fontes;
    }

    public FonteIndicacao obterFonteIndicacao(int idFonteIndicacao) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        FonteIndicacao curso = null;
        try {
            tx.begin();
            curso = em.find(FonteIndicacao.class, idFonteIndicacao);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return curso;
    }

    public void gravar(FonteIndicacao fonteIndicacao) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(fonteIndicacao);
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

    public void alterar(FonteIndicacao fonteIndicacao) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(fonteIndicacao);
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

    public void excluir(FonteIndicacao fonteIndicacao) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(FonteIndicacao.class, fonteIndicacao.getIdFonteIndicacao()));
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
