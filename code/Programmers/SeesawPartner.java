package Programmers;
import java.util.HashMap;
public class SeesawPartner {
    //시소 짝꿍
    public long solution(int[] weights) {
        long answer = 0;
        int length = weights.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(weights[0], 1);// 무게와 해당 무게 개수 저장
        boolean four = false;// 4로 나누어떨어지는지 저장.. 333, 666 같은 숫자 대비(666은 4로 나누어 떨어지진 않지만 333*4 == 666*2 가 성립한다.)
        for(int i = 1; i < length; i++){
            int num = weights[i];
            if(map.get(num) != null) {answer = answer + map.get(num);}//1
            if(map.get(num*2) != null) {answer = answer + map.get(num*2);}//2
            if(num % 3 == 0){
                if(map.get(num*2/3) != null) {answer = answer + map.get(num*2/3);}// 2/3
                if(map.get(num*4/3) != null) {answer = answer + map.get(num*4/3);}// 4/3
            }
            if(num % 4 == 0){
                if(map.get(num*2/4) != null) {answer = answer + map.get(num*2/4); four = true;}// 1/2 == 2/4... 4로 나누어떨어지므로 four에 true 저장
                if(map.get(num*3/4) != null) {answer = answer + map.get(num*3/4);}// 3/4
            }
            if(num % 2 == 0) {
                if(map.get(num/2) != null && !four) {answer = answer + map.get(num/2);}// 1/2 == 2/4.... four가 false인 경우에 2로 나눠서 확인해본다.
                if(map.get(num*3/2) != null) {answer = answer + map.get(num*3/2);}// 3/2
            }

            if(map.containsKey(num)){//해당 무게가 존재하면
                int value = map.get(num);
                map.put(num, value + 1);// 해당 무게 개수 + 1
            }
            else map.put(num, 1);// 그외에는 그냥 저장
            four = false;//four 다시 false로 초기화
        }
        return answer;
    }
}
