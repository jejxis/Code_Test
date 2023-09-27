package Programmers;

public class TargetNumber {
    /* 배열 요소마다 더하고 빼기 모두 수행하며 경우의 수 찾기
    * */
    public int solution(int[] numbers, int target) {
        //int l = numbers.length;
        int now = 0;// target에 도달하기 위해 현재 더하거나 뺀 결과
        int answer = 0;
        answer = answer + sol(numbers, target, 0, now);
        return answer;
    }
    public int sol(int[] numbers, int target, int index, int now){//index: 배열의 어느 요소를 보는지 알려주는 인덱스
        if(index == numbers.length) return 0;
        int find = 0;//찾은 경우의 수
        //minus.. 먼저 빼보기
        int mn = now - numbers[index];
        if(mn == target && index == numbers.length -1) return 1;// 맨 마지막 인덱스이고, target과 값이 같다면 1반환
        else find = find + sol(numbers, target, index + 1, mn);// 그렇지 않다면 현재 값과 함께 다음 인덱스를 넘김.
        //plus.. 더해보기
        int pn = now + numbers[index];
        if(pn == target && index == numbers.length -1) return 1;// 맨 마지막 인덱스이고, target과 값이 같다면 1반환
        else find = find + sol(numbers, target, index + 1, pn);// 그렇지 않다면 현재 값과 함께 다음 인덱스를 넘김.

        return find;
    }
}
