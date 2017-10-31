/**
 * Игрок-компъютер
 */
public class Computer extends Player {

    public Computer(String name, char mark) {
        super(name, mark);
    }


    @Override
    public void makeTurn() {

        System.out.println(getName() + ":");
        addMark();
        getGrid().printGrid();
        checkVictory();
    }

    private void addMark() {

        char[][] a = getGrid().getCells();
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(a[i][j] != 'х' && a[i][j] != 'о') {
                    a[i][j] = getMark();
                    return;
                }
            }
        }
    }
}
