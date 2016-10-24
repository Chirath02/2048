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
    printTiles();
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
    if(input == 'd') {

      for(int i = 0; i < gameSize; ++i) {
        for(int j = 0; j < gameSize-1; ++j) {
          if(tiles[i][j]!=0) {
            if(tiles[i][j+1] == tiles[i][j]) {
              tiles[i][j+1] += tiles[i][j];
              tiles[i][j] = 0;
            }
            else if(tiles[i][j+1]==0) {
              tiles[i][j+1] = tiles[i][j];
              tiles[i][j]=0;
            }
          }
        }
    }

    for(int i = 0; i < gameSize; ++i) {
      for(int j = 0; j < gameSize-1; ++j) {
        if(tiles[i][j+1] == 0 && tiles[i][j]!=0) {
          tiles[i][j+1] = tiles[i][j+1]; 
        }
      }
    }

  }

    initialize(1);
  }

  public boolean canMoves() {
    return false;
  }

  public void startGame() {
    Scanner scanner = new Scanner(System.in);
      while(true) {
        System.out.print("->");
        char input = (char) scanner.next().charAt(0);
        move(input);
        if(canMoves() == false) {
          System.out.println("You are out of moves! Game Over!!!");
          break;
        }
        printTiles();
      }
  }



  public static void main(String[] args) {
    Game2048 game = new Game2048();
    game.initialize(2);
    game.startGame();
  }
}
