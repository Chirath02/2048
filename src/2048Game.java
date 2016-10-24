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
      move_right();
    }
    else if(input == 'a') {
      move_left();
    }
    else if(input == 'w') {
      move_up();
    }
    else if(input == 's') {
      move_down();
    }
    initialize(1);
  }

  public void move_right() {
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

    for(int i = 0; i < gameSize; ++i)
      for(int j = 0; j < gameSize-1; ++j)
        if(tiles[i][j+1] == 0)
          tiles[i][j+1] = tiles[i][j];
  }

  public void move_up() {
    for(int i = 3; i > 0; --i) {
      for(int j = 0; j < gameSize; ++j) {
        if(tiles[i][j]!=0) {
          if(tiles[i-1][j] == tiles[i][j]) {
            tiles[i-1][j] += tiles[i][j];
            tiles[i][j] = 0;
          }
          else if(tiles[i-1][j]==0) {
            tiles[i-1][j] = tiles[i][j];
            tiles[i][j]=0;
          }
        }
      }
    }

    for(int i = 3; i > 0; i--)
      for(int j = 0; j < gameSize-1; ++j)
        if(tiles[i-1][j] == 0)
          tiles[i-1][j] = tiles[i][j];
  }

  public void move_down() {
    for(int j = 0; j < gameSize; ++j) {
      for(int i = 0; i < gameSize-1; ++i) {
        if(tiles[i][j]!=0) {
          if(tiles[i+1][j] == tiles[i][j]) {
            tiles[i+1][j] += tiles[i][j];
            tiles[i][j] = 0;
          }
          else if(tiles[i+1][j]==0) {
            tiles[i+1][j] = tiles[i][j];
            tiles[i][j]=0;
          }
        }
      }
    }

    for(int j = 0; j < gameSize; ++j)
      for(int i = 0; i < gameSize-1; ++i)
        if(tiles[i+1][j] == 0)
          tiles[i+1][j] = tiles[i][j];
  }

  public void move_left() {

    for(int i = 3; i >= 0; i--) {
      for(int j = 3; j >= 1; j--) {
        if(tiles[i][j]!=0) {
          if(tiles[i][j-1] == tiles[i][j]) {
            tiles[i][j-1] += tiles[i][j];
            tiles[i][j] = 0;
          }
          else if(tiles[i][j-1]==0) {
            tiles[i][j-1] = tiles[i][j];
            tiles[i][j]=0;
          }
          //System.out.println(1);
        }
      }
    }

    for(int i = 3; i >= 0; i--)
      for(int j = 3; j >= 1; j--)
        if(tiles[i][j-1] == 0)
          tiles[i][j-1] = tiles[i][j];
  }

  public boolean canMoves() {
    return true;
  }

  public void startGame() {
    Scanner scanner = new Scanner(System.in);
    printTiles();
      while(true) {
        System.out.print("->");
        char input = (char) scanner.next().charAt(0);
        move(input);
        if(canMoves() == false) {
          System.out.println("You are out of moves! Game Over!!!");
          break;
        }

      }
  }



  public static void main(String[] args) {
    Game2048 game = new Game2048();
    game.initialize(2);
    game.startGame();
  }
}
