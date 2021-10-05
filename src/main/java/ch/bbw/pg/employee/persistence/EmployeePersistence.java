package ch.bbw.pg.employee.persistence;

import ch.bbw.pg.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 05.10.2021
 * Project: 01_JPAundHibernate
 */
public class EmployeePersistence implements IPersistence<Employee> {


    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public EmployeePersistence() {
        factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> read() {
        List<Employee> employees = null;
        try {
            entityManager.getTransaction().begin();
            employees = entityManager.createNamedQuery("Employee.findAll").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return employees;
    }

    @Override
    public void close() {
        entityManager.close();
        factory.close();
    }
}
