package gb.study;

/*
Есть пять философов (потоки), которые могут либо обедать, либо размышлять.
Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
После каждого приема пищи философ должен размышлять
Не должно возникнуть общей блокировки
Философы не должны есть больше одного раза подряд
*/

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
//        int philosopherCount = 5;
//        ExecutorService executor = Executors.newFixedThreadPool(philosopherCount);
//        for (int i = 0; i < philosopherCount; i++) {
//            PhilosopherOld philosopherOld = new PhilosopherOld(i);
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    if (philosopherOld.getState() == 0)
//                        philosopherOld.eat();
//                    if (philosopherOld.getState() == 1)
//                        philosopherOld.think();
//                    if (philosopherOld.getState() == 2)
//                        philosopherOld.sleep();
//                }
//            });
//        }
//        executor.shutdown();

        final int PHILOSOPHERS_COUNT = 5;                             //количество философов
        final int EATS_COUNT = 3;                                     //количество необходимых поеданий
        Food food = new Food(PHILOSOPHERS_COUNT * EATS_COUNT);  //запас еды (общий ресурс, 1 штука - это 1 поедание 1-м философом)
        //создать философов
        ArrayList<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            String name = "Философ" + (i+1);
            philosophers.add(new Philosopher(name, food));
        }
        //запустить их всех
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}

