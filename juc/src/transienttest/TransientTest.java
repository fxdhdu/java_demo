package transienttest;

import java.io.*;

/**
 * @author fxd
 * @date 2018/9/9
 */
public class TransientTest {

    private static void printUser(User user ) {
        System.out.println("username: " + user.getUsername());
        System.out.println("passwd: " + user.getPasswd());
        System.out.println("USER_NAME: " + User.getUserName());
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("fxd");
        user.setPasswd("hahaha");
        User.setUserName("fanxudong");

        System.out.println("read before Serializable: ");
        printUser(user);

        String fileName = "D:/user.txt";

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 在反序列化之前改变username的值
        User.setUserName("FXD");

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
            user = (User) is.readObject();

            is.close();

            System.out.println("read after Serializable: ");
            printUser(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
