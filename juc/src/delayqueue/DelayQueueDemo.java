package delayqueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DelayQueue是一个无界的BlockingQueue
 *
 * Created by fxd on 2018/8/11.
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();

        DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();

        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(rand.nextInt(5000)));
        }

        /*放置在队列尾，提供了一种关闭所有事物的途径*/
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
