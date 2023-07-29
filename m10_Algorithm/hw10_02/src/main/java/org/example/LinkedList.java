package org.example;

import java.util.Comparator;

public class LinkedList<T> {

    /**
     * Элемент (узел) состоит из 2х челнов: значение и ссылка.
     * !!!Сам элемент и ссылка внутри него имеют один и тот же тип!!!
     */
    public class Node{
        /**
         * Ссылка на следующий элемент
         */
        public Node next;
        /**
         * Значение элемента (узла)
         */
        public T value;
    }

    /**
     * Первый элемент (узел) списка
     */
    public Node head;

    /**
     * Поиск элемента в списке по значению
     * @param value значение элемента
     * @return Элемент (узел)
     */
    public Node contains(T value){
        Node node = head;                   // для первой итерации
        while (node != null){               // до тех пор, пока не придем к null, на который ссылается последний элемент
            if (node.value.equals(value)) return node; // сравнивать значение элемента с тем, что из параметра
            node = node.next;               // а это для следующей итерации
        }
        return null;    // если ранее не вышли (ничего не вернули), значит такого элемента нет
    }

    /**
     * Сортировка согласно полученному компаратору
     */
    public void sort(Comparator<T> comparator){
        Node node = head;
        while (node != null){

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null){
                if (comparator.compare(minValueNode.value, node2.value) > 0){
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node){
                T buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }

            node = node.next;
        }
    }

    /**
     * Разворот (реверс) связного списка
     */
    public void reverse(){
        // Движение по списку будет 2мя последующими переменными
        Node current = head;    // текущий элемент
        Node previous = null;   // предыдущий элемент

        while (current != null) {
            Node next = current.next;   // запомнили ссылку на следующий элемент, хранящуюся в текущем
            current.next = previous;    // внутри текущего, поменяли ссылку со следующего элемента на предыдущий
            previous = current;         // следующая итерация для предыдущего элемента
            current = next;             // следующая итерация для текущего элемента
        }

        head = previous; // новый головной элемент (бывший хвостовой)
    }

    /**
     * Добавление нового элемента (узла) в начало списка
     * @param newElement новый элемент
     */
    public void addFirst(T newElement){
        Node node = new Node();                 // создали элемент
        node.value = newElement;                // значение из параметра
        if (head != null) node.next = head;     // присваиваем ссылку на 1ый элемент списка
        head = node;                            // обновляем 1ый элемент
    }

    /**
     * Добавление элемента в конец списка
     * @param value значение
     */
    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
        }
        else{
            Node lastNode = head;
            while (lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }


    /**
     * Удалить первый элемент списка
     */
    public void removeFirst(){
        if (head != null) head = head.next;   // присвоить 1му элементу ссылку на 2ой, которая хранится в нём же
    }

    /**
     * Удалить последний элемент списка
     */
    public void removeLast(){
        if (head == null)
            return;
        Node node = head;
        while (node.next != null){
            if (node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
        head = null;
    }

    /**
     * Печать списка
     * @return подробный список
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node node = head;
        while (node != null){
            stringBuilder.append(node.value);
            stringBuilder.append('\n');
            node = node.next;
        }

        return stringBuilder.toString();
    }
}
