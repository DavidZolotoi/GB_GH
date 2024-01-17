package gb.study;

public class Dog extends Animal{
    public Dog(String name, int age) {
        super(name, age);
    }

    private void makeSound(){
        System.out.println("hav-hav-hav");
    }
}
