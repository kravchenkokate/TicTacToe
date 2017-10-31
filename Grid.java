/**
 * Поле для игры в крестики-нолики
 */
public class Grid {

    // ячейки
    private char[][] cells;


    public Grid() {
        cells = new char[3][3];
    }


    public char[][] getCells() {
        return this.cells;
    }

    /**
     * Выводит в консоль текущее состояние поля
     */
    public void printGrid() {
        print(cells);
    }

    /**
     * Выводит в консоль поле с индексами ячеек
     */
    public void printExample() {

        char[][] temp =
        {
                {'7','8','9'},
                {'4','5','6'},
                {'1','2','3'}
        };
        print(temp);
    }

    private void print(char[][] array) {

        for(int i=0; i<3; i++) {
            String row = "";
            for(int j=0; j<3; j++) {
                row += " " + array[i][j] + " ";
                if(j!=2) {
                    row +="|";
                }
            }
            System.out.println(row);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }

    /**
     * Добавляет знак на поле
     * @param pos - позиция знака - индекс ячейки
     * @param mark - знак -  'x' или 'o'
     * @return - true - ошибок нет, false - ячейка уже занята
     */
    public boolean addMark(int pos, char mark) {

        int i = 0, j = 0;
        switch(pos) {
            case 1:
                i = 2;
                j = 0;
                break;
            case 2:
                i = 2;
                j = 1;
                break;
            case 3:
                i = 2;
                j = 2;
                break;
            case 4:
                i = 1;
                j = 0;
                break;
            case 5:
                i = 1;
                j = 1;
                break;
            case 6:
                i = 1;
                j = 2;
                break;
            case 7:
                i = 0;
                j = 0;
                break;
            case 8:
                i = 0;
                j = 1;
                break;
            case 9:
                i = 0;
                j = 2;
                break;
            default:
                return false;
        }

        if(cells[i][j] == 'х' || cells[i][j] == 'о') {
            return false;
        }
        cells[i][j] = mark;

        return true;
    }
}
