/**
 * Абстрактный игрок
 */
public abstract class Player {

    //имя
    private String name;
    //знак: 'x' или 'o'
    private char mark;
    // поле для игры
    private Grid grid;
    // флаг победителя
    private boolean winner;


    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }


    public Grid getGrid() {
        return this.grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public String getName() {
        return this.name;
    }

    public char getMark() {
        return this.mark;
    }

    public boolean isWinner() {
        return this.winner;
    }

    /**
     * Проверяет выиграл ли игрок по окончании своего хода.
     * Игрок победил, если проставил три своих знака в одной строке, одном столбце, либо по диагонали
     */
    public void checkVictory() {

        char[][] a = getGrid().getCells();
        char mark = getMark();

        // счетчик по строке
        int r = 0;
        // счетчик по столбцу
        int c = 0;
        // счетчик по диагонали
        int d = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                 // подсчет по строке
                 if(a[i][j] == mark) {
                     r++;
                 }
                 // подсчет по столбцу
                 if(a[j][i] == mark) {
                     c++;
                 }
                 // подсчет по диагонали
                 if(i==j && a[i][j] == mark) {
                     d++;
                 }
            }
            if(r==3 || c == 3 || d == 3) {
                this.winner = true;
                break;
            }
            else {
                r = 0;
                c = 0;
            }
        }
        // проверка по обратной диагонали
        if(a[2][0] == mark && a[2][0] == a[1][1] && a[2][0] == a[0][2]) {
            this.winner = true;
        }
    }

    /**
     * Сделать ход. Проставить свой знак ('x' или 'o') в ячейку на поле
     */
    public abstract void makeTurn();
}
