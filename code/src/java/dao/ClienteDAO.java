package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.FonteIndicacao;
import model.Pessoa;

public class ClienteDAO {

    private static  ClienteDAO instancia = new ClienteDAO();

    public ClienteDAO() {
    }

    public static ClienteDAO obterInstancia() {
        return instancia;
    }
    
    public List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cliente> clientes = null;
        try {
            tx.begin();
            TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);
            clientes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return clientes;
    }

    public Cliente obterCliente(int idCliente) throws ClassNotFoundException, SQLException {
        Pessoa pessoa = null;
        FonteIndicacao fonteIndicacao = null;

        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Cliente cliente = null;
        try {
            tx.begin();
            cliente = em.find(Cliente.class, idCliente);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return cliente;
    }

    public void gravar(Cliente cliente) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (cliente.getIdCliente()!= null) {
                em.merge(cliente);
            } else {
                em.persist(cliente);
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

    public static void excluir(Cliente cliente) throws SQLException, ClassNotFoundException {
       EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Cliente.class, cliente.getIdCliente()));
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
