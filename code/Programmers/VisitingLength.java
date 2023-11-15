package Programmers;

public class VisitingLength {
    //방문 길이
    public int solution(String dirs) {
        int answer = 0;
        int len = dirs.length();
        boolean first = false;
        int x = 5;//맨 아래 왼쪽 꼭짓점의 좌표를 (0,0)이라고 생각
        int y = 5;//현재 위치의 좌표는 (5,5)인 셈
        boolean[][] hor = new boolean[11][10];//가로줄눈 방문여부
        boolean[][] ver = new boolean[10][11];//세로줄눈 방문여부
        for(int i = 0; i < len; i++){//명령어 하나하나에 대해 작업 수행
            char c = dirs.charAt(i);
            if(c == 'U'){//세로줄눈 위로 한 칸 이동
                if(y == 10) continue;//y 좌표가 범위를 벗어날 때
                if(!ver[y][x]) {//(x,y)와 (x, y+1)을 이은 선분은 ver[y][x]에 해당. 이 선분을 지난 적이 없다면
                    ver[y][x] = true;//이제 방문했으므로 true로 변경
                    answer += 1;//답 1 증가
                }
                y += 1;//y값 1 증가
            }
            else if(c == 'L'){//가로줄눈 왼쪽으로 한 칸 이동
                if(x == 0) continue;//x 좌표가 범위를 벗어날 때
                if(!hor[y][x-1]) {//(x,y)와 (x-1, y)을 이은 선분은 hor[y][x-1]에 해당. 이 선분을 지난 적이 없다면
                    hor[y][x-1] = true;//이제 방문했으므로 true로 변경
                    answer += 1;//답 1 증가
                }
                x -= 1;//x 값 1 감소
            }
            else if(c == 'R'){//가로줄눈 오른쪽으로 한 칸 이동
                if(x == 10) continue;//x 좌표가 범위를 벗어날 때
                if(!hor[y][x]) {//(x,y)와 (x+1, y)을 이은 선분은 hor[y][x]에 해당. 이 선분을 지난 적이 없다면
                    hor[y][x] = true;//이제 방문했으므로 true로 변경
                    answer += 1;//답 1 증가
                }
                x += 1;//x 값 1 증가
            }
            else{// c == 'D' 세로줄눈 아래로 한 칸 이동
                if(y == 0) continue;//y 좌표가 범위를 벗어날 때
                if(!ver[y-1][x]) {//(x,y)와 (x, y-1)을 이은 선분은 ver[y-1][x]에 해당. 이 선분을 지난 적이 없다면
                    ver[y-1][x] = true;//이제 방문했으므로 true로 변경
                    answer += 1;//답 1 증가
                }
                y -= 1;//y 값 1 감소
            }
        }
        return answer;
    }
}
