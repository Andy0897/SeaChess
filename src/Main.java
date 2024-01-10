import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        char player = '1';
        AI ai = new AI('2');
        System.out.println(board);
        while (true) {
            System.out.print("Enter position: ");
            board.makeMove(player, input.next().charAt(0));
            if (Validation.checkIfWinner(board.getBoard())) {
                break;
            }
            if (Validation.checkIfBoardIsFull(board)) {
                break;
            }
            System.out.println(board);
            board = ai.makeMove(board);
            if (Validation.checkIfWinner(board.getBoard())) {
                break;
            }
            if (Validation.checkIfBoardIsFull(board)) {
                break;
            }
            System.out.println(board);
        }
        System.out.println(board);
    }
}