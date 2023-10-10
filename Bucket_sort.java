//Bucket Sort 
public class CountingSort {

    public static void countingSort(int[] array) {
        int max = findMax(array);
        int min = findMin(array);

        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[array.length];

        // Count occurrences of each element
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        // Modify the count array to store the sum of previous counts
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, array, 0, array.length);
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 5, 9, 3, 8, 6};
        
        System.out.println("Original array:");
        printArray(array);

        countingSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }
}
