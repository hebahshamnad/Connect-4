

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
