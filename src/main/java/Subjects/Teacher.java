package Subjects;

public class Teacher {

    /** ATTRIBUTES **/
    private int id;
    private int dni;
    private String firstName;
    private String lastName;
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
}
