package gb.study;

/*
Есть пять философов (потоки), которые могут либо обедать, либо размышлять.
Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
После каждого приема пищи философ должен размышлять
Не должно возникнуть общей блокировки
Философы не должны есть больше одного раза подряд
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int philosopherCount = 5;
        ExecutorService executor = Executors.newFixedThreadPool(philosopherCount);
        for (int i = 0; i < philosopherCount; i++) {
            Philosopher philosopher = new Philosopher(i);
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    if (philosopher.getState() == 0)
                        philosopher.eat();
                    if (philosopher.getState() == 1)
                        philosopher.think();
                    if (philosopher.getState() == 2)
                        philosopher.sleep();
                }
            });
        }
        executor.shutdown();
    }
}

