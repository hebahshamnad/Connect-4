

public class ComputerPlayer extends Player {

    public ComputerPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    

    public void makeMove(Board board) {

         board.ComputerMove(symbol);
         
        ;}
    }
