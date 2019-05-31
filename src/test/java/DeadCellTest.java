import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class DeadCellTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,4,5,6,7,8})
    public void evolveReturnsDeadCellForAnyAmountOfNeighborsThatIsNot3(int neighborCount){
        Cell deadCell = new DeadCell();
        Cell evolvedCell = deadCell.evolve(neighborCount);
        assertThat(evolvedCell,instanceOf(DeadCell.class));
    }

    @Test
    public void evolveReturnsDeadCellForExactly3Neighbors(){
        Cell deadCell = new DeadCell();
        Cell evolvedCell = deadCell.evolve(3);
        assertThat(evolvedCell,instanceOf(AliveCell.class));
    }
}
