package Entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/4/19.
 */

public class LoginAction implements Serializable {
    private String name;
    private String password;
    private String face;
    public LoginAction(String username, String password, String face) {
        this.name = username;
        this.password = password;
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
}
