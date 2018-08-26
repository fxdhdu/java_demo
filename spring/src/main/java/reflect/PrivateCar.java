package reflect;

/**
 * Created by fxd on 2018/8/26.
 */
public class PrivateCar {
    private String color;

    protected void drive() {
        System.out.println("drive private car! the color is:"+color);
    }
}
