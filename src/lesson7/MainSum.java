package lesson7;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class MainSum {
    static int syncSum;
    static volatile int sum; // volatile - спасает только при чтение-запись, а операция инкремент не атомарная
    static final AtomicInteger ATOMIC_SUM = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sum++;
                    ATOMIC_SUM.incrementAndGet();
                    synchronized (this) {
                        syncSum++;
                    }
                }
            }).start();
        }
        Thread.sleep(500); // иначе main может завершиться раньше, чем run
        System.out.println("sum - " + sum);
        System.out.println("atomic - " + ATOMIC_SUM.get());
        System.out.println("sync - " + syncSum);
    }
}

