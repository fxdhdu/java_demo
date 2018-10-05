package fninterface;

/**
 * 函数接口，接口只能有一个需要实现的方法
 * 可提供接口的默认方法
 * Created by fxd on 2018/10/5.
 */
@FunctionalInterface
interface Interface1 {
    int doubleNum(int i);

    default int add(int x, int y) {
        return x + y;
    }
}
