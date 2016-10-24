import java.io.*;
import java.util.*;

class Game2048 {
  int gameSize = 4;
  int initialNumberofTiles = 2, initialTileValue = 2;
  int tiles[][] = new int[gameSize][gameSize];
  int max = gameSize-1, min = 0;
  Random rand = new Random();
  Scanner scanner = new Scanner(System.in);

  public void initialize(int number) {
    for(int i =0; i < number;) {
      int x = rand.nextInt((max - min) + 1) + min;
      int y = rand.nextInt((max - min) + 1) + min;
      if(tiles[x][y] == 0) {
        i++;
        tiles[x][y] = initialTileValue;
      }
    }
    System.out.println("a - left, w - up, d - right, s - down");
    game.printTiles();
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

  public void move(char input) {
    for(int i = 0; i < gameSize; ++i) {
      for(int j = 0; j < gameSize; ++j) {
      }
    }

    initialize(1);
  }

  public void move(char input) {
    
  }

  public boolean canMoves() {
    return false;
  }

  public void startGame() {
      while(1) {
        System.out.print("->");
        char input = scanner.nextChar();
        move(input);
        if(canMoves() == false) {
          System.out.println("You are out of moves! Game Over!!!");
          break;
        }
        game.printTiles();
      }
  }



  public static void main(String[] args) {
    Game2048 game = new Game2048();
    game.initialize(2);
    game.startGame();
  }
}
