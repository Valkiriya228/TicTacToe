import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
        System.out.println(field);
        assertEquals("  X X   \n" +
                "        \n" +
                "X     X \n" + "  X X   \n", field.toString());
    }

    @Test
    public void playerMove1() {
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
        field.playerMove(3, 1, true); //заполнила клетку с выходом за пределы массива дабы проверить бросание исключения
        field.clearCell(3, 1); //стёрла эту же клетку
        assertEquals("  X X   \n" +
                "        \n" +
                "X     X \n" + "  X X   \n", field.toString());
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
        System.out.println(field);
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в левой диагонали",
                field.largestLengthOfLeftDiagonal(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "1" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(false));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(true));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "3" + " в " + "1" + " горизонтали",
                field.largestLengthOfHorizontal(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в " + "2" + " горизонтали",
                field.largestLengthOfHorizontal(false));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в " + "2" + " вертикали",
                field.largestLengthOfVertical(false));
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
        System.out.println(field);
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в левой диагонали",
                field.largestLengthOfLeftDiagonal(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "1" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(false));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(true));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "3" + " в " + "1" + " горизонтали",
                field.largestLengthOfHorizontal(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "3" + " в " + "2" + " горизонтали",
                field.largestLengthOfHorizontal(false));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в " + "2" + " вертикали",
                field.largestLengthOfVertical(false));
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
        System.out.println(field);
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в левой диагонали",
                field.largestLengthOfLeftDiagonal(true));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "3" + " в " + "3" + " вертикали",
                field.largestLengthOfVertical(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(false));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(true));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "2" + " в " + "3" + " горизонтали",
                field.largestLengthOfHorizontal(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в " + "1" + " горизонтали",
                field.largestLengthOfHorizontal(false));
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
        System.out.println(field);
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в левой диагонали",
                field.largestLengthOfLeftDiagonal(true));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "2" + " в " + "2" + " вертикали",
                field.largestLengthOfVertical(true));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в левой диагонали",
                field.largestLengthOfLeftDiagonal(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "0" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(false));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "4" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(true));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "2" + " в " + "4" + " горизонтали",
                field.largestLengthOfHorizontal(true));
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
        System.out.println(field);
        assertEquals("Самая длинная последовательность " + "X" + " = " + "3" + " в " + "4" + " вертикали",
                field.largestLengthOfVertical(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в " + "1" + " вертикали",
                field.largestLengthOfVertical(false));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в " + "3" + " горизонтали",
                field.largestLengthOfHorizontal(false));
        assertEquals("Самая длинная последовательность " + "X" + " = " + "1" + " в левой диагонали",
                field.largestLengthOfLeftDiagonal(true));
        assertEquals("Самая длинная последовательность " + "O" + " = " + "2" + " в правой диагонали",
                field.largestLengthOfRightDiagonal(false));

    }
}



