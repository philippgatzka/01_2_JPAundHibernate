package ch.bbw.pg.employee.persistence;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 05.10.2021
 * Project: 01_JPAundHibernate
 */
public interface IPersistence<T> {
    void close(); // CLOSE

    void setup(); // SETUP

    default T create(T entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        return entity;
    } // CREATE

    List<T> read(); // READ

    default T update(T entity) {
        T result = null;
        try {
            getEntityManager().getTransaction().begin();
            result = getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }


        return result;
    }

    default void delete(Long id){
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(find(id));
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
    }

    T find(Long id); // FIND

    EntityManager getEntityManager();
}
