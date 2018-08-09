package cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by fxd on 2018/8/9.
 */
class HorseRace {
    private static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, () -> {

            StringBuilder s = new StringBuilder();

            //打印跑道
            for (int i = 0; i < FINISH_LINE; i++) {
                s.append("=");
            }
            System.out.println(s);

            //打印马儿位置
            for (Horse horse : horses) {
                System.out.println(horse.tracks());
            }

            //判断是否有马到达终点，通常平局的情况下id越小的马儿胜
            for (Horse horse : horses) {
                if (horse.getStrides() >= FINISH_LINE) {
                    System.out.println(horse + "won!");
                    //使用shutdownNow, 用shutdown则线程不会立刻停止。
                    exec.shutdownNow();
                    return;
                }
            }

            //sleep
            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("barrier-action sleep interrupted");
            }
        }
        );

        //创建马儿，并使马儿快跑
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }
}
