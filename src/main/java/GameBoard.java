import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
    private int[][] board;

    public GameBoard(int x, int y) {
        board = new int[x][y];
        initializeBoard();
    }

    public GameBoard(int[][] board){
        this.board = board;
    }

    public int getNeighborCount(int x, int y){
        return accessCell(x-1,y-1) +
                accessCell(x-1,y) +
                accessCell(x-1,y+1) +
                accessCell(x,y-1) +
                accessCell(x,y+1) +
                accessCell(x+1,y-1) +
                accessCell(x+1,y+1) +
                accessCell(x+1,y);
    }

    private int accessCell(int x, int y){
        try {
            return board[x][y];
        } catch (ArrayIndexOutOfBoundsException ex){
            return 0;
        }
    }

    private int[][] initializeBoard() {
        for (int i = 0; i<board.length; i++){
            for (int j = 0; j<board[i].length; j++){
                board[i][j] = ThreadLocalRandom.current().nextInt(0, 1 + 1);
            }
        }
        return board;
    }
}
