package Programmers;
import java.util.*;
public class ParenthesisConversion {
    // 괄호 변환
    public String solution(String p) {
        String answer = "";
        if(p.length() == 0) return "";//1. 입력이 빈 문자열인 경우, 빈 문자열 반환
        answer = answer + rightEven(p);//재귀 함수 이용
        return answer;
    }
    String rightEven(String p){
        int open = 0;// '(' 개수 세기
        int close = 0;// ')' 개수 세기
        int len = p.length();
        int index = -1;
        if(len == 0) return "";
        for(int i = 0; i < len; i++){//가장 작은 균형잡힌 괄호 문자열 찾기
            if(p.charAt(i) == '(') open += 1;
            else if(p.charAt(i) == ')') close += 1;
            if(close == open) {//두 수의 값이 같으면 가장 작은 균형잡힌 괄호 문자열을 찾은 것.
                index = i+1;//substring으로 u와 v를 나누어 줄것임.
                break;
            }
        }
        String result = "";
        String u = p.substring(0, index);//2. 문자열 2를 "균형잡힌 괄호 문자열" u, v로 분리.
        String v = p.substring(index);

        if(check(u)) {//3. u가 "올바른 괄호 문자열"이라면
            result = result + u;
            result = result + rightEven(v);//문자열 v에 대해 1단계부터 다시 수행. 수행한 결과 문자열을 u에 이어 붙인 후 반환
            return result;
        }
        else{//4. u가 "올바른 괄호 문자열"이 아니라면
            result = "(" + rightEven(v) + ")";// '('를 붙이고, v에 대해 1단계부터 재귀적으로 수행한 결과 분자열을 이어붙이고, ')'를 이어 붙임.
            u = u.substring(1, u.length()-1);//u의 첫 번째와 마지막 문자를 제거하고,
            result = result +rev(u);//u의 나머지 괄호 방향을 뒤집어서 뒤에 이어 붙이기
            return result;//반환
        }
    }

    String rev(String s){//괄호 방향 뒤집는 함수
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')') result = result + '(';
            else if(s.charAt(i) == '(') result = result + ')';
        }
        return result;
    }

    boolean check(String s){//"올바른 괄호 문자열"인지 확인하는 함수
        int top = 0;//스택의 포인터로 생각함.
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') top += 1;//여는 괄호면 +1
            else if(s.charAt(i) == ')') top -= 1;//닫는 괄호면 -1
            if(top < 0) return false;//중간에 0보다 작아지면 올바르지 않는 것. 예: ())) top 값이 -2
        }
        if(top == 0) return true;//0이면 올바른 문자열
        else return false;//아니면 올바르지 않은 문자열
    }
}
