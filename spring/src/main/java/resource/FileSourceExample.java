package resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by fxd on 2018/8/26.
 */
public class FileSourceExample {

    public static void main(String[] args) {
        try {
            String filePath = "D:\\JavaProject\\juctest\\spring\\src\\main\\resources\\file.text";

            WritableResource res1 = new PathResource(filePath);
            Resource res2 = new ClassPathResource("file.text");


            OutputStream stream1 = res1.getOutputStream();
            stream1.write("haha".getBytes());
            stream1.close();


            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int i;
            while((i=ins1.read()) != -1) {
                baos.write(i);
            }

            System.out.println(baos.toString());

            System.out.println("res1:"+res1.getFilename());
            System.out.println("res2:"+res2.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
