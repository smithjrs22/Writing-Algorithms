
import java.util.*;

class QuickSort {

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* main function that implements QuickSort()
    arr[] is Array to be sorted,
    low is Starting index,
    high is Ending index */
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high) {
            // partitionIndex is partitioning index, arr[partitionIndex] is now at right place
            int partitionIndex = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Driver code
    public static void main(String args[])
    {

        int n = 9;
        int arr[] = {  2, 1, 6, 10, 4, 1, 3, 9, 7 };

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
