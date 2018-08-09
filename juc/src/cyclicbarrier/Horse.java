package cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by fxd on 2018/8/8.
 */
public class Horse implements Runnable {
    /**
     * static 全局唯一
     **/
    private static int counter = 0;
    /**
     * 非static、final
     **/
    private final int id = counter++;
    /**
     * 步子，去掉书上的static关键字
     */
    private int strides = 0;
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    Horse(CyclicBarrier b) {
        barrier = b;
    }

    synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            //合理的退出方式
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    /**
     * 打印马当前的位子
     **/
    String tracks() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(id);

        return s.toString();
    }
}
