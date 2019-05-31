import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameBoardTest {

    @Test
    public void gameBoardTest() {
        GameBoard board = new GameBoard(3,3);
    }

    @Test
    public void getNeighborCountReturns8OnFull3x3BoardForMiddleCell(){
        int[][] fullBoard = new int[][] {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        GameBoard board = new GameBoard(fullBoard);
        int neighborCount = board.getNeighborCount(1, 1);
        int expectedNeighborCount = 8;
        assertThat(neighborCount,equalTo(expectedNeighborCount));
    }

    @Test
    public void getNeighborCountReturns3OnFull3x3BoardForEdgeCell(){
        int[][] fullBoard = new int[][] {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        GameBoard board = new GameBoard(fullBoard);
        int neighborCount = board.getNeighborCount(0, 0);
        int expectedNeighborCount = 3;
        assertThat(neighborCount,equalTo(expectedNeighborCount));
    }
}
