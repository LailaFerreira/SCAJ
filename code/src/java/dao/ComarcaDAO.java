package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Comarca;
import model.FonteIndicacao;

public class ComarcaDAO {
private static  ComarcaDAO instancia = new ComarcaDAO();

    public ComarcaDAO() {
    }

    public static ComarcaDAO obterInstancia() {
        return instancia;
    }
    public List<Comarca> obterComarcas() throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Comarca> comarcas = null;
        try {
            tx.begin();
            TypedQuery<Comarca> query = em.createQuery("SELECT c FROM Comarca c", Comarca.class);
            comarcas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return comarcas;
    }

    public Comarca obterComarca(int idComarca) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Comarca comarca = null;
        try {
            tx.begin();
            comarca = em.find(Comarca.class, idComarca);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return comarca;
    }

    public void gravar(Comarca comarca) throws SQLException, ClassNotFoundException {
       EntityManager em = PersistenceUtil.getEntityManager();
       EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (comarca.getIdComarca()!= null) {
                em.merge(comarca);
            } else {
                em.persist(comarca);
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

    public void excluir(Comarca comarca)  throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Comarca.class, comarca.getIdComarca()));
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
