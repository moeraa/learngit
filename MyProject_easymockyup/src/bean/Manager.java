package bean;

/**
 * Created by jw_tute on 2016/6/8.
 */
public class Manager {
    private String username;
    private String password;

    public Manager(){
        this.username="";
        this.password="";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
