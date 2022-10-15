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

    //Sets an array
    public void setArray(E[] array) {
        this.array = array;
    }

    //Calls quickSort function with inputs
    public void quickSort() {
        quickSort(array, 0, array.length - 1);
    }

    //QuickSort function that if the first item is smaller than the last item calls partition function
    public void quickSort(E arr[], int begin, int end) {
        if (begin < end) {
            int index = partition(arr, begin, end);

            //Sorts for the beginning to index-1
            quickSort(arr, begin, index - 1);
            //Sorts for p+1 to the end
            quickSort(arr, index + 1, end);
        }
    }

    //Function that sort through the array and calls the swap function
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

    //Executes swapping of items in the array
    public void swap(E[] arr, int low, int pivot) {
        E tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }
}
