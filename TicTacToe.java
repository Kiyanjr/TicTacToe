import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\tLets play Tic tac toe");
    char[][] board = {
      { '_', '_', '_' },
      { '_', '_', '_' },
      { '_', '_', '_' },
    };
    printBoard(board);
    //max number of turns is 9
    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn: X");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'X';
      } else {
        System.out.println("Turn: O");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'O';
      }
      printBoard(board);

      int count = checkWin(board);
      if (count == 3) {
        System.out.println("\nX wins!");
        break;
      } else if (count == -3) {
        System.out.println("O win!");
        break;
      } else if (i == 8) {
        System.out.println("Its a tie");
      }
    }

    scan.close();
  }

  public static void printBoard(char[][] board) {
    System.out.println("\n");
    for (int i = 0; i < board.length; i++) {
      System.out.println("\t");
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
    }
    System.out.println("\n\n");
  } //player to choose a spot function

  public static int[] askUser(char[][] board) {
    System.out.print(".Pick a row and column number: ");
    int row = scan.nextInt();
    int element = scan.nextInt();
    while (board[row][element] == 'X' || board[row][element] == 'O') {
      System.out.print("Spot taken!,try again: ");
      row = scan.nextInt();
      element = scan.nextInt();
    }
    return new int[] { row, element }; // returning what usere choses
  }

  public static int checkWin(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        //cheking row
        if (board[i][j] == 'X') {
          count++;
        } else if (board[i][j] == 'O') {
          count--;
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }
    // checking element
    for (int i = 0; i < 3; i++) { // smaller then 3 so the i is fixed and j gonna be counted
      for (int j = 0; j < board.length; j++) {
        if (board[j][i] == 'X') {
          count++;
        } else if (board[j][i] == 'O') {
          count--;
        }
      }

      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }
    //checking left wing
    for (int i = 0; i < 3; i++) {
      if (board[i][i] == 'X') {
        count++;
      } else if (board[i][i] == 'O') {
        count--;
      }
    }
    if (count == 3 || count == -3) {
      return count;
    } else {
      count = 0;
    }

    // right wing
    for (int i = 0; i < 3; i++) {
      int rowIndex = 2 - i;
      if (board[rowIndex][i] == 'X') {
        count++;
      } else if (board[rowIndex][i] == 'O') {
        count--;
      }
    }

    return count;
  }
}
