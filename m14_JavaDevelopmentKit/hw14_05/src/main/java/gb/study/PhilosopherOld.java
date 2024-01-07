package gb.study;

public class PhilosopherOld {
    private int number;
    private int state;
    public int getState() {
        return state;
    }

    public PhilosopherOld(int number) {
        this.number = number;
        this.state = 0;
    }

    public void eat() {
        if (state == 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("№" + this.number + " поел");
            state = 1;
        }
    }

    public void think() {
        if (state == 1) {
            state = 2;
        }
        System.out.println("№" + this.number + " подумал");
    }

    public void sleep() {
        if (state == 2) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = 0;
        }
        System.out.println("№" + this.number + " поспал");
    }
}
