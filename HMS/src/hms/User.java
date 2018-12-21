package hms;

public class User {

    private String name;
    private String password;
    DataBaseController DBC = HMS.getDBC();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.Save_Users_info();
    }

    public void Save_Users_info() {
        DBC.Send_Users_Data(this);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
}
