package ms;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockAnagram {

    // exercise before sherlock and anagrams
    public static int countAnagramPairs(String s) {
        int count = 0;
        HashMap<String, Integer> substringFrequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);

                char[] charSubstring = substring.toCharArray();
                Arrays.sort(charSubstring);
                String sortedSubstring = new String(charSubstring);

                substringFrequency.put(sortedSubstring, substringFrequency.getOrDefault(sortedSubstring, 0) + 1);
                count += substringFrequency.get(sortedSubstring) - 1;
            }
        }

        return count;
    }



    public static void main(String[] args) {
        String s = "silence";
        System.out.println(countAnagramPairs(s));
    }
}
