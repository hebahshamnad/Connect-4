public class Main {
    public static void main(String[] args) {
        // Create a new instance of the Board
        Board board = new Board();

        // Create two players
        Player player1 = new HumanPlayer('X', board, "Player 1");
        Player player2 = new AIPlayer('O', board, "Player 2");

        // Create a new instance of ConnectFour
        ConnectFour game = new ConnectFour(board);

        // Set the players for the game
        game.setPlayer1(player1);
        game.setPlayer2(player2);

        // Play the game
        game.playGame();
    }
}

//javac Main.java
//java main