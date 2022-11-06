

public class AIPlayer extends Player {

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    

    public void makeMove(Board board) {

         board.AIMove(symbol);
         
        ;}
    }
