import java.util.List;

public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        setUpBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    private void setUpBoard() {
        int num = 49;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = (char) num;
                num++;
            }
        }
    }

    public void makeMove(char player, char position) {
        boolean isFoundPosition = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == position) {
                    if (player == '1') {
                        board[i][j] = 'X';
                    } else {
                        board[i][j] = 'O';
                    }
                    isFoundPosition = true;
                    break;
                }
            }
        }
        if (!isFoundPosition) {
            System.out.println("Invalid position");
        }
    }


    @Override
    public String toString() {
        String boardStr = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardStr += board[i][j] + " ";
            }
            boardStr += "\n";
        }
        return boardStr;
    }
}