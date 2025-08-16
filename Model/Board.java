package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece) {
        if (board[row][column] != null) {
            return false;
        }

        board[row][column] = playingPiece;
        return true;
    }

    public List<AbstractMap.SimpleEntry<Integer, Integer>> getFreeCells() {
        // using AbstractMap.SimpleEntry instead of Pair
        List<AbstractMap.SimpleEntry<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    AbstractMap.SimpleEntry<Integer, Integer> rolColumn = new AbstractMap.SimpleEntry<>(i, j);
                    freeCells.add(rolColumn);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
