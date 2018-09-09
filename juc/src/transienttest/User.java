package transienttest;

import java.io.Serializable;

/**
 * @author fxd
 * @date 2018/9/9
 */
class User implements Serializable {
    private static final long serialVersionUID = 20759935533228564L;

    private String username;
    private transient String passwd;
    private static String USER_NAME;

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getPasswd() {
        return passwd;
    }

    void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    static String getUserName() {
        return USER_NAME;
    }

    static void setUserName(String userName) {
        USER_NAME = userName;
    }
}
