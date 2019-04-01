
public class TicTacToe {
    int n;
    char[][] field;

    TicTacToe(int n) {
        this.n = n;
        field = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                this.field[i][j] = ' ';
    }

    // Ход игрока
    public void playerMove(int i, int j, boolean sideOfForce) {
        if (i < n && j < n && i >= 0 && j >= 0) {
            if (sideOfForce)
                field[i][j] = 'X';
            else
                field[i][j] = 'O';
        } else throw new IndexOutOfBoundsException();
    }

    // Очистка клетки
    public void clearCell(int i, int j) {
        if (i < n && j < n && i >= 0 && j >= 0) {
            field[i][j] = ' ';
        }
    }


    public Pair<Integer, Integer> largestLengthOfHorizontal(boolean side) {
        char sym;

        if (side)
            sym = 'X';
        else
            sym = 'O';

// Самая длинная последовательность по горизонтали
        int max = -1;
        int num = -1;
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((field[i][j] == sym) && (j == n - 1)) k++;
                else {
                    if ((field[i][j] == sym) && (field[i][j] == field[i][j + 1])) k++;
                    else if (field[i][j] == sym) k++;
                    else if (field[i][j] != sym) k = 0;
                }
                if (k > max) {
                    max = k;
                    num = i;
                }
            }
            k = 0;
        }
        num++;
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(max, num);
        return pair;
    }


    public Pair<Integer, Integer> largestLengthOfVertical(boolean side) {
        char sym;

        if (side)
            sym = 'X';
        else
            sym = 'O';
// Самая длинная последовательность по вертикали
        int max = 0;
        int num = -1;
        String result;
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((field[j][i] == sym) && (j == n - 1)) k++;
                else {
                    if ((field[j][i] == sym) && (field[j][i] == field[j + 1][i])) k++;
                    else if (field[j][i] == sym) k++;
                    else if (field[j][i] != sym) k = 0;
                }
                if (k > max) {
                    max = k;
                    num = i;
                }
            }
            k = 0;
        }
        num++;
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(max, num);
        return pair;
    }


    public int largestLengthOfLeftDiagonal(boolean side) {
        char sym;

        if (side)
            sym = 'X';
        else
            sym = 'O';
// Самая длинная последовательность по диагонали
        int max = -1;
        int k1 = 0;
        for (int i = 0; i < n; i++) {
            if ((field[i][i] == sym) && (i == n - 1)) k1++;
            else {
                if ((field[i][i] == sym) && (field[i][i] == field[i + 1][i + 1])) k1++;
                else if (field[i][i] == sym) k1++;
                else if (field[i][i] != sym) k1 = 0;
            }
            if (k1 > max) max = k1;
        }
        return max;
    }


    public int largestLengthOfRightDiagonal(boolean side) {
        char sym;

        if (side)
            sym = 'X';
        else
            sym = 'O';
        int k2 = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if ((field[i][n - i - 1] == sym) && (i == n - 1)) k2++;
            else {
                if ((field[i][n - i - 1] == sym) && (field[i][n - i - 1] == field[i + 1][n - i - 2])) k2++;
                else if (field[i][n - i - 1] == sym) k2++;
                else if (field[i][n - i - 1] != sym) k2 = 0;
            }
            if (k2 > max) max = k2;
        }


        return max;
    }


    public String toString() {
        StringBuilder bldr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bldr.append(field[i][j]).append(" ");
            }
            bldr.append("\n");
        }
        return bldr.toString();
    }


    // F - максимальная длина крестиков/ноликов;
    // S - номер вертикали/горизонтали, в которой расположена максимальная длина крестиков/ноликов
    public static class Pair<F, S> extends java.util.AbstractMap.SimpleImmutableEntry<F, S> {
        public Pair(F f, S s) {
            super(f, s);
        }

        public F getFirst() {
            return getKey();
        }

        public S getSecond() {
            return getValue();
        }

        public String toString() {
            return "[" + getKey() + "," + getValue() + "]";
        }
    }
}