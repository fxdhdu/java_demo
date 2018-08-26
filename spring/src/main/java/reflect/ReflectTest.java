package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 * Created by fxd on 2018/8/26.
 */
public class ReflectTest {

    private static Car initByDefaultConst() throws Throwable {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflect.Car");

        Constructor cons =  clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car)cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;

    }

    public static void main(String[] args) {
        try {
            Car car = initByDefaultConst();
            car.introduce();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

    }
}
