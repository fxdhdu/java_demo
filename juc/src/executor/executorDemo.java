package executor;

import java.util.concurrent.*;

/**
 * Created by fxd on 2018/8/21.
 */
public class executorDemo {

    public static void main(String[] args) {

        /*
         * void execute(Runnable command);提交一个任务
         */
        Executor exe = null;

        /*
         * 定义一个线程池
         * void shutdown();
         * List<Runnable> shutdownNow();
         * boolean isShutdown();
         * boolean isTerminated();
         * boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
         *  <T> Future<T> submit(Callable<T> task);
         *  <T> Future<T> submit(Runnable task, T result);
         *  Future<?> submit(Runnable task);
         *  ...
         */
        ExecutorService exeSer = null;

        /*
         * 没有真正开启线程来执行任务
         *
         * 将我们的任务包装成 FutureTask 提交到线程池中执行
         * protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value)
         * protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable)
         * 提交任务
         * public Future<?> submit(Runnable task)
         * public <T> Future<T> submit(Runnable task, T result)
         * public <T> Future<T> submit(Callable<T> task)
         *
         */
        AbstractExecutorService aes = null;

        /*执行器*/
        ThreadPoolExecutor tpe = null;

        Executors exes = null;

        /*获取线程执行的结果*/
        Future future = null;
        Runnable runnable;

        RunnableFuture runnableFuture = null;
        FutureTask futureTask = null;

        /*call() 方法有返回值，同时，如果运行出现异常，call() 方法会抛出异常*/
        Callable callable;

        /*
         * 如果线程数达到 corePoolSize，我们的每个任务会提交到等待队列中，
         * 等待线程池中的线程来取任务并执行
         */
        BlockingQueue blockingQueue;
        LinkedBlockingQueue linkedBlockingQueue;
        ArrayBlockingQueue arrayBlockingQueue;
        SynchronousQueue synchronousQueue;

        /*定时任务实现类*/
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    }


}
