package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by fxd on 2018/8/26.
 */
public class PrivateCarReflect {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflect.PrivateCar");

        PrivateCar pcar = (PrivateCar)clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        colorFld.setAccessible(true);
        colorFld.set(pcar, "红色");

        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[])null);

        colorFld.setAccessible(true);
        driveMtd.invoke(pcar, (Object[])null);


    }
}
