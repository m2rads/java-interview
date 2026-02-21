package bby.data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Snake {

    List<List<Integer>> snakeBody;
    public Snake() {
        this.snakeBody = new ArrayList<>(Arrays.asList(
                Arrays.asList(4,1),
                Arrays.asList(4,2),
                Arrays.asList(4,3),
                Arrays.asList(4,4)
        ));
    }

    public void draw() {
        List<List<String>> grid = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                row.add(" ");
            }
            grid.add(row);
        }

        this.snakeBody.forEach(pos -> {
            int row = pos.get(0);
            int col = pos.get(1);
            grid.get(row).set(col, "0");
        });

        grid.forEach(row -> System.out.println(String.join("|", row)));
    }

    public void move(String direction) {
        HashMap<String, List<Integer>> delta = new HashMap<>();
        delta.put("UP", Arrays.asList(-1, 0));
        delta.put("DOWN", Arrays.asList(1, 0));
        delta.put("LEFT", Arrays.asList(0, -1));
        delta.put("RIGHT", Arrays.asList(0, 1));

        List<Integer> currentHead = this.snakeBody.get(this.snakeBody.size() - 1);
        int row = currentHead.get(0);
        int col = currentHead.get(1);

        List<Integer> dir = delta.get(direction);
        int changeRow = dir.get(0);
        int changeCol = dir.get(1);

        List<Integer> newHead = new ArrayList<>(Arrays.asList(
                row + changeRow, col + changeCol
        ));

        this.snakeBody.add(newHead);
        this.snakeBody.remove(0);

    }

    public static void main(String[] args) {
        Snake larry = new Snake();
        larry.draw();

        larry.move("UP");
        larry.draw();
        larry.move("RIGHT");
        larry.draw();
    }



}
