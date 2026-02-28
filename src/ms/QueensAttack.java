package ms;

public class QueensAttack {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Convert obstacles to a Set for O(1) lookup
        Set<String> obstacleSet = new HashSet<>();
        for (List<Integer> obs : obstacles) {
            obstacleSet.add(obs.get(0) + "," + obs.get(1));
        }

        int totalSquares = 0;

        // 8 directions: [row_change, col_change]
        int[][] directions = {
                {-1, 0},   // up
                {1, 0},    // down
                {0, -1},   // left
                {0, 1},    // right
                {-1, -1},  // up-left diagonal
                {-1, 1},   // up-right diagonal
                {1, -1},   // down-left diagonal
                {1, 1}     // down-right diagonal
        };

        // Check each direction
        for (int[] dir : directions) {
            int dr = dir[0];  // row change
            int dc = dir[1];  // col change

            int currentRow = r_q + dr;
            int currentCol = c_q + dc;

            // Keep moving in this direction until we hit edge or obstacle
            while (currentRow >= 1 && currentRow <= n &&
                    currentCol >= 1 && currentCol <= n) {

                // Check if there's an obstacle here
                if (obstacleSet.contains(currentRow + "," + currentCol)) {
                    break;  // Stop in this direction
                }

                totalSquares++;  // Count this square

                // Move to next square in same direction
                currentRow += dr;
                currentCol += dc;
            }
        }

        return totalSquares;
    }

}
