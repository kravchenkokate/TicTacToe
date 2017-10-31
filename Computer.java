import java.util.Random;

/**
 * Игрок-компьютер
 */
public class Computer extends Player {

    public Computer(String name, char mark) {
        super(name, mark);
    }


    @Override
    public void makeTurn() {

        System.out.println(getName() + ":");
        addMark(new Random());
    }

    private void addMark(Random random) {

        int max = 9, min = 1;
        int pos = random.nextInt(max - min + 1) + min;

        if(getGrid().addMark(pos, getMark())) {
            getGrid().printGrid();
            checkVictory();
        }
        else {
            addMark(random);
        }
    }
}
