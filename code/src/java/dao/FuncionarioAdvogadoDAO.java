package dao;

import java.sql.SQLException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.FuncionarioAdvogado;

public class FuncionarioAdvogadoDAO {

    private static FuncionarioAdvogadoDAO instancia = new FuncionarioAdvogadoDAO();

    public FuncionarioAdvogadoDAO() {
    }

    public static FuncionarioAdvogadoDAO obterInstancia() {
        return instancia;
    }

    public List<FuncionarioAdvogado> obterAdvogados() throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<FuncionarioAdvogado> funcionarios = null;
        try {
            tx.begin();
            TypedQuery<FuncionarioAdvogado> query = em.createQuery("select f from FuncionarioAdvogado f", FuncionarioAdvogado.class);
            funcionarios = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionarios;
    }

    public FuncionarioAdvogado obterAdvogado(int idFuncionarioAdvogado) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        FuncionarioAdvogado funcionario = null;
        try {
            tx.begin();
            funcionario = em.find(FuncionarioAdvogado.class, idFuncionarioAdvogado);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return funcionario;
    }

    public void gravar(FuncionarioAdvogado advogado) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (advogado.getIdFuncionarioAdvogado() != null) {
                em.merge(advogado);
            } else {
                em.persist(advogado);
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

    public void excluir(FuncionarioAdvogado advogado) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(FuncionarioAdvogado.class, advogado.getIdFuncionarioAdvogado()));
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
