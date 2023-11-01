package Programmers;
import java.util.*;

public class InterceptionSystem {
    //요격 시스템
    public int solution(int[][] targets) {
        int answer = 0;
        int len = targets.length;

        Arrays.sort(targets, (o1, o2) -> Integer.compare(o1[0], o2[0]));//미사일 앞부분 위치(s) 기준으로 배열 정렬
        int m1s = targets[0][0];//맨 앞 미사일을 기준으로 삼는다
        int m1e = targets[0][1];
        answer += 1;//맨 앞 미사일과 범위가 겹치는 미사일을 요격할 것이므로 미리 1 증가.

        for(int i = 1; i < len; i++){
            int m2s = targets[i][0];
            int m2e = targets[i][1];
            if(m1s <= m2s && m1e >= m2e){//기준 미사일 범위 안에 들어오면 더 짧은 미사일이라는 의미. 이 짧은 미사일과 겹치는 미사일들을 함께 요격하기 위해 기준 미사일 변경
                m1s = m2s;
                m1e = m2e;
            }
            else if(m1e <= m2s){//기준 미사일 범위 밖이면 기준 미사일 변경하고, 새로운 미사일을 요격할 것이므로 1 증가
                m1s = m2s;
                m1e = m2e;
                answer += 1;
            }
        }
        return answer;
    }
}