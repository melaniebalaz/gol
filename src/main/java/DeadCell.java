public class DeadCell implements Cell {
    public Cell evolve(int neighborCount) {
        if (neighborCount == 3){
            return new AliveCell();
        }
        else return new DeadCell();
    }
}
