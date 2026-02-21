package bby.data.structures;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        Snake larry = new Snake();
        larry.draw();
    }



}
