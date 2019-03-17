
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
    public void playerMove(int i, int j, boolean sideOfForse) {
        if (i < n && j < n && i >= 0 && j >= 0) {
            if (sideOfForse)
                field[i][j] = 'X';
            else
                field[i][j] = 'O';
        }
    }

    // Очистка клетки
    public void clearCell(int i, int j) {
        if (i < n && j < n && i >= 0 && j >= 0) {
            field[i][j] = ' ';
        }
    }


    public String largestLength(boolean side) {
        char sym;

        if (side)
            sym = 'X';
        else
            sym = 'O';

// Самая длинная последовательность по горизонтали
        int max1 = -1;
        int num1 = -1;
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if ((field[i][j] == sym) && (field[i][j] == field[i][j - 1])) k++;
                else break;
            }
            if (k > max1) {
                max1 = k;
                num1 = i;
            }
        }
        num1++;
        String result1 = "Самая длинная последовательность " + sym + " в " + num1 + " горизонтали";


// Самая длинная последовательность по вертикали
        int max2 = -1;
        int num2 = -1;
        int p = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if ((field[j][i] == sym) && (field[j][i] == field[j - 1][i]))  p++;
                else break;
            }
            if (p > max2) {
                max2 = p;
                num2 = i;
            }
        }
        num2++;


        String result2 = ("Самая длинная последовательность " + sym + " в " + num2 + " вертикали");


// Самая длинная последовательность по диагонали
        int max3;
        int k1 = 0, k2 = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((field[i][i] == sym) && (field[i][i] == field[i - 1][i - 1]))  k1++;
        }
        for (int j = n - 1; j < 2; j--) {
            if ((field[j][j] == sym) && (field[j][j] == field[j - 1][j - 1]))  k2++;
        }
        if (k1 > k2) max3 = k1;
        else max3 = k2;
        String result3 = "Самая длинная последовательность " + sym + " по диагонали";


        if ((max2 > max3) && (max2 > max1))
            return result2;
        if ((max1 > max2) && (max1 > max3))
            return result1;
        else
            return result3;
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
}