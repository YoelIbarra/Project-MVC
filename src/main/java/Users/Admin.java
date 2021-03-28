package Users;

import javax.persistence.*;

@Entity
public class Admin {
    /** ATTRIBUTES **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String user;
    @Column
    private String password;

    /** CONSTRUCTOR **/
    public Admin(){}
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
