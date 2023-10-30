package Programmers;

public class MakingBigNumber {
    //큰 수 만들기
    public String solution(String number, int k) {
        String answer = "";
        int max = 0;
        int maxindex = 0;
        int len = number.length();
        while(k > 0 && answer.length() != len - k){
            int maxplus = 0;
            for(int i = 0; i <= k; i++){//maxindex의 숫자를 포함하여 k+1개의 숫자를 살피며 가장 큰 수 찾기
                int num = number.charAt(maxindex + i) - '0';
                if(num > max){
                    max = num;
                    maxplus = i;
                }
            }
            k -= maxplus;//maxplus는 for문에서 버린 숫자의 수. 빼야할 숫자 개수가 줄어든다.
            maxindex += maxplus;//범위 내에서 가장 큰 수의 인덱스
            answer = answer + number.charAt(maxindex);//answer에 추가
            maxindex += 1;//그 다음 글자부터 다시 k+1기의 숫자를 살피며 가장 큰 수를 찾아야 함.
            max = 0;
        }
        if(maxindex < len && answer.length() != len - k) answer = answer + number.substring(maxindex);//버릴 만큼 버렸으면 남은 문자열 붙이기
        return answer;
    }
}