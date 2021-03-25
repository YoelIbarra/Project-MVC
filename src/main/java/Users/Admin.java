package Users;

public class Admin {
    /** ATTRIBUTES **/
    private int id;
    private String user;
    private String password;

    /** CONSTRUCTOR **/
    //Only Test
    public Admin (int _id,String _user,String _password){
        user = _user;
        id = _id;
        password = _password;
    }
    //New Admin
    public Admin (String _user,String _password){
        user = _user;
        password = _password;
    }

    /** GETTERS **/
    public int getId() {
        return id;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }

    /** SETTERS **/
    public void setUser(String user) {
        this.user = user;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
