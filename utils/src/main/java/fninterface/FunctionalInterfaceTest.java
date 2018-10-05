package fninterface;

/**
 * Created by fxd on 2018/10/5.
 */
public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        Interface1 i1 = (i) -> i * 2;
        Interface1 i2 = i -> i * 2;

        Interface1 i3 = (int i) -> i * 2;

        Interface1 i4 = (int i) -> {
            System.out.println(i);
            return i * 2;
        };
    }
}
