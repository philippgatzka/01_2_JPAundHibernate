package ch.bbw.pg.employee.model;

import javax.persistence.*;

@Table(name = "employee", indexes = {
        @Index(name = "departmentidx", columnList = "departmentidfs")
})
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "departmentidfs")
    private Integer departmentidfs;

    public Integer getDepartmentidfs() {
        return departmentidfs;
    }

    public void setDepartmentidfs(Integer departmentidfs) {
        this.departmentidfs = departmentidfs;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee(String firstname, String lastname, Integer departmentidfs) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentidfs = departmentidfs;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", departmentidfs=" + departmentidfs +
                '}';
    }

    public Employee(Integer id, String firstname, String lastname, Integer departmentidfs) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentidfs = departmentidfs;
    }
}