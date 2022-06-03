package com.codernon2k1.note.zhome.tienich.giaitri.sudoku;

public class Game_Soduku {
    public static int[][] play = new int[9][9];

    public static int[][] show = new int[9][9];

    public static int[][] ans = new int[9][9];

    public static void tao(){
        show[0][0] = 5 ;show[0][1] = 3 ;show[0][2] = 0 ;show[0][3] = 0 ;show[0][4] = 7 ;show[0][5] = 0 ;show[0][6] = 0 ;show[0][7] = 0 ;show[0][8] = 0 ;
        show[1][0] = 6 ;show[1][1] = 0 ;show[1][2] = 0 ;show[1][3] = 1 ;show[1][4] = 9 ;show[1][5] = 5 ;show[1][6] = 0 ;show[1][7] = 0 ;show[1][8] = 0 ;
        show[2][0] = 0 ;show[2][1] = 9 ;show[2][2] = 8 ;show[2][3] = 0 ;show[2][4] = 0 ;show[2][5] = 0 ;show[2][6] = 0 ;show[2][7] = 6 ;show[2][8] = 0 ;
        show[3][0] = 8 ;show[3][1] = 0 ;show[3][2] = 0 ;show[3][3] = 0 ;show[3][4] = 6 ;show[3][5] = 0 ;show[3][6] = 0 ;show[3][7] = 0 ;show[3][8] = 3 ;
        show[4][0] = 4 ;show[4][1] = 0 ;show[4][2] = 0 ;show[4][3] = 8 ;show[4][4] = 0 ;show[4][5] = 3 ;show[4][6] = 0 ;show[4][7] = 0 ;show[4][8] = 1 ;
        show[5][0] = 7 ;show[5][1] = 0 ;show[5][2] = 0 ;show[5][3] = 0 ;show[5][4] = 2 ;show[5][5] = 0 ;show[5][6] = 0 ;show[5][7] = 0 ;show[5][8] = 6 ;
        show[6][0] = 0 ;show[6][1] = 6 ;show[6][2] = 0 ;show[6][3] = 0 ;show[6][4] = 0 ;show[6][5] = 0 ;show[6][6] = 2 ;show[6][7] = 8 ;show[6][8] = 0 ;
        show[7][0] = 0 ;show[7][1] = 0 ;show[7][2] = 0 ;show[7][3] = 4 ;show[7][4] = 1 ;show[7][5] = 9 ;show[7][6] = 0 ;show[7][7] = 0 ;show[7][8] = 5 ;
        show[8][0] = 0 ;show[8][1] = 0 ;show[8][2] = 0 ;show[8][3] = 0 ;show[8][4] = 8 ;show[8][5] = 0 ;show[8][6] = 0 ;show[8][7] = 7 ;show[8][8] = 9 ;

        ans[0][0] = 5 ;ans[0][1] = 3 ;ans[0][2] = 4 ;ans[0][3] = 6 ;ans[0][4] = 7 ;ans[0][5] = 8 ;ans[0][6] = 9 ;ans[0][7] = 1 ;ans[0][8] = 2 ;
        ans[1][0] = 6 ;ans[1][1] = 7 ;ans[1][2] = 2 ;ans[1][3] = 1 ;ans[1][4] = 9 ;ans[1][5] = 5 ;ans[1][6] = 3 ;ans[1][7] = 4 ;ans[1][8] = 8 ;
        ans[2][0] = 1 ;ans[2][1] = 9 ;ans[2][2] = 8 ;ans[2][3] = 3 ;ans[2][4] = 4 ;ans[2][5] = 2 ;ans[2][6] = 5 ;ans[2][7] = 6 ;ans[2][8] = 7 ;
        ans[3][0] = 8 ;ans[3][1] = 5 ;ans[3][2] = 9 ;ans[3][3] = 7 ;ans[3][4] = 6 ;ans[3][5] = 1 ;ans[3][6] = 4 ;ans[3][7] = 2 ;ans[3][8] = 3 ;
        ans[4][0] = 4 ;ans[4][1] = 2 ;ans[4][2] = 6 ;ans[4][3] = 8 ;ans[4][4] = 5 ;ans[4][5] = 3 ;ans[4][6] = 7 ;ans[4][7] = 9 ;ans[4][8] = 1 ;
        ans[5][0] = 7 ;ans[5][1] = 1 ;ans[5][2] = 3 ;ans[5][3] = 9 ;ans[5][4] = 2 ;ans[5][5] = 4 ;ans[5][6] = 8 ;ans[5][7] = 5 ;ans[5][8] = 6 ;
        ans[6][0] = 9 ;ans[6][1] = 6 ;ans[6][2] = 1 ;ans[6][3] = 5 ;ans[6][4] = 3 ;ans[6][5] = 7 ;ans[6][6] = 2 ;ans[6][7] = 8 ;ans[6][8] = 4 ;
        ans[7][0] = 2 ;ans[7][1] = 8 ;ans[7][2] = 7 ;ans[7][3] = 4 ;ans[7][4] = 1 ;ans[7][5] = 9 ;ans[7][6] = 6 ;ans[7][7] = 3 ;ans[7][8] = 5 ;
        ans[8][0] = 3 ;ans[8][1] = 4 ;ans[8][2] = 5 ;ans[8][3] = 2 ;ans[8][4] = 8 ;ans[8][5] = 6 ;ans[8][6] = 1 ;ans[8][7] = 7 ;ans[8][8] = 9 ;

        play[0][0] = 5 ;play[0][1] = 3 ;play[0][2] = 0 ;play[0][3] = 0 ;play[0][4] = 7 ;play[0][5] = 0 ;play[0][6] = 0 ;play[0][7] = 0 ;play[0][8] = 0 ;
        play[1][0] = 6 ;play[1][1] = 0 ;play[1][2] = 0 ;play[1][3] = 1 ;play[1][4] = 9 ;play[1][5] = 5 ;play[1][6] = 0 ;play[1][7] = 0 ;play[1][8] = 0 ;
        play[2][0] = 0 ;play[2][1] = 9 ;play[2][2] = 8 ;play[2][3] = 0 ;play[2][4] = 0 ;play[2][5] = 0 ;play[2][6] = 0 ;play[2][7] = 6 ;play[2][8] = 0 ;
        play[3][0] = 8 ;play[3][1] = 0 ;play[3][2] = 0 ;play[3][3] = 0 ;play[3][4] = 6 ;play[3][5] = 0 ;play[3][6] = 0 ;play[3][7] = 0 ;play[3][8] = 3 ;
        play[4][0] = 4 ;play[4][1] = 0 ;play[4][2] = 0 ;play[4][3] = 8 ;play[4][4] = 0 ;play[4][5] = 3 ;play[4][6] = 0 ;play[4][7] = 0 ;play[4][8] = 1 ;
        play[5][0] = 7 ;play[5][1] = 0 ;play[5][2] = 0 ;play[5][3] = 0 ;play[5][4] = 2 ;play[5][5] = 0 ;play[5][6] = 0 ;play[5][7] = 0 ;play[5][8] = 6 ;
        play[6][0] = 0 ;play[6][1] = 6 ;play[6][2] = 0 ;play[6][3] = 0 ;play[6][4] = 0 ;play[6][5] = 0 ;play[6][6] = 2 ;play[6][7] = 8 ;play[6][8] = 0 ;
        play[7][0] = 0 ;play[7][1] = 0 ;play[7][2] = 0 ;play[7][3] = 4 ;play[7][4] = 1 ;play[7][5] = 9 ;play[7][6] = 0 ;play[7][7] = 0 ;play[7][8] = 5 ;
        play[8][0] = 0 ;play[8][1] = 0 ;play[8][2] = 0 ;play[8][3] = 0 ;play[8][4] = 8 ;play[8][5] = 0 ;play[8][6] = 0 ;play[8][7] = 7 ;play[8][8] = 9 ;


    }
}
