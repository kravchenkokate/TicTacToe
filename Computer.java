import java.util.Random;

/**
 * Игрок-компьютер
 */
public class Computer extends Player {

    private Random random;

    public Computer(String name, char mark) {

        super(name, mark);
        random = new Random();
    }


    @Override
    public void makeMove() {

        System.out.println(getName() + ":");
        addMark();
    }

    private void addMark() {

        int max = 9, min = 1;
        int pos = random.nextInt(max - min + 1) + min;

        if(getGrid().addMark(pos, getMark())) {
            getGrid().printGrid();
            checkVictory();
        }
        else {
            addMark();
        }
    }
}
