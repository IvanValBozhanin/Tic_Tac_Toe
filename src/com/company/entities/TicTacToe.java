package com.company.entities;

import java.util.Scanner;

public class TicTacToe {
    private char [][]board;

    public TicTacToe() {
        this.board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '},{' ', ' ', ' '}};
    }

    public void play(){
        Scanner in = new Scanner(System.in);
        int k = 0;
        int red = 0;
        while(k++<9){
            printBoard();
            char pl = (red == 0?'O':'X');
            System.out.print("Enter a row (0, 1 or 2) for player " + pl +')');
            int r = in.nextInt();
            System.out.print("Enter a column (0, 1 or 2) for player " + pl +')');
            int c = in.nextInt();
            if(r > 2 || r<0 || c>2 || c<0 || board[r][c] != ' '){
                throw new IllegalArgumentException("Cannot access this cell!");
            }
            board[r][c] = pl;
            red ^= 1;

            int count=0;
            for(int i=0;i<3; ++i){
                if(board[i][c] == board[r][c]) ++count;
            }
            if(count == 3){
                System.out.println(board[r][c] + " wins!");
                printBoard();
                return;
            }
            count = 0;
            for(int i=0;i<3; ++i){
                if(board[r][i] == board[r][c]) ++count;
            }
            if(count == 3){
                System.out.println(board[r][c] + " wins!");
                printBoard();
                return;
            }
            count = 0;
            if((r==0 || r==2) && (c==0 || c==2)){
                for(int i=0;i < 3 ; ++i){
                    if(board[Math.abs(r-i)][Math.abs(c-i)] == board[r][c]) ++ count;
                }
            }
            if(count == 3){
                System.out.println(board[r][c] + " wins!");
                return;
            }
        }
        System.out.println("Tie!");
    }

    public void printBoard() {
        System.out.println("-------------");
        for(int i=0;i<3;++i){
            System.out.printf("| %c | %c | %c |\n-------------\n", board[i][0], board[i][1], board[i][2]);
        }
    }
}
