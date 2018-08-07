package stream;

import java.util.stream.Stream;

/**
 * reduce: 把 Stream 元素组合起来
 * Created by fxd on 2018/8/7.
 */
public class reduce {

    public static void main(String[] args) {

        //空字符串为起始值
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);

        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);

        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);

        //没有起始值的reduce返回Optional
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);

        //过滤小写字母，小写字母的ascii码大于大写字母
        concat = Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        System.out.println(concat);
    }
}
