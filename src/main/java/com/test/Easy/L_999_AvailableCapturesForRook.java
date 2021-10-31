package com.test.Easy;

public class L_999_AvailableCapturesForRook {

    /*
        2019.04.10

        On an 8 x 8 chessboard, there is one white rook([象棋] 車).
        There also may be empty squares, white bishops([象棋] 主教),
        and black pawns([象棋] 卒).  These are given as characters
        'R', '.', 'B', and 'p' respectively(分别的；各自的). Uppercase
        characters represent white pieces, and lowercase
        characters represent black pieces.

        The rook moves as in the rules of Chess: it
        chooses one of four cardinal directions (north,
        east, west, and south), then moves in that direction
        until it chooses to stop, reaches the edge of the
        board, or captures an opposite colored pawn by moving
        to the same square it occupies.  Also, rooks cannot
        move into the same square as other friendly bishops.

        Return the number of pawns the rook can capture in one move.

        Example 1:
            Input: [[".",".",".",".",".",".",".","."],
                    [".",".",".","p",".",".",".","."],
                    [".",".",".","R",".",".",".","p"],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".","p",".",".",".","."],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".",".",".",".",".","."]]
            Output: 3
            Explanation:
            In this example the rook is able to capture all the pawns.

        Example 2:
            Input: [[".",".",".",".",".",".",".","."],
                    [".","p","p","p","p","p",".","."],
                    [".","p","p","B","p","p",".","."],
                    [".","p","B","R","B","p",".","."],
                    [".","p","p","B","p","p",".","."],
                    [".","p","p","p","p","p",".","."],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".",".",".",".",".","."]]
            Output: 0
            Explanation:
            Bishops are blocking the rook to capture any pawn.

        Example 3:
            Input: [[".",".",".",".",".",".",".","."],
                    [".",".",".","p",".",".",".","."],
                    [".",".",".","p",".",".",".","."],
                    ["p","p",".","R",".","p","B","."],
                    [".",".",".",".",".",".",".","."],
                    [".",".",".","B",".",".",".","."],
                    [".",".",".","p",".",".",".","."],
                    [".",".",".",".",".",".",".","."]]
            Output: 3
            Explanation:
            The rook can capture the pawns at positions b5, d6 and f5.


        Note:
            board.length == board[i].length == 8
            board[i][j] is either 'R', '.', 'B', or 'p'
            There is exactly one cell with board[i][j] == 'R'
     */
    public static void main(String[] args) {
        L_999_AvailableCapturesForRook l = new L_999_AvailableCapturesForRook();
        char[][] example1 = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(l.numRookCaptures(example1));
        char[][] example2 = {{'.','.','.','.','.','.','.','.'},{'.','p','p','p','p','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','B','R','B','p','.','.'},{'.','p','p','B','p','p','.','.'},{'.','p','p','p','p','p','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(l.numRookCaptures(example2));
        char[][] example3 = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(l.numRookCaptures(example3));
    }

    public int numRookCaptures(char[][] board) {
        return numRookCaptures1(board);
    }

    public int numRookCaptures1(char[][] board) {
        // 先遍历横向 + 定位 R pos
        int result = 0;
        int rX = -1;
        int rY = -1;
        for (int i = 0; i < board.length; i++) {
            if (-1 != rX) break;
            for (int j = 0; j < board[0].length; j++) {
                // 首次 碰到 R 扫描该行 能否碰到 P
                if ('R' == board[i][j]) {
                    rX = j;
                    rY = i;
                    for (int k = j + 1; k < board[0].length; k++) {
                        if ('p' == board[i][k]) {
                            ++result;
                            break;
                        } else if ('B' == board[i][k]) {
                            break;
                        }
                    }
                    break;
                    // 首次 碰到 P 扫描该行 能否碰到 R
                } else if ('p' == board[i][j]) {
                    int pX = j;
                    int bX = -1;
                    for (int k = j + 1; k < board[0].length; k++) {
                        if ('R' == board[i][k]) {
                            rX = k;
                            rY = i;
                            if (-1 == bX || (bX < pX && pX < rX)) {
                                ++result;
                            }
                        } else if ('p' == board[i][k]) {
                            pX = k;
                            if (-1 != rX) {
                                if (-1 == bX || (bX < rX && rX < pX)) {
                                    ++result;
                                    break;
                                }
                            }
                        } else if ('B' == board[i][k]) {
                            bX = k;
                        }
                    }
                    break;
                }
            }
        }
        // 遍历 R 纵向
        int pY = -1;
        int bY = -1;
        for (int i = 0; i < board.length; i++) {
            if ('R' == board[i][rX]) {
                if (-1 != pY) {
                    if (-1 == bY || (bY < pY && pY < rY)) {
                        ++result;
                    }
                }
            } else if ('p' == board[i][rX]) {
                pY = i;
                if (pY > rY) {
                    if (-1 == bY || (bY < rY && rY < pY)) {
                        ++result;
                        break;
                    }
                }
            } else if ('B' == board[i][rX]) {
                bY = i;
                if (bY > rY) break;
            }
        }
        return result;
    }
}
