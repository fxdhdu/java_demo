package transienttest;

import java.io.*;

/**
 * Created by fxd on 2018/9/9.
 */
public class ExternalizableTest implements Externalizable {

    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) {
        ExternalizableTest et = new ExternalizableTest();
        String fileName = "D:/test.txt";

        ObjectOutput out;
        ObjectInput in;
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(et);

            in = new ObjectInputStream(new FileInputStream(fileName));
            et = (ExternalizableTest) in.readObject();

            System.out.println(et.content);

            out.close();
            in.close();
        }  catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
