package Subjects;

public class Subject {

    /** ATTRIBUTES **/
    private int id;
    private String name;
    private char turn;
    private int start;
    private int end;
    private int max_students;
    private int number_students;
    private Teacher teacher;

    /** CONSTRUCTOR **/
    //WITH ID
    public Subject(int id, String name, char turn, int start, int end, int max_students, int number_students, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.turn = turn;
        this.start = start;
        this.end = end;
        this.max_students = max_students;
        this.number_students = number_students;
        this.teacher = teacher;
    }
    //WITHOUT ID
    public Subject(String name, char turn, int start, int end, int max_students, int number_students, Teacher teacher) {
        this.name = name;
        this.turn = turn;
        this.start = start;
        this.end = end;
        this.max_students = max_students;
        this.number_students = number_students;
        this.teacher = teacher;
    }

    /** GETTERS **/
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public char getTurn() {
        return turn;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
    public int getMax_students() {
        return max_students;
    }
    public int getNumber_students() {
        return number_students;
    }
    public Teacher getTeacher() {
        return teacher;
    }

    /** SETTERS **/
    public void setName(String name) {
        this.name = name;
    }
    public void setTurn(char turn) {
        this.turn = turn;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public void setEnd(int end) {
        this.end = end;
    }
    public void setMax_students(int max_students) {
        this.max_students = max_students;
    }
    public void setNumber_students(int number_students) {
        this.number_students = number_students;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /** METHODS **/
    public void newStudent(){
        if(this.isSpaceAvailable()) {
            number_students += 1;
        }
        else{
            //throw exception it isn't any place
        }

    }
    public boolean isSpaceAvailable(){
        return (number_students<max_students);
    }
}
