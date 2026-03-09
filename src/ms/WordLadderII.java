package ms;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return result;
        }

        // Map: word -> list of parents (words that lead to it)
        Map<String, List<String>> parents = new HashMap<>();

        // BFS to build parent graph
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Try all possible transformations
                for (String neighbor : getNeighbors(word, dict)) {
                    if (neighbor.equals(endWord)) {
                        found = true;
                    }

                    if (!visited.contains(neighbor)) {
                        levelVisited.add(neighbor);
                        queue.offer(neighbor);

                        // Add parent
                        parents.putIfAbsent(neighbor, new ArrayList<>());
                        parents.get(neighbor).add(word);
                    } else if (levelVisited.contains(neighbor)) {
                        // Same level - add as parent
                        parents.get(neighbor).add(word);
                    }
                }
            }

            visited.addAll(levelVisited);
        }

        if (!found) {
            return result;
        }

        // Backtrack to build all paths
        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parents, path, result);

        return result;
    }

    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> parents,
                           List<String> path, List<List<String>> result) {
        if (word.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            result.add(copy);
            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;

                chars[i] = c;
                String newWord = new String(chars);

                if (dict.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }

            chars[i] = original;
        }

        return neighbors;
    }
}
