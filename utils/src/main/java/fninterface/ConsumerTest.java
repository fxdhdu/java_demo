package fninterface;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Created by fxd on 2018/10/5.
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("测试数据");

        IntConsumer intConsumer = (value) -> System.out.println("测试数据："+ value);
        intConsumer.accept(9);
    }
}
