package ch.bbw.pg.employee.persistence;

import ch.bbw.pg.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.util.List;

/**
 * @author P. Gatzka
 * @version 05.10.2021
 * Project: 01_JPAundHibernate
 */
public class EmployeePersistence implements IPersistence<Employee> {

    private static SessionFactory sessionFactory;
    private static Session session;

    public EmployeePersistence() {
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> read() {
        List<Employee> employees = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            employees = session.createQuery("select e from Employee e").getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return employees;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
