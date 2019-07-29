import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    @Test
    public void gameBoardTest() {
       GameOfLife gol = new GameOfLife();
       gol.evolveBoard(gol.initializeBoard(5,5),1,true);

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

    @Test
    public void getNeighborCountReturns1On5x5BoardForCellWhichIsPartOfOscillatorPattern(){
        int[][] fullBoard = new int[][] {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
        };

        GameOfLife gol = new GameOfLife();
        int neighborCount = gol.getNeighborCount(fullBoard,2, 1);
        int expectedNeighborCount = 1;
        assertThat(neighborCount,equalTo(expectedNeighborCount));
    }


    @Test
    public void evolveBoardReturnsSameStateAsBeforeForBlockPattern(){
        int[][] stillLife = new int[][] {
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };

        GameOfLife gol = new GameOfLife();
        int[][] evolvedBoard = gol.evolveBoard(stillLife);
        assertThat(evolvedBoard,equalTo(stillLife));

    }

    @Test
    public void evolveBoardReturnsOscillatedStateForBlinkerPatternInOneEvolveStep(){
        int[][] blinkerStart = new int[][] {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
        };

        int[][] blinkerExpected = new int[][] {
                {0,0,0,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,1,0,0},
                {0,0,0,0,0},
        };

        GameOfLife gol = new GameOfLife();
        gol.visualizeBoard(blinkerStart);
        int[][] evolvedBoard = gol.evolveBoard(blinkerStart,1,true);
        assertThat(evolvedBoard,equalTo(blinkerExpected));

    }

    @Test
    public void evolveBoardReturnsOscillatedStateForToadPatternInOneEvolveStep(){
        int[][] toadStart = new int[][] {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,1,0},
                {0,1,1,1,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
        };

        int[][] toadExpected = new int[][] {
                {0,0,0,0,0,0},
                {0,0,0,1,0,0},
                {0,1,0,0,1,0},
                {0,1,0,0,1,0},
                {0,0,1,0,0,0},
                {0,0,0,0,0,0},
        };

        GameOfLife gol = new GameOfLife();
        gol.visualizeBoard(toadStart);
        int[][] evolvedBoard = gol.evolveBoard(toadStart,1,true);
        assertThat(evolvedBoard,equalTo(toadExpected));

    }
}
