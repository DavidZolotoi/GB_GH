package gb.study;

import java.time.Duration;
import java.time.Instant;

class Food {
    private Integer count;
    protected Integer getCount() {
        return count;
    }
    protected String philosopherName;

    protected Food(Integer count) {
        this.count = count;
    }

    /**
     * Синхронизированный метод уменьшения еды из-за ее поедания философами.
     * Блокирует ресурсы экземпляра еды для всех потоков, кроме прорвавшегося.
     * @param philosopher философ, который прорвался (ест еду)
     * @param countForReduce количество поедамой пищи.
     */
    protected synchronized void reduce(Philosopher philosopher, Integer countForReduce) {
        this.philosopherName = philosopher.getMyName();
        System.out.println(philosopher.getMyName() + " начал есть в " + (philosopher.getNumberOfEats() + 1) + " раз.");
        philosopher.startEat = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        count -= countForReduce;
        philosopher.endEat = Instant.now();
        Duration durationEat = Duration.between(philosopher.startEat, philosopher.endEat);
        System.out.println(philosopher.getMyName() + " закончил есть в " + (philosopher.getNumberOfEats() + 1) + " раз. Ел: " + durationEat.getSeconds() + " с.");
    }
}
