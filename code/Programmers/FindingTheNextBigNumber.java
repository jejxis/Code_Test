package Programmers;
import java.util.*;

public class FindingTheNextBigNumber {
    //뒤에 있는 큰 수 찾기
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int len = numbers.length;
        int[] answer = new int[len];
        int num;

        answer[len - 1] = -1;//배열의 맨 뒤에 있는 수는 '뒤에 있는 큰 수'가 없으므로 -1
        stack.push(numbers[len-1]);

        for(int i = len-2; i >= 0; i--){//배열의 뒤에서부터 반복문 실행
            while(!stack.isEmpty()){//'뒤에 있는 큰 수'를 찾을 때까지 스택이 빌 때까지 반복
                num = stack.pop().intValue();//'뒤에 있는 큰 수' 후보 중 가장 가까이 있는 수
                if(num > numbers[i]){//현재 숫자보다 크다. -> '뒤에 있는 큰 수' 찾음.
                    answer[i] = num;//해당 칸에 '뒤에 있는 큰 수' 저장
                    stack.push(num);//현재 칸 보다 앞에 있는 수들의 '뒤에 있는 큰 수'가 될 수 있으므로 스택에 저장
                    break;//반복문 탈출
                }
            }
            if(stack.isEmpty()) {//스택이 앞의 while문을 빠져나온 경우
                answer[i] = -1;//해당 칸 뒤에 해당 칸의 수보다 더 큰 수가 없으므로 -1 저장.
            }
            stack.push(numbers[i]);//해당 칸 앞의 칸의 '가장 가까운' '뒤에 있는 큰 수'가 될 수 있으므로 스택에 저장
        }
        return answer;
    }
}
