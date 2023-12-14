package gb.study;

import java.util.Iterator;

/**
 * Некая простая аналогия ArrayList с применением обобщений
 * @param <E> тип, с которым будем работать
 */
public class MyList<E> implements Iterable<E>{

    /**
     * Внутренний класс - итератор
     */
    class MyListIterator implements Iterator<E> {
        int index;

        public MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return array[index++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    private Object[] initialArray = {};
    private E[] array;
    private int size;

    public MyList() {
        this.array = (E[]) initialArray;
        size = 0;
    }

    public MyList(E[] baseArray) {
        this.array = baseArray;
        size = array.length;
    }

    /**
     * Добавляет элемент в лист (используется копирование массива)
     * @param element элемент, который необходимо добавить
     * @param <T> тип параметра - ограничен сверху типом <E>
     */
    public <T extends E> void addElement(T element) {
        if (size == array.length) {
            Object[] newArray = new Object[((array.length==0)?1:array.length) * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[size] = element;
            array = (E[]) newArray;
        } else {
            array[size] = element;
        }
        size++;
    }

    /**
     * Удаляет из листа элемент (используется копирование массива)
     * @param index индекс удаляемого элемента
     */
    public void removeElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public int getArrayLength() {
        return array.length;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (E element : array) {
            if (element == null) continue;  // будет выводить без null, что - спорно - не показывает полностью картину
            result.append(element).append(" ");
        }
//        result.append(System.lineSeparator());
        return result.toString();
    }

}