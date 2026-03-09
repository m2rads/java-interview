package ms;

import java.util.ArrayList;
import java.util.List;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // return shortest transformation sequences or and empty list
        // for each transformation only one word can be different
        // base case -> endWord must be in wordList

        // return shortest transformation sequences or and empty list
        // for each transformation only one word can be different

        List<List<String>> shortestTransformation = new ArrayList<>();

        if (!wordList.contains(endWord)) {
            return shortestTransformation;
        }

        // loop the wordList
        // loop -> chars
        // endWord.length == beginWord.length && wordList[i].length == beginWord.length
        // i = 1? i = 2? i = 3? yes, i = 4? if yes, break;
        // keep track of different word counts
        // if (wordList[i] == endWord) ??
        // List<String> transformation;
        // shortestTransformation.add(transformation);
        List<String> transformation = new ArrayList<>();
        for (String word : wordList) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (beginWord.charAt(i) != word.charAt(i)) {
                    count++;
                }
            }
            if (count == 1) {
                transformation.add(word);
            }

            if (word.equals(endWord)) {
                shortestTransformation.add(transformation);
                transformation = new ArrayList<>();
            }
        }

        return shortestTransformation;




    }
}
