package gb.study;

public class SomeClass {
    private String name;
    private Integer age;

    public SomeClass() {}

    public SomeClass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private void somePrivateMethod(){
        System.out.println("Я - приватный метод и меня никто и никогда не сможет запустить извне!");
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
