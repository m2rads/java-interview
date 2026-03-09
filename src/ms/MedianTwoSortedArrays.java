package ms;

import java.util.*;

public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList<>();

        for (int num : nums1) {
            merged.add(num);
        }
        for (int num : nums2) {
            merged.add(num);
        }

        Collections.sort(merged);

        int size = merged.size();

        if (size % 2 == 0) {
            int mid = size / 2;
            return (merged.get(mid - 1) + merged.get(mid)) / 2.0;
        }

        return merged.get(size / 2);
    }

    public static void main(String[] args) {
        int[] num1 = {1, 3};
        int[] num2 = {2, 2, 4};

        double result = findMedianSortedArrays(num1, num2);

        System.out.println(result);
    }
}
