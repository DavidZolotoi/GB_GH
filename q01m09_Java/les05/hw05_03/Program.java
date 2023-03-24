/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */
package q01m09_Java.les05.hw05_03;
public class Program
{
        public static void main(String args[])
        {
            int arr[] = {12, 11, 13, 5, 6, 7};
    
            HeapSort hs = new HeapSort();
            hs.sort(arr);
    
            System.out.println("Sorted array is");
            HeapSort.printArray(arr);
        }
}
