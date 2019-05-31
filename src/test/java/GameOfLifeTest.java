import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    @Test
    public void gameBoardTest() {
        int[][] gameBoard = new int[][] {
                {1,1,1},
                {0,0,1},
                {0,0,0}
        };

        GameOfLife gol = new GameOfLife(gameBoard);
        int[][] evolvedBoard = gol.evolveBoard(gameBoard);
        gol.visualizeBoard(evolvedBoard);

    }

    @Test
    public void getNeighborCountReturns8OnFull3x3BoardForMiddleCell(){
        int[][] fullBoard = new int[][] {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        GameOfLife gol = new GameOfLife(fullBoard);
        int neighborCount = gol.getNeighborCount(1, 1);
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

        GameOfLife gol = new GameOfLife(fullBoard);
        int neighborCount = gol.getNeighborCount(0, 0);
        int expectedNeighborCount = 3;
        assertThat(neighborCount,equalTo(expectedNeighborCount));
    }
}
