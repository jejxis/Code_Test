package Programmers;

public class VowelDictionary {
    /*[A, E, I, O, U]의 순서로, ?이 이들 중 한 문자라고 할 때,
    * ?로 시작하는 한 글자: 1
    * ?로 시작하는 두 글자: 5
    * ?로 시작하는 세 글자: 25
    * ?로 시작하는 네 글자: 125
    * ?로 시작하는 다섯 글자: 625
    * ?로 시작하는 모든 경우의 수: 781 */
    // 현재 n번째 글자가 ?일 때: answer = answer + (? 앞의 모든 알파벳으로 시작하는 모든 경우의 수) + (현재 읽은 ?. 그러니까 1)
    public int solution(String word) {
        int l = word.length();
        int answer = 0;
        for(int i = 0; i < l; i++){
            char c = word.charAt(i);
            switch(c){
                case 'A':
                    answer = answer + 1;
                    break;
                case 'E':
                    if(i == 0) answer = 781 + 1;
                    else if(i == 1) answer = answer + 156 + 1;
                    else if(i == 2) answer = answer + 31 + 1;
                    else if(i == 3) answer = answer + 6 + 1;
                    else answer = answer + 1 + 1;
                    break;
                case 'I':
                    if(i == 0) answer = 781 * 2 + 1;
                    else if(i == 1) answer = answer + 156 * 2 + 1;
                    else if(i == 2) answer = answer + 31 * 2 + 1;
                    else if(i == 3) answer = answer + 6 * 2 + 1;
                    else answer = answer + 2 + 1;
                    break;
                case 'O':
                    if(i == 0) answer = 781 * 3 + 1;
                    else if(i == 1) answer = answer + 156 * 3 + 1;
                    else if(i == 2) answer = answer + 31 * 3 + 1;
                    else if(i == 3) answer = answer + 6 * 3 + 1;
                    else answer = answer + 3 + 1;
                    break;
                case 'U':
                    if(i == 0) answer = 781 * 4 + 1;
                    else if(i == 1) answer = answer + 156 * 4 + 1;
                    else if(i == 2) answer = answer + 31 * 4 + 1;
                    else if(i == 3) answer = answer + 6 * 4 + 1;
                    else answer = answer + 4 + 1;
                    break;
            }

        }
        return answer;
    }
}
