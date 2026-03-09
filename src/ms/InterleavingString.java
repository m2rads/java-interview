package ms;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return helper(s1, s2, s3, 0, 0, 0);
    }

    private boolean helper(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }

        boolean result = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = helper(s1, s2, s3, i+1, j, k+1);
        }

        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = helper(s1, s2, s3, i, j+1, k+1);
        }

        return result;

    }
}
