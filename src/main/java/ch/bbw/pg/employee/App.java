package ch.bbw.pg.employee;

import ch.bbw.pg.employee.persistence.EmployeePersistence;

/**
 * @author P. Gatzka
 * @version 05.10.2021
 * Project: 01_JPAundHibernate
 */
public class App {

    public static void main(String[] args) {
        EmployeePersistence p = new EmployeePersistence();
        p.setup();
        System.out.println(p.read());
        p.close();
    }
}
