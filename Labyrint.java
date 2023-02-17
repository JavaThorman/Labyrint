import java.util.Scanner;
public class Labyrint {

    public static void main(String[] args) {
        char[][] maze = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', 'O', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

        int playerX = 1;
        int playerY = 1;

        Scanner input = new Scanner(System.in);

        while (true) {
            // Print the maze
            for (int y = 0; y < maze.length; y++) {
                for (int x = 0; x < maze[y].length; x++) {
                    if (x == playerX && y == playerY) {
                        System.out.print('P');
                    } else {
                        System.out.print(maze[y][x]);
                    }
                }
                System.out.println();
            }

            // Get the player's move
            System.out.print("Enter your move (N/S/E/W): ");
            String move = input.nextLine();

            // Update the player's position
            switch (move) {
                case "N" -> {
                    if (maze[playerY - 1][playerX] != '#') {
                        playerY--;
                    }
                }
                case "S" -> {
                    if (maze[playerY + 1][playerX] != '#') {
                        playerY++;
                    }
                }
                case "E" -> {
                    if (maze[playerY][playerX + 1] != '#') {
                        playerX++;
                    }
                }
                case "W" -> {
                    if (maze[playerY][playerX - 1] != '#') {
                        playerX--;
                    }
                }
            }

            // Check if the player has reached the end
            if (playerX == 8 && playerY == 5) {
                System.out.println("Congratulations, you've escaped the maze!");
                break;
            }
        }

        input.close();
    }
}