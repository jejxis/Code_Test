package Programmers;
import java.util.*;

public class Friends_4_Blocks {
    //[1차]프렌즈4블록
    public int solution(int m, int n, String[] board) {//m: 높이, n: 폭
        int answer = m * n;
        ArrayList<Character>[] arr = new ArrayList[n];//게임판의 세로줄에 담긴 블록들. 인덱스 0이 맨 아래에 있는 블록
        HashMap<Integer, Character> map = new HashMap<>();//블록마다 번호를 매겨서 저장하고 삭제할 때 사용함.
        int s = 0;
        int sn = 0;
        int num;

        for(int i = 0; i < n; i++){//주어진 보드를 저장
            arr[i] = new ArrayList<Character>();
            for(int j = m-1; j >= 0; j--){
                arr[i].add(board[j].charAt(i));
            }
        }

        while(true){
            for(int i = 0; i < n-1; i++){//판 돌아다니면서 2*2 찾기
                s = arr[i].size();//현재 보고있는 세로줄의 크기
                sn = arr[i+1].size();//오른쪽에 이웃한 세로줄 크기
                if(s == 0 || sn == 0) continue;//두 줄 중 하나의 크기가 0이라면 현재 보고 있는 세로줄에서 2*2가 나올 수 없으므로 넘어감
                for(int j = 0; j < s-1 && j < sn-1; j++){// 2*2 탐색
                    char c = arr[i].get(j);//블록 가져오기
                    if(c == arr[i].get(j+1) && c == arr[i+1].get(j) && c == arr[i+1].get(j+1)){//2*2 발견
                        map.put(i*m + j, '0');//삭제해야 하므로 맵에 저장
                        map.put(i*m + j + m, '0');
                        map.put(i*m + j + 1, '0');
                        map.put(i*m + j + 1 + m, '0');
                    }
                }
            }
            if(map.size() == 0) break;// 2*2를 발견하지 못했으므로 종료
            for(int i = 0; i < n; i++){//판에 있는 블록들을 돌아다니며 맵에 저장된 번호에 해당되는 블록들을 삭제함
                for(int j = arr[i].size()-1; j >= 0; j--){
                    num = i * m + j;
                    if(map.containsKey(num)){
                        arr[i].remove(j);
                    }
                }
            }
            map = new HashMap<>();//맵 초기화
        }

        for(int i = 0; i < n; i++){
            answer -= arr[i].size();//(삭제한 블록 수) = (원래 블록 수) - (남아 있는 블록 수)
        }

        return answer;
    }
}
