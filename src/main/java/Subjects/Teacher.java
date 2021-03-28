package Subjects;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Teacher {

    /** ATTRIBUTES **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column
    private int dni;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private boolean active;

    /** CONSTRUCTOR **/
    //With ID
    public Teacher (int _id, int _dni, String _firstName, String _lastName, boolean _active){
        id = _id;
        dni = _dni;
        lastName = _lastName;
        firstName = _firstName;
        active = _active;
    }
    //WITHOUT ID
    public Teacher ( int _dni, String _firstName, String _lastName, boolean _active){
        dni = _dni;
        lastName = _lastName;
        firstName = _firstName;
        active = _active;
    }
    public Teacher(){}

    /** GETTERS **/
    public int getId() {
        return id;
    }
    public int getDni() {
        return dni;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public boolean isActive() {
        return active;
    }

    /** SETTERS **/
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @OneToMany(mappedBy = "teacher")
    private Collection<Subject> subject;

    public Collection<Subject> getSubject() {
        return subject;
    }

    public void setSubject(Collection<Subject> subject) {
        this.subject = subject;
    }
}
