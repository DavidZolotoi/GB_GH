package gb.study;

/*
Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
*/

public class Main {
    public static void main(String[] args) {
        Number[] numArray = new Number[3];
        numArray[0] = 1;
        numArray[1] = 2.0f;
        numArray[2] = 29384759823476L;
        MyList<Number> myList = new MyList<>(numArray);
        System.out.println(myList);

        Integer num = 5;
        myList.addElement(num);

        System.out.println(myList);
        System.out.println("size:"+myList.getSize());
        System.out.println("array length:"+myList.getArrayLength());

        myList.removeElement(2);
        System.out.println(myList);
        System.out.println("size:"+myList.getSize());
        System.out.println("array length:"+myList.getArrayLength());

        for (Number number : myList) {
            System.out.println(number);
        }
    }
}