package Programmers;

public class SumOfConsecutiveSubsequences {
    //연속된 부분 수열의 합
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};//시작 인덱스, 끝 인덱스
        int len = sequence.length;// 주어진 수열의 길이
        int min = 1000001;// 부분수열의 길이는 최대 1000000이므로 더 큰 값을 넣어준다. sum==k를 만족하는 가장 짧은 부분수열의 길이
        int sum = sequence[0];//부분수열의 합
        int start = 0;//시작 인덱스
        int end = 0;//끝 인덱스
        while(start < len){//주어진 수열을 다 돌아본다.
            if(sum == k && min > end - start + 1){//sum과 k의 값이 같고 부분수열의 길이가 min보다 작을 때
                min = end - start + 1;//min 값 갱신
                answer[0] = start;//answer에 인덱스 저장
                answer[1] = end;
            }
            else if(sum > k){//sum 값이 k 보다 클 때
                sum -= sequence[start];//sum에서 start에 해당하는 값을 빼 주고
                start++;//start 값 갱신
                continue;//다음 반복 실시
            }

            if(end == len - 1) {//끝 인덱스가 수열의 끝일 때
                if(sum < k) break;// 더 이상 합을 감소시킬 수 없으므로 반복문 탈출
                sum -= sequence[start];//sum에서 start에 해당하는 값을 빼 주고
                start++;//start 값 갱신
            }
            else{//end와 sum 값 갱신
                end++;
                sum += sequence[end];
            }
            //System.out.println(start + " "+ end);
        }
        return answer;
    }
}
