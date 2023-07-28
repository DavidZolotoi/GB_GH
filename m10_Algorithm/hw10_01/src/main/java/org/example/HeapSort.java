package org.example;

public class HeapSort {

    /**
     * Сортирует массив, принятый в аргументе
     * @param array массив для сортировки
     */
    public static void sort(int[] array) {
        // Построение кучи (перегруппируем массив)
        for (int i = array.length/2-1; i >= 0; i--)
            heapify(array, array.length, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--)	{
            // Перемещаем текущий корень в конец
            int temp = array[0]; array[0] = array[i]; array[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0) ;
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftchild = 2 * rootIndex + 1; // левый - 2*rootIndex + 1
        int rightchild = 2 * rootIndex + 2; // правый = 2*rootIndex + 2

        // Если левый дочерний элемент больше корня
        if (leftchild < heapSize && array[leftchild] > array[largest])
            largest = leftchild;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightchild < heapSize && array[rightchild] > array[largest])
            largest = rightchild;

        // Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
