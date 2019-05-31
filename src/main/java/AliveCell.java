public class AliveCell implements Cell {
    public Cell evolve(int neighborCount) {
        if (neighborCount == 2 || neighborCount == 3){
            return new AliveCell();
        }
        else return new DeadCell();
    }
}
