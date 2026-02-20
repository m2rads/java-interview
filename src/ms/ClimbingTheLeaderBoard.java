package ms;

import java.util.ArrayList;
import java.util.List;

public class ClimbingTheLeaderBoard {

    public static int findInsertPosition(List<Integer> scores, int newScore) {
        int left = 0;
        int right = scores.size();

        // middle


        while (right > left) {
            int mid = (right + left) / 2;
            if (scores.get(mid) > newScore) {
                left = mid + 1;

            } else {
                right = mid;
            }
        }

        return left;
    } // O(log n)

    public static List<Integer> climbingLeaderboardExample(List<Integer> ranked, List<Integer> player) {
        // Binary Search O(log n)
        // dense ranking - duplicates
        // unique scores
        List<Integer> uniqueScores = new ArrayList<>();
        uniqueScores.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                uniqueScores.add(ranked.get(i));
            }
        }

        List<Integer> playersRankAfterEachGame = new ArrayList<>();

        for (int playerScore: player) {
            int position = binarySearch(uniqueScores, playerScore);
            int rank = position + 1;
            playersRankAfterEachGame.add(rank);
        }

        return playersRankAfterEachGame;
    }

    private static int binarySearch(List<Integer> uniqueScores, int playerScore) {
        int left = 0;
        int right = uniqueScores.size();

        while (left < right){
            int mid = (right + left) / 2;

            if (uniqueScores.get(mid) > playerScore) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(findInsertPosition(List.of(100, 90, 90, 80, 20, 10), 85)); // should return 3
    }

}
