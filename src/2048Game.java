import java.io.*;
import java.util.*;

class Game2048 {
  int gameSize = 4;
  int initialNumberofTiles = 2, initialTileValue = 2;
  int tiles[][] = new int[gameSize][gameSize];
  int max = gameSize-1, min = 0;
  Random rand = new Random();
  Scanner scanner = new Scanner(Syatem.in);

  public void initialize(int number) {
    for(int i =0; i < number;) {
      int x = rand.nextInt((max - min) + 1) + min;
      int y = rand.nextInt((max - min) + 1) + min;
      if(tiles[x][y] == 0) {
        i++;
        tiles[x][y] = initialTileValue;
      }
    }
  }

  public void printTiles() {
    System.out.println();
    for(int i = 0; i < gameSize; ++i) {
      System.out.print("| ");
      for(int j = 0; j < gameSize; ++j) {
        System.out.print(tiles[i][j] + "| ");
      }
      System.out.println();
    }
  }

  public startGame() {

  }


  public static void main(String[] args) {
    Game2048 game = new Game2048();
    game.initialize(initialTileValue);

    game.printTiles();
  }
}
