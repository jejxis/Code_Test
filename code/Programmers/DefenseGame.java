package Programmers;
import java.util.*;

public class DefenseGame {
    //디펜스 게임
    //참고한 해설: https://school.programmers.co.kr/questions/43442
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int attack = k;//쓸 수 있는 무적권 수
        int people = n;//남아있는 병사 수
        int len = enemy.length;//라운드 수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//우선순위 큐. 내림차순

        if(attack >= len)//무적군 수가 라운드 수 이상일 때 라운드 수 반환
            return len;

        for(int i = 0; i < len; i++){//라운드 돌면서
            people -= enemy[i];//적의 수만큼 병사 수 감소
            pq.add(enemy[i]);//적의 수를 우선순위 큐에 저장
            if(people < 0){//병사수가 0보다 작을 때
                if(attack > 0){//무적권을 쓸 수 있으면
                    people += pq.poll().intValue();//지난 라운드에서 가장 많았던 적의 수를 다시 더해줌.
                    attack -= 1;//무적권 감소
                }
                else{//무적권을 쓸 수 없으면
                    break;//반복문 탈출
                }
            }
            answer += 1;//이번 라운드를 막은 것이 됨.
        }

        return answer;
    }
}
