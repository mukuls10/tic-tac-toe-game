import java.util.AbstractMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Model.Player;
import Model.PlayingPieceX;
import Model.PlayingPieceO;
import Model.Board;
import Model.PieceType;

//Miro LLD Diagram: https://miro.com/app/board/uXjVJTEjfyw=/?share_link_id=564693540936
public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame() {
        initializeGame();
    }

    public void initializeGame() {
        // create 2 players
        players = new LinkedList<>();

        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player 1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player 2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        // initialise Board
        this.gameBoard = new Board(3);
    }

    // main logic of the game
    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {

            // take out the player whose turn in and also put the player in the list back
            Player playerTurn = players.removeFirst();

            // get the freeSpace from the board
            gameBoard.printBoard();

            List<AbstractMap.SimpleEntry<Integer, Integer>> freeCells = gameBoard.getFreeCells();

            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }

            // read the user input
            System.out.print("Player: " + playerTurn.name + " Enter row, column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            // place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if (!pieceAddedSuccessfully) {
                // player cant insert the position in the input cell, give another chance
                // another chance => insert first in queue + continue in the loop
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            // check if game is over
            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if (winner) {
                inputScanner.close();
                return playerTurn.name;
            }
        }

        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // check for row match
        for (int j = 0; j < gameBoard.size; j++) {
            if (gameBoard.board[row][j] == null || gameBoard.board[row][j].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        // check for column match
        for (int i = 0; i < gameBoard.size; i++) {
            if (gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                colMatch = false;
            }
        }

        // check for diagonal match
        for (int j = 0; j < gameBoard.size; j++) {
            if (gameBoard.board[j][j] == null || gameBoard.board[j][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        // check for anti diagonal match
        for (int j = 0; j < gameBoard.size; j++) {
            if (gameBoard.board[j][gameBoard.size - j - 1] == null
                    || gameBoard.board[j][gameBoard.size - j - 1].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
