package gb.study;

import java.time.Duration;
import java.time.Instant;

public class Philosopher extends Thread {

    final private int MAXIMUM_NUMBER_OF_EATS = 3;

    private int numberOfEats;
    protected int getNumberOfEats() {
        return numberOfEats;
    }
    protected Instant startEat;
    protected Instant endEat;
    private int numberOfThinks;
    protected int getNumberOfThinks() {
        return numberOfThinks;
    }
    protected Instant startThink;
    protected Instant endThink;
    private String myName;
    protected String getMyName() {
        return myName;
    }
    private Food food;

    protected Philosopher(String myName, Food food) {
        this.myName = myName;
        this.food = food;
        this.numberOfEats = 0;
        this.numberOfThinks = 0;
        this.startEat = Instant.now();  //заглушка, это число поменяется
        this.startThink = Instant.now();//заглушка, это число поменяется
    }

    @Override
    public void run() {

        new Thread(() -> eat()).start();    //запустить голод

        // ожидать, пока один из философов не начнет есть (программа только загружается)
        while (food.philosopherName == null) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // после того как кто-то начал есть - программа начинает свою работу и те, кто не едят - думают
        think();

    }

    /**
     * Метод философа - думать
     */
    private void think() {
        //думать до тех пор, пока не начнет есть (поток не прорвётся в синхронизированный метод поедания)
        while (!food.philosopherName.equals(myName) || numberOfEats == 0) {
            try {
                Thread.sleep(100);   //без этой паузы бесконечный цикл не хочет работать
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        endThink = Instant.now();
        Duration durationThink = Duration.between(startThink, endThink);
        System.out.println(myName + " закончил думать в " + (numberOfThinks + 1) + " раз. Думал: " + durationThink.getSeconds() + " с.");
        numberOfThinks += 1;
    }

    /**
     * Метод философа - есть
     */
    private void eat() {
        for (int i = 0; i < MAXIMUM_NUMBER_OF_EATS; i++){
            if (food.getCount() == 0) return;
            food.reduce(Philosopher.this, 1);
            numberOfEats += 1;
            System.out.println(myName + " начал думать в " + (numberOfThinks + 1) + " раз.");
            startThink = Instant.now();
        }
    }
}
