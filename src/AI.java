import javax.swing.*;
import java.util.Random;

public class AI {
    private final char player;

    public AI(char player) {
        this.player = player;
    }

    public Board makeMove(Board board) {
        boolean isMadeMove = false;
        char[][] boardChar = board.getBoard();
        if (boardChar[1][1] == '5') {
            board.makeMove(player, boardChar[1][1]);
            isMadeMove = true;
        }
        if (!isMadeMove) {
            boolean toStop = false;
            for (int i = 0; i < boardChar.length; i++) {
                for (int j = 0; j < boardChar[0].length; j++) {
                    if (i == 1 && j == 1) {
                        j++;
                    } else {
                        if (boardChar[i][j] == 'O') {
                            if (i == 0 || i == 2 && j == 0 || j == 2) {
                                if (i == 2) {
                                    i -= 2;
                                } else {
                                    i += 2;
                                }
                                if (j == 2) {
                                    j -= 2;
                                } else {
                                    j += 2;
                                }
                                if(boardChar[i][j] != 'X'){
                                    board.makeMove(player, boardChar[i][j]);
                                    isMadeMove = true;
                                }
                                else{
                                    toStop = true;
                                    break;
                                }
                            } else {
                                if (i == 1 && j == 0) {
                                    j += 2;
                                } else if (i == 1 && j == 2) {
                                    j -= 2;
                                }
                                if (j == 1 && i == 0) {
                                    j += 2;
                                } else if (j == 1 && i == 2) {
                                    i -= 2;
                                }
                                if(boardChar[i][j] != 'X'){
                                    board.makeMove(player, boardChar[i][j]);
                                    isMadeMove = true;
                                }
                                else{
                                    toStop = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if(toStop){
                    break;
                }
            }
        }
        if (!isMadeMove) {
            Random rand = new Random();
            while (true) {
                int x = rand.nextInt(0,3);
                int y = rand.nextInt(0,3);
                if (boardChar[x][y] != 'X' && boardChar[x][y] != 'O') {
                    board.makeMove(player, boardChar[x][y]);
                    System.out.println("No winner!");
                    break;
                }
            }
        }

        return board;
    }
}
