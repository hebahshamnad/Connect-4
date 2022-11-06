
//For HumanPlayer, the makeMove method should prompt the user for input. You can
// assume the user will always input a number between 1 and 7 inclusive. However, if the
// user inputs an invalid move, i.e. that column is full, you should reprompt the user for a
// valid input.

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    public char getSymbol() {
		return symbol;
	}
	

    public void makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a column: ");
        int num = sc.nextInt();

        while (board.isColFull(num)==true) {

            System.out.println("Enter a column: ");
            num = sc.nextInt();
        }
        
        if (board.isColFull(num)==false){
            board.addPiece(getSymbol(),num);
        }
        
    }

}

// public void makeMove () {

// Scanner sc= new Scanner(System.in);
// int num= sc.nextInt();

// while (board[0][num-1] != ' '){

// System.out.println("Enter a column: ");
// num= sc.nextInt();
// }

// for(int r = 6-1; r>=0; r --){
// if (board[r][num-1]==' '){
// board[r][num-1]='0';
// break;}
// else {;}}

// }

// }}
