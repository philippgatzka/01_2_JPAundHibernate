package ch.bbw.pg.employee;

import ch.bbw.pg.employee.persistence.EmployeePersistence;

/**
 * @author P. Gatzka
 * @version 05.10.2021
 * Project: 01_JPAundHibernate
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Employee with Hibernate Entity Manager");
        EmployeePersistence persistence = new EmployeePersistence();
        System.out.println("List all employees: " + persistence.read());
        persistence.close();
    }
}
