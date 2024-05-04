package lab9;



import java.util.*;

public class Collatz {
    public static void main(String[] args) {
        int maxNumber = 1000000;  // Adjust based on your system capability
        List<CollatzNumber> numbers = new ArrayList<>();
        int num = 1; // Counter for printing the sorted numbers

        // Calculate Collatz sequence length for numbers from 1 to maxNumber
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(new CollatzNumber(i, collatzLength(i))); // Create CollatzNumber objects and add them to the list
        }

        // Convert the list to an array for easier manipulation with Quicksort
        CollatzNumber[] numbersArray = new CollatzNumber[numbers.size()];
        numbersArray = numbers.toArray(numbersArray);
        quickSort(numbersArray, 0, numbersArray.length - 1); // Sort the array using Quicksort

        // Print the first 1000 sorted numbers along with their sequence lengths
        for (int i = 0; i < 1000; i++) {  // Modify this to print as many numbers as you need
            System.out.println(num + ":" + numbersArray[i].number); // Print the number
            num++;
        }
    }

    // Method to calculate the length of the Collatz sequence for a given number
    public static long collatzLength(long n) {
        long length = 1;
        while (n != 1) {
            if (n % 2 == 0) n /= 2; // If the number is even, divide by 2
            else n = 3 * n + 1; // If the number is odd, multiply by 3 and add 1
            length++; // Increment the length of the sequence
        }
        return length; // Return the length of the sequence
    }

    // CollatzNumber class to represent a number along with its Collatz sequence length
    static class CollatzNumber implements Comparable<CollatzNumber> {
        int number;
        long length;

        // Constructor to initialize CollatzNumber objects
        CollatzNumber(int number, long length) {
            this.number = number;
            this.length = length;
        }

        // Override compareTo method to compare CollatzNumber objects based on sequence lengths
        @Override
        public int compareTo(CollatzNumber o) {
            if (this.length == o.length) return Integer.compare(this.number, o.number);
            return Long.compare(this.length, o.length);
        }
    }

    // Quicksort algorithm to sort an array of CollatzNumber objects based on sequence lengths
    public static void quickSort(CollatzNumber[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high); // Partition the array
            quickSort(array, low, pi - 1); // Recursively sort the left partition
            quickSort(array, pi + 1, high); // Recursively sort the right partition
        }
    }

    // Method to partition the array for Quicksort
    private static int partition(CollatzNumber[] array, int low, int high) {
        CollatzNumber pivot = array[high]; // Select the pivot (last element)
        int i = (low - 1); // Index of the smaller element
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) { // If current element is smaller than or equal to the pivot
                i++;
                // Swap array[i] and array[j]
                CollatzNumber temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i+1] and array[high] (pivot)
        CollatzNumber temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1; // Return the partitioning index
    }
}
