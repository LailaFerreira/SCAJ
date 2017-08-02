package dao;

import java.sql.SQLException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Instancia;

public class InstanciaDAO {

    private static InstanciaDAO instancia = new InstanciaDAO();

    public InstanciaDAO() {
    }

    public static InstanciaDAO obterInstancia() {
        return instancia;
    }

    public List<Instancia> obterInstancias() throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Instancia> instancias = null;
        try {
            tx.begin();
            TypedQuery<Instancia> query = em.createQuery("select i from Instancia i", Instancia.class);
            instancias = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return instancias;
    }

    public Instancia obterInstancia(int idInstancia) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Instancia instancia = null;
        try {
            tx.begin();
            instancia = em.find(Instancia.class, idInstancia);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return instancia;
    }

    public void gravar(Instancia instancia) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (instancia.getIdInstancia() != null) {
                em.merge(instancia);
            } else {
                em.persist(instancia);
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

    public void excluir(Instancia instancia) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Instancia.class, instancia.getIdInstancia()));
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
