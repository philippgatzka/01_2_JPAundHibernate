package ch.bbw.pg.employee.persistence;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author P. Gatzka
 * @version 05.10.2021
 * Project: 01_JPAundHibernate
 */
public interface IPersistence<T> {
    // CRUD
    // CREATE
    List<T> read(); // READ
    // UPDATE
    // DELETE

    void close(); // CLOSE
}
