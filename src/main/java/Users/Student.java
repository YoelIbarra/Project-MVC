package Users;


import Subjects.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student{

    /**
     * ATTRIBUTES
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int dni;
    @Column
    private int file;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    /**
     * CONSTRUCTOR
     **/
    public Student(){}
    //WITH ID
    public Student(int id, int dni, int file, List<Subject> subjects) {
        this.id = id;
        this.dni = dni;
        this.file = file;
        this.subjects = subjects;
    }

    //WITHOUT ID
    public Student(int dni, int file, List<Subject> subjects) {
        this.dni = dni;
        this.file = file;
        this.subjects = subjects;
    }

    //WITHOUT LIST Subjects
    public Student(int dni, int file) {
        this.dni = dni;
        this.file = file;
    }

    /**
     * GETTERS
     **/
    public int getId() {
        return id;
    }

    public int getDni() {
        return dni;
    }

    public int getFile() {
        return file;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    /** SETTERS **/
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setFile(int file) {
        this.file = file;
    }
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /** METHODS **/
    public void newSubject(Subject subject){
        subject.newStudent();
        subjects.add(subject);
    }
}
