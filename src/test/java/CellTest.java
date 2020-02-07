import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void ShouldDieWithZeroNEighbour(){
        Cell uut = new Cell(Cell.CellState.ALIVE);
        Cell.CellState actual = uut.GetNextState(0);
        assertEquals(Cell.CellState.DEAD, actual);
    }

    @Test
    public void ShouldDieWithOneNeighbour(){
        Cell uut = new Cell(Cell.CellState.ALIVE);
        Cell.CellState actual = uut.GetNextState(1);
        assertEquals(Cell.CellState.DEAD, actual);
    }

    @Test
    public void ShouldLiveOnWithTwoNeighbours(){
        Cell uut = new Cell(Cell.CellState.ALIVE);
        Cell.CellState actual = uut.GetNextState(2);
        assertEquals(Cell.CellState.ALIVE, actual);
    }

    @Test
    public void ShouldLiveOnWithThreeNeighbours(){
        Cell uut = new Cell(Cell.CellState.ALIVE);
        Cell.CellState actual = uut.GetNextState(3);
        assertEquals(Cell.CellState.ALIVE, actual);
    }

    @Test
    public void ShouldDieWithFourNeighbours(){
        Cell uut = new Cell(Cell.CellState.ALIVE);
        Cell.CellState actual = uut.GetNextState(4);
        assertEquals(Cell.CellState.DEAD, actual);
    }

    @Test
    public void ShouldReviveWithThreeNeighbours(){
        Cell uut = new Cell(Cell.CellState.DEAD);
        Cell.CellState actual = uut.GetNextState(3);
        assertEquals(Cell.CellState.ALIVE, actual);
    }
}
