package org.example;

public class Main {
    public static void main(String[] args) {
        int[] array = {9,1,8,2,7,3,6,4,5};
        HeapSort.sort(array);
        for (var tmp : array) System.out.println(tmp);
    }
}