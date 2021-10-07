import java.util.Random;

public abstract class RandomSquare {

    public static void run(int width, int height, int x, int y) {
        if (x < 0 || y < 0 || width <= x || height <= y ) {
            System.out.println("Invalid Input");
        } else {
            Random rng = new Random();
            int[][] square = new int[width][height];
            System.out.println("Wygląd początkowy tablicy:");
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    square[i][j] = rng.nextInt(9) + 1;
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Wygląd tablicy po rozsunięciu elementów i wstawieniu 0 na pozycji " + x + ":" + y);
            //from left
            for (int i = 0; i < x; i++) {
                square[i][y] = square[i+1][y];
            }
            //from right
            for (int i = width-1; i > x; i--) {
                square[i][y] = square[i-1][y];
            }
            //from bottom
            for (int i = 0; i < y; i++) {
                square[x][i] = square[x][i+1];
            }
            //from top
            for (int i = height-1; i > y; i--){
                square[x][i] = square[x][i-1];
            }
            square[x][y] = 0;
            //Rendering Square
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
