import java.util.LinkedList;

/*
 * Реализуйте очередь с помощью LinkedList со следующими методами:
 * • enqueue() — помещает элемент в конец очереди,
 * • dequeue() — возвращает первый элемент из очереди и удаляет его,
 * • first() — возвращает первый элемент из очереди, не удаляя.
 */

public class hw04_02
{
    public static void main(String[] args)
    {
        LinkedList<String> myLinkedList = new LinkedList<>();
        enqueue(myLinkedList, "0");
        enqueue(myLinkedList, "1");
        enqueue(myLinkedList, "2");
        enqueue(myLinkedList, "3");
        System.out.printf("Состояние листа на данный момент: %s\n", myLinkedList);
        System.out.printf("Показ первого без его удаления: %s\n", first(myLinkedList));
        System.out.printf("Показ первого с его удалением: %s\n", dequeue(myLinkedList));
        System.out.printf("Состояние листа на данный момент: %s\n", myLinkedList);
    }

    // метод, возвращающий первый элемент из очереди и удаляющий его
    private static String dequeue(LinkedList<String> myLinkedList)
    {
        String tmp = myLinkedList.get(0);
        myLinkedList.remove(0);
        return tmp;
    }

    // метод, возвращающий первый элемент из очереди, не удаляя
    private static String first(LinkedList<String> myLinkedList)
    {
        return myLinkedList.get(0);
    }

    // метод, помещающий элемент в конец очереди
    private static LinkedList<String> enqueue(LinkedList<String> myLinkedList, String txtForAdd)
    {
        myLinkedList.add(txtForAdd);
        return myLinkedList;
    }

}
