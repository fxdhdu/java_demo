package delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * Created by fxd on 2018/8/11.
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {
            //
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
