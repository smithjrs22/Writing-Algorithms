// Java implementation of Counting Sort
class CountingSort {
    //sort method will take parameter and sort
    public void sort(char arr[])
    {
        int n = arr.length;

        // 1. The output character array that will have sorted arr
        //choosing char over String this time
        char output[] = new char[n];

        // 2. Create a count array to store count of individual
        // characters and initialize count array as 0
        int countArr[] = new int[256];
        for (int i = 0; i < 256; ++i)
            countArr[i] = 0;

        // 3. store count of each character
        for (int i = 0; i < n; ++i)
            ++countArr[arr[i]];

        // 4. Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; ++i)
            countArr[i] += countArr[i - 1];

        // 5. Create output character array
        // Put the array in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[countArr[arr[i]] - 1] = arr[i];
            --countArr[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }

    // main method
    public static void main(String args[])
    {
        CountingSort object = new CountingSort();
        char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };

        object.sort(arr);

        System.out.print("In lexicographical order, string will be ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i]);
    }
}