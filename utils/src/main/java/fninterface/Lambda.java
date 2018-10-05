package fninterface;

/**
 * Created by fxd on 2018/10/5.
 */
public class Lambda {
    public static void PrintString(String s, Print<String> print) {
        print.print(s);
    }

    public static void main(String[] args) {
        PrintString("test", (x) -> System.out.println(x));
    }
}
