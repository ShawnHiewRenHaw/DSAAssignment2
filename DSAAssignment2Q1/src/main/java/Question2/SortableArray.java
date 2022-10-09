/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question2;

/**
 *
 * @author shawn
 */
public class SortableArray<E extends Comparable> {

    E[] array;

    public void setArray(E[] array) {
        this.array = array;
    }

    public void quickSort() {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(E arr[], int begin, int end) {
        if (begin < end) {
            int index = partition(arr, begin, end);

            quickSort(arr, begin, index - 1);
            quickSort(arr, index + 1, end);
        }
    }

    public int partition(E[] arr, int low, int high) {
        int p = low, j;
        for (j = low + 1; j <= high; j++) {
            if (arr[j].compareTo(arr[low]) < 0) {
                swap(arr, ++p, j);
            }
        }

        swap(arr, low, p);
        return p;
    }

    public void swap(E[] arr, int low, int pivot) {
        E tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }
}
