import java.util.Scanner;

/**
 * Игрок-человек
 */
public class Human extends Player {

    private Scanner input;


    public Human(String name, char mark) {
        super(name, mark);
        input = new Scanner(System.in);
    }


    @Override
    public void makeTurn() {

        System.out.println("Ваш ход, " + getName() + ":");
        int pos = input.nextInt();
        checkPosition(pos);
    }

    private void checkPosition(int pos) {

        if(pos >= 1 && pos <= 9){
            if(getGrid().addMark(pos, getMark())) {
                getGrid().printGrid();
                checkVictory();
            }
            else {
                showError("Эта ячейка уже занята. Введите другое число.");
            }
        }
        else {
            showError("Введите число от 1 до 9.");
        }
    }

    private void showError(String message) {

        System.out.println(message);
        int pos = input.nextInt();
        checkPosition(pos);
    }
}
