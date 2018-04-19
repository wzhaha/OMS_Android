package Entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/4/19.
 */

public class UserItem implements Serializable{
    private String name;
    private String password;
    private String userRole;
    private String face;
    public UserItem(String username, String password, String userRole, String face) {
        this.name = username;
        this.password = password;
        this.userRole = userRole;
        this.face = face;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
