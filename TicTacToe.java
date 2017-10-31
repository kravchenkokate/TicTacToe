import java.util.Scanner;

public class TicTacToe {

    private static Scanner input;

    public static void main(String[] args) {

        input = new Scanner(System.in);

        System.out.println("Добро пожаловать в консольную игру Крестики-Нолики!");
        System.out.println("Как вас зовут?");
        String name = input.next();

        System.out.println("Что выберите: крестики (х) или нолики (о)?");
        char mark = input.next().charAt(0);
        checkMark(mark);

        Grid grid = new Grid();
        Player player1, player2;

        if(mark == 'х') {
            player1 = new Human(name, mark);
            player1.setGrid(grid);
            player2 = new Computer("Компьютер",'о');
            player2.setGrid(grid);
        }
        else {
            player1 = new Computer("Компьютер",'х');
            player1.setGrid(grid);
            player2 = new Human(name, mark);
            player2.setGrid(grid);
        }

        System.out.println("Чтобы сделать ход, введите число, соответствующее номеру ячейки.");
        grid.printExample();
        System.out.println("Начнём.");

        do {
            player1.makeTurn();
            if(!player1.isWinner()) {
                player2.makeTurn();
            }
        } while(!player1.isWinner() && !player2.isWinner());

        String winner = "";
        if(player1.isWinner()) {
            winner = player1.getName();
        }
        else if(player2.isWinner()){
            winner = player2.getName();
        }
        else {
            winner = "Дружба";
        }

        System.out.println("Игра окончена! Победитель - " + winner);
    }

    /**
     * Проверяет правильность введенного символа. Допускаются только 'x' и 'o' (русская раскладка клавиатуры)
     * @param mark - введённый символ
     */
    private static void checkMark(char mark) {

        if(mark != 'х' && mark != 'о') {
            System.out.println("Пожалуйста, введите символ 'х' или 'о'.");
            mark = input.next().charAt(0);
            checkMark(mark);
        }
    }
}