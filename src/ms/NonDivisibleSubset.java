package ms;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderCount = new int[k];
        for (int num : s) {
            remainderCount[num % k]++;
        }

        int result = 0;

        result += Math.min(remainderCount[0], 1);

        // Step 3: Handle pairs of conflicting remainders
        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                result += Math.min(remainderCount[i], 1);
            } else {
                result += Math.max(remainderCount[i], remainderCount[k - i]);
            }
        }

        return result;
    }
}
