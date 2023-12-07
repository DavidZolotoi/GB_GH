package gb.study;

interface Develop {
    default void develop(){
        System.out.println("I'm developer");
    }
}

interface Backend extends Develop {
    default void developBack(){
        System.out.println("backend");
    };
}

interface Frontend extends Develop {
    default void developFront(){
        System.out.println("fronted");
    };
}

interface Fullstack extends Backend, Frontend {}

class FullstackDeveloper implements Fullstack{

    @Override
    public void developBack() {

    }

    @Override
    public void developFront() {
        System.out.println("But i realy FullstackDeveloper");
    }
}

public class Main  {
    public static void main(String[] args) {
        Develop dev = new FullstackDeveloper();
        dev.develop();
        if (dev instanceof Backend) {
            ((Backend) dev).developBack();
        }
        if (dev instanceof Frontend) {
            ((Frontend) dev).developFront();
        }
    }
}