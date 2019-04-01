import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    @Test
    public void playerMove() {
        TicTacToe field = new TicTacToe(3);
        field.playerMove(0, 0, true);
        field.playerMove(0, 1, false);
        field.playerMove(0, 2, true);
        field.playerMove(1, 0, false);
        field.playerMove(1, 1, true);
        field.playerMove(1, 2, false);
        field.playerMove(2, 0, true);
        field.playerMove(2, 1, false);
        field.playerMove(2, 2, true);
        assertEquals("X O X \n" +
                "O X O \n" +
                "X O X \n", field.toString());
    }


    @Test
    public void clearCell() {
        TicTacToe field = new TicTacToe(3);
        field.playerMove(0, 0, true);
        field.playerMove(0, 1, false);
        field.playerMove(0, 2, true);
        field.playerMove(1, 0, false);
        field.playerMove(1, 1, true);
        field.playerMove(1, 2, false);
        field.playerMove(2, 0, true);
        field.playerMove(2, 1, false);
        field.playerMove(2, 2, true);
        field.clearCell(0, 0);
        field.clearCell(1, 1);
        field.clearCell(2, 2);
        assertEquals("  O X \n" +
                "O   O \n" +
                "X O   \n", field.toString());
    }

    @Test
    public void clearCell1() {
        TicTacToe field = new TicTacToe(4);
        field.playerMove(0, 0, true);
        field.playerMove(0, 1, true);
        field.playerMove(0, 2, true);
        field.playerMove(0, 3, true);
        field.playerMove(1, 0, true);
        field.playerMove(1, 1, true);
        field.playerMove(1, 2, true);
        field.playerMove(1, 3, true);
        field.playerMove(2, 0, true);
        field.playerMove(2, 1, true);
        field.playerMove(2, 2, true);
        field.playerMove(2, 3, true);
        field.playerMove(3, 0, true);
        field.playerMove(3, 1, true);
        field.playerMove(3, 2, true);
        field.playerMove(3, 3, true);
        field.clearCell(0, 0);
        field.clearCell(0, 3);
        field.clearCell(1, 0);
        field.clearCell(1, 3);
        field.clearCell(2, 1);
        field.clearCell(2, 2);
        field.clearCell(3, 0);
        field.clearCell(3, 3);
        field.clearCell(1, 1);
        field.clearCell(1, 2);
        assertEquals("  X X   \n" +
                "        \n" +
                "X     X \n" + "  X X   \n", field.toString());
    }

    @Test
    public void playerMove1() {
        TicTacToe field = new TicTacToe(3);
        boolean fl = false;
        try {
            field.playerMove(3, 0, true);
        } catch (IndexOutOfBoundsException e) {
            fl = true;
        }
        assertTrue(fl);
    }


    @Test
    public void largestLength() {
        TicTacToe field = new TicTacToe(3);
        field.playerMove(0, 0, true);
        field.playerMove(0, 1, true);
        field.playerMove(0, 2, true);
        field.playerMove(1, 0, false);
        field.playerMove(1, 1, false);
        field.playerMove(1, 2, true);
        field.playerMove(2, 0, true);
        field.playerMove(2, 1, false);
        field.playerMove(2, 2, true);
        assertEquals( 1,  field.largestLengthOfLeftDiagonal(true));
        assertEquals(1, field.largestLengthOfRightDiagonal(false));
        assertEquals(1, field.largestLengthOfRightDiagonal(true));
        assertEquals(new TicTacToe.Pair(3,1), field.largestLengthOfHorizontal(true));
        assertEquals(new TicTacToe.Pair(2,2), field.largestLengthOfHorizontal(false));
        assertEquals(new TicTacToe.Pair(2,2), field.largestLengthOfVertical(false));
    }

    @Test
    public void largestLength2() {
        TicTacToe field = new TicTacToe(3);
        field.playerMove(0, 0, true);
        field.playerMove(0, 1, true);
        field.playerMove(0, 2, true);
        field.playerMove(1, 0, false);
        field.playerMove(1, 1, false);
        field.playerMove(1, 2, false);
        field.playerMove(2, 0, true);
        field.playerMove(2, 1, false);
        field.playerMove(2, 2, true);
        assertEquals(1, field.largestLengthOfLeftDiagonal(true));
        assertEquals(1, field.largestLengthOfRightDiagonal(false));
        assertEquals(1, field.largestLengthOfRightDiagonal(true));
        assertEquals(new TicTacToe.Pair(3,1), field.largestLengthOfHorizontal(true));
        assertEquals(new TicTacToe.Pair(3,2), field.largestLengthOfHorizontal(false));
        assertEquals(new TicTacToe.Pair(2,2), field.largestLengthOfVertical(false));
    }

    @Test
    public void largestLength3() {
        TicTacToe field = new TicTacToe(3);
        field.playerMove(0, 0, false);
        field.playerMove(0, 1, false);
        field.playerMove(0, 2, true);
        field.playerMove(1, 0, true);
        field.playerMove(1, 1, false);
        field.playerMove(1, 2, true);
        field.playerMove(2, 0, false);
        field.playerMove(2, 1, true);
        field.playerMove(2, 2, true);
        assertEquals(1, field.largestLengthOfLeftDiagonal(true));
        assertEquals(new TicTacToe.Pair(3,3), field.largestLengthOfVertical(true));
        assertEquals(2, field.largestLengthOfRightDiagonal(false));
        assertEquals(1, field.largestLengthOfRightDiagonal(true));
        assertEquals(new TicTacToe.Pair(2,3), field.largestLengthOfHorizontal(true));
        assertEquals(new TicTacToe.Pair(2,1), field.largestLengthOfHorizontal(false));
    }

    @Test
    public void largestLength4() {
        TicTacToe field = new TicTacToe(4);
        field.playerMove(0, 0, true);
        field.playerMove(0, 1, false);
        field.playerMove(0, 2, false);
        field.playerMove(0, 3, true);
        field.playerMove(1, 0, false);
        field.playerMove(1, 1, false);
        field.playerMove(1, 2, true);
        field.playerMove(1, 3, false);
        field.playerMove(2, 0, false);
        field.playerMove(2, 1, true);
        field.playerMove(2, 2, false);
        field.playerMove(2, 3, true);
        field.playerMove(3, 0, true);
        field.playerMove(3, 1, true);
        field.playerMove(3, 2, false);
        field.playerMove(3, 3, false);
        assertEquals(1, field.largestLengthOfLeftDiagonal(true));
        assertEquals(new TicTacToe.Pair(2,2), field.largestLengthOfVertical(true));
        assertEquals(1, field.largestLengthOfLeftDiagonal(true));
        assertEquals(0, field.largestLengthOfRightDiagonal(false));
        assertEquals(4, field.largestLengthOfRightDiagonal(true));
        assertEquals(new TicTacToe.Pair(2,4), field.largestLengthOfHorizontal(true));
    }

    @Test
    public void largestLength5() {
        TicTacToe field = new TicTacToe(4);
        field.playerMove(0, 0, false);
        field.playerMove(0, 1, true);
        field.playerMove(0, 2, true);
        field.playerMove(0, 3, false);
        field.playerMove(1, 0, false);
        field.playerMove(1, 1, true);
        field.playerMove(1, 2, true);
        field.playerMove(1, 3, true);
        field.playerMove(2, 0, true);
        field.playerMove(2, 1, false);
        field.playerMove(2, 2, false);
        field.playerMove(2, 3, true);
        field.playerMove(3, 0, false);
        field.playerMove(3, 1, true);
        field.playerMove(3, 2, true);
        field.playerMove(3, 3, true);
        assertEquals(new TicTacToe.Pair(3,4), field.largestLengthOfVertical(true));
        assertEquals(new TicTacToe.Pair(2,1), field.largestLengthOfVertical(false));
        assertEquals(new TicTacToe.Pair(2,3), field.largestLengthOfHorizontal(false));
        assertEquals(1, field.largestLengthOfLeftDiagonal(true));
        assertEquals(2, field.largestLengthOfRightDiagonal(false));

    }
}



