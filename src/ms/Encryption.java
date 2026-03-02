package ms;

import java.util.ArrayList;
import java.util.List;

public class Encryption {
    public static String encryption(String s) {
        // Write your code here
        List<List<Character>> sGrid = new ArrayList<>();
        String noSpace= s.replace(" ", "");
        int length = noSpace.length();

        int sRow = (int) Math.floor(Math.sqrt(length));
        int sCol = (int) Math.ceil(Math.sqrt(length));

        if (sRow * sCol < length) {
            sRow++;
        }


        int index = 0;
        // develop the grid
        for (int row = 0; row < sRow; row++) {
            List<Character> temp = new ArrayList<>();
            for (int col = 0; col < sCol; col++) {
                if (index < length) {
                    temp.add(noSpace.charAt(index));
                    index++;
                }
            }
            sGrid.add(temp);
        }

        StringBuffer encryptedString = new StringBuffer();

        for (int col = 0; col < sCol; col++) {
            for (int row = 0; row < sRow; row++) {
                if (row < sGrid.size() && col < sGrid.get(row).size()) {
                    encryptedString.append(sGrid.get(row).get(col));
                }
            }
            if (col < sCol - 1) {  // Don't add space after last column
                encryptedString.append(' ');
            }
        }

        return encryptedString.toString();
    }
}
