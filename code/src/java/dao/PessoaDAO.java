package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Pessoa;

public class PessoaDAO {

    private static final PessoaDAO instancia = new PessoaDAO();

    public PessoaDAO() {
    }

    public static PessoaDAO obterInstancia() {
        return instancia;
    }

    public List<Pessoa> obterPessoas(String TipoPessoa) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pessoa> pessoas = null;
        try {
            tx.begin();
            TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
            pessoas = query.getResultList();
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return pessoas;
    }
    
    public List<Pessoa> obterPessoas() throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        try {
            tx.begin();
            TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
            pessoas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return pessoas;
    }

    public Pessoa obterPessoa(int idPessoa) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Pessoa pessoa = null;
        try {
            tx.begin();
            pessoa = em.find(Pessoa.class, idPessoa);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return pessoa;
    }

    public void gravar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (pessoa.getIdPessoa() != null) {
                em.merge(pessoa);
            } else {
                em.persist(pessoa);
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

    public void excluir(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Pessoa.class, pessoa.getIdPessoa()));
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
