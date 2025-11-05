package bby.algorithms.challenges;

import java.util.Arrays;

public class MovingMedian {

    /**
    Have the function MovingMedian(arr) read the array of numbers stored in arr which will contain a sliding window size, N, as the first element in the array and the rest will be a list of numbers. Your program should return the Moving Median for each element based on the element and its N-1 predecessors, where N is the sliding window size. The final output should be a string with the moving median corresponding to each entry in the original array separated by commas.
    Note that for the first few elements (until the window size is reached), the median is computed on a smaller number of entries. For example: if arr is [3, 1, 3, 5, 10, 6, 4, 3, 1] then your program should output "1,2,3,5,6,6,4,3"
    */
    public static String movingMedian(int[] arr) {
        int windowSize = arr[0];
        StringBuilder result = new StringBuilder();

        // Process each element starting from index 1
        for (int i = 1; i < arr.length; i++) {
            // Determine the start of the window
            int start = Math.max(1, i - windowSize + 1);
            int windowLength = i - start + 1;

            // Copy elements in the current window
            int[] window = new int[windowLength];
            for (int j = 0; j < windowLength; j++) {
                window[j] = arr[start + j];
            }

            // Sort the window to find median
            Arrays.sort(window);

            // Calculate median
            double median;
            if (windowLength % 2 == 1) {
                // Odd: take middle element
                median = window[windowLength / 2];
            } else {
                // Even: average of two middle elements
                median = (window[windowLength / 2 - 1] + window[windowLength / 2]) / 2.0;
            }

            // Format median (remove .0 if integer)
            if (median == (int) median) {
                result.append((int) median);
            } else {
                result.append(median);
            }

            // Add comma separator (except for last element)
            if (i < arr.length - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }

    public static void main (String[] args) {

    }
}
