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
import model.Cargo;

public class CargoDAO {

    private static final  CargoDAO instancia = new CargoDAO();

    public CargoDAO() {
    }

    public static CargoDAO obterInstancia() {
        return instancia;
    }

    public List<Cargo> obterCargos() throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cargo> cargos = new ArrayList<Cargo>();

        try {
            tx.begin();
            TypedQuery<Cargo> query = em.createQuery("select c from Cargo c", Cargo.class);
            cargos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return cargos;
    }

    public Cargo obterCargo(int idCargo) throws ClassNotFoundException, SQLException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Cargo cargo = new Cargo();
        try {
            tx.begin();
            cargo = em.find(Cargo.class, idCargo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return cargo;
    }

    public void gravar(Cargo cargo) throws SQLException, ClassNotFoundException {
       EntityManager em = PersistenceUtil.getEntityManager();
       EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (cargo.getIdCargo()!= null) {
                em.merge(cargo);
            } else {
                em.persist(cargo);
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

    public void excluir(Cargo cargo) throws SQLException, ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(em.getReference(Cargo.class, cargo.getIdCargo()));
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
