package fninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by fxd on 2018/9/16.
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        eval(list, n -> true);
        eval(list, n -> n % 2 == 0);
        eval(list, n -> n > 3);
    }

    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        StringBuilder sb = new StringBuilder();
        for (Integer n : list) {
            if (predicate.test(n)) {
                sb.append(n).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
