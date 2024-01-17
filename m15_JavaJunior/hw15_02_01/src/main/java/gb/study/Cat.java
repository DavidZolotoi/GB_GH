package gb.study;

public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }

    private void makeSound(){
        System.out.println("mau-mau-mau");
    }
}
