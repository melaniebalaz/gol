import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    @Test
    public void gameBoardTest() {
       GameOfLife gol = new GameOfLife();
       gol.evolveBoard(gol.initializeBoard(5,5),5,true);

    }

    @Test
    public void getNeighborCountReturns8OnFull3x3BoardForMiddleCell(){
        int[][] fullBoard = new int[][] {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        GameOfLife gol = new GameOfLife();
        int neighborCount = gol.getNeighborCount(fullBoard,1, 1);
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

        GameOfLife gol = new GameOfLife();
        int neighborCount = gol.getNeighborCount(fullBoard,0, 0);
        int expectedNeighborCount = 3;
        assertThat(neighborCount,equalTo(expectedNeighborCount));
    }
}
