public class Validation {
    public static boolean checkIfWinner(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                System.out.println(board[i][0] + " is winner!");
                return true;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                System.out.println(board[0][j] + " is winner!");
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            System.out.println(board[0][0] + " is winner!");
            return true;
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            System.out.println(board[0][2] + " is winner!");
            return true;
        }
        return false;
    }

    public static boolean checkIfBoardIsFull(Board board){
        char[][] boardMatrix = board.getBoard();
        for(int i=0; i<boardMatrix.length; i++){
            for(int j=0; j<boardMatrix.length; j++){
                if(!(boardMatrix[i][j] == 'X') && !(boardMatrix[i][j] == 'O')){
                    return false;
                }
            }
        }
        return true;
    }
}
