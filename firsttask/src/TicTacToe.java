import java.util.Scanner;

public class TicTacToe {
    // 定义一个3x3的棋盘数组
    private static char[][] board = new char[3][3];
    // 定义一个常量表示空位
    private static final char EMPTY = '-';
    // 定义一个变量记录当前玩家，X先手
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        // 初始化棋盘
        initBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayBoard(); // 显示当前棋盘状态

            System.out.println("当前玩家：" + currentPlayer + " 请输入您要放置的位置(1-9):");

            int position = scanner.nextInt() - 1; // 输入位置转换为0-8

            // 判断输入位置是否合法
            if (isValidMove(position)) {
                makeMove(position, currentPlayer); // 在指定位置放置玩家符号

                // 判断当前游戏状态（赢或平局）
                if (isWin(currentPlayer)) {
                    System.out.println(currentPlayer + " 赢了！");
                    break;
                } else if (isDraw()) {
                    System.out.println("平局！");
                    break;
                }

                // 切换当前玩家
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            } else {
                System.out.println("非法输入，请重新选择位置！");
            }
        }

        scanner.close();
    }

    // 初始化棋盘为全空位
    private static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // 显示当前棋盘状态
    private static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 判断指定位置是否合法
    private static boolean isValidMove(int pos) {
        int row = pos / 3;
        int col = pos % 3;
        return board[row][col] == EMPTY;
    }

    // 在指定位置放置玩家符号
    private static void makeMove(int pos, char player) {
        int row = pos / 3;
        int col = pos % 3;
        board[row][col] = player;
    }

    // 判断当前玩家是否赢得游戏
    private static boolean isWin(char player) {
        // 检查行、列和对角线是否连续三个相同符号
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // 检查两条对角线
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    // 判断游戏是否为平局
    private static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}