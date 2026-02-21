package bby.algorithms.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Snake {

    List<List<Integer>> snakeBody;
    boolean gameRunning;

    public Snake() {
        this.snakeBody = new ArrayList<>(Arrays.asList(
                Arrays.asList(4,1),
                Arrays.asList(4,2),
                Arrays.asList(4,3),
                Arrays.asList(4,4)
        ));

        this.gameRunning = true;
    }

    public void draw() {
        this.clearScreen();

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

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void play() throws IOException, InterruptedException {
        // Set up terminal for raw mode (Unix/Mac/Linux)
        String[] cmd = {"/bin/sh", "-c", "stty raw -echo < /dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Use WASD to move. Press Q to quit.");
        Thread.sleep(2000);

        new Thread(() -> {
            try {
                while (gameRunning) {
                    draw();
                    Thread.sleep(100);  // Frame rate
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (gameRunning) {
            if (reader.ready()) {
                char keypress = (char) reader.read();

                if (keypress == 'w') this.move("UP");
                else if (keypress == 'a') this.move("LEFT");
                else if (keypress == 's') this.move("DOWN");
                else if (keypress == 'd') this.move("RIGHT");
                else if (keypress == 'q') {
                    gameRunning = false;
                    break;
                }
            }
        }

        // Restore terminal
        String[] restore = {"/bin/sh", "-c", "stty sane < /dev/tty"};
        Runtime.getRuntime().exec(restore).waitFor();

        System.out.println("\nGame Over!");
    }


    public static void main(String[] args) {
        try {
            Snake larry = new Snake();
            larry.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
