import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class GameOfLife {
    private int[][] board;

    public GameOfLife(int x, int y) {
        board = new int[x][y];
        initializeBoard();
    }

    public GameOfLife(int[][] board) {
        this.board = board;
    }

    public int[][] evolveBoard(int[][] board) {
        return evolveBoard(board, 1, false);
    }

    public int[][] evolveBoard(int[][] board, int evolveSteps, boolean visualization) {
        for (int i = 0; i <= evolveSteps; i++) {
            int[][] evolvedBoard = board.clone();
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    evolvedBoard[x][y] = mapToNumber(mapToCell(board[x][y]).evolve(getNeighborCount(x, y)));
                    if (visualization) visualizeBoard(evolvedBoard);
                }
            }
            board = evolvedBoard;
        }
        return board;
    }

    public void visualizeBoard(int[][] board) {
        for (int[] x : board) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public int getNeighborCount(int x, int y) {
        return accessCell(x - 1, y - 1) +
                accessCell(x - 1, y) +
                accessCell(x - 1, y + 1) +
                accessCell(x, y - 1) +
                accessCell(x, y + 1) +
                accessCell(x + 1, y - 1) +
                accessCell(x + 1, y + 1) +
                accessCell(x + 1, y);
    }

    private Cell mapToCell(int number) {
        if (number == 1) return new AliveCell();
        else return new DeadCell();
    }

    private int mapToNumber(Cell cell) {
        if (cell instanceof AliveCell) return 1;
        else return 0;
    }

    private int accessCell(int x, int y) {
        try {
            return board[x][y];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return 0;
        }
    }

    private int[][] initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            }
        }
        return board;
    }
}
