package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 실버1 16918 봄버맨 _완
public class Bomberman {
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][][] board = new char[2][r][c];
        char[][] evenBoard = new char[r][c];

        //입력 받기
        for(int i = 0; i < r; i++){
            board[0][i] = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                board[1][i][j] = '.';
                evenBoard[i][j] = 'O';
            }
        }

        if(n == 1){
            for(int i = 0; i < r; i++){
                bw.write(board[0][i]);
                bw.write('\n');
            }
            bw.flush();
            return;
        }
        if(n % 2 == 0){
            for(int i = 0; i < r; i++){
                bw.write(evenBoard[i]);
                bw.write('\n');
            }
            bw.flush();
            return;
        }

        int second = n % 4;
        //n초 후 결과 구하기
        for(int i = 2; i < n+1 ; i++){ // i-1초에서 i초까지 일어나는 일
            int s = i % 4;
            switch(s){
                case 0: //0번 보드 폭탄 설치
                    for(int j = 0; j < r; j++){
                        for(int k = 0; k < c; k++){
                            if(board[1][j][k] == '.') board[0][j][k] = 'O';
                        }
                    }
                    break;
                case 1: //1번 보드 폭탄 터짐
                    for(int j = 0; j < r; j++) {
                        for (int k = 0; k < c; k++) {
                            if (board[1][j][k] == '.')
                                continue;
                            //폭탄이닷!
                            if(k != 0){// 왼쪽 터뜨리기
                                board[0][j][k-1] = '.';
                                board[1][j][k-1] = '.';
                            }
                            //제자리 터뜨리기
                            board[0][j][k] ='.';
                            board[1][j][k] = '.';

                            if(k != c-1){// 오른쪽 터뜨리기
                                if(board[1][j][k+1] == '.'){ // 같은 보드 오른쪽에 폭탄 없으면.
                                    board[0][j][k+1] = '.';
                                    board[1][j][k+1] = '.';
                                }
                            }

                            //위쪽 터뜨리기
                            if(j != 0){
                                board[0][j-1][k] ='.';
                                board[1][j-1][k] = '.';
                            }

                            //아래쪽 터뜨리기
                            if(j != r-1){
                                if(board[1][j+1][k] == '.'){  // 같은 보드 아래쪽에 폭탄 없으면.
                                    board[0][j+1][k] = '.';
                                    board[1][j+1][k] ='.';
                                }
                            }
                        }
                    }
                    break;
                case 2: //1번 보드 폭탄 설치
                    for(int j = 0; j < r; j++){
                        for(int k = 0; k < c; k++){
                            if(board[0][j][k] == '.') board[1][j][k] = 'O';
                        }
                    }
                    break;
                case 3: //0번 보드 폭탄 터짐
                    for(int j = 0; j < r; j++) {
                        for (int k = 0; k < c; k++) {
                            if (board[0][j][k] == '.')
                                continue;
                            //폭탄이닷!
                            if(k != 0){// 왼쪽 터뜨리기
                                board[0][j][k-1] = '.';
                                board[1][j][k-1] = '.';
                            }
                            //제자리 터뜨리기
                            board[0][j][k] ='.';
                            board[1][j][k] = '.';

                            if(k != c-1){// 오른쪽 터뜨리기
                                if(board[0][j][k+1] == '.'){ // 같은 보드 오른쪽에 폭탄 없으면.
                                    board[0][j][k+1] = '.';
                                    board[1][j][k+1] = '.';
                                }
                            }

                            //위쪽 터뜨리기
                            if(j != 0){
                                board[0][j-1][k] ='.';
                                board[1][j-1][k] = '.';
                            }

                            //아래쪽 터뜨리기
                            if(j != r-1){
                                if(board[0][j+1][k] == '.'){ // 같은 보드 아래쪽에 폭탄 없으면
                                    board[0][j+1][k] = '.';
                                    board[1][j+1][k] ='.';
                                }
                            }
                        }
                    }
                    break;
            }
        }
        if(second == 3){
            for(int i = 0; i < r; i++){
                bw.write(board[1][i]);
                bw.write('\n');
            }
            bw.flush();
        }
        else if(second == 1){
            for(int i = 0; i < r; i++){
                bw.write(board[0][i]);
                bw.write('\n');
            }
            bw.flush();
        }

    }

    public static void main(String[] args) throws Exception{
        new Bomberman().solution();
    }
}

