import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class AliveCellTest {

    @ParameterizedTest
    @ValueSource(ints = {2,3})
    public void evolveReturnsAliveCellIfNeighborCountIs2And3(int neighborCount){
        Cell aliveCell = new AliveCell();
        Cell evolvedCell = aliveCell.evolve(neighborCount);
        assertThat(evolvedCell,instanceOf(AliveCell.class));
    }

    @Test
    public void evolveReturnsDeadCellIfNeighborCountIsSmallerThan2(){
        Cell aliveCell = new AliveCell();
        Cell evolvedCell = aliveCell.evolve(1);
        assertThat(evolvedCell,instanceOf(DeadCell.class));
    }

    @Test
    public void evolveReturnsDeadCellIfNeighborCountIsGreaterThan3(){
        Cell aliveCell = new AliveCell();
        Cell evolvedCell = aliveCell.evolve(4);
        assertThat(evolvedCell,instanceOf(DeadCell.class));
    }
}
