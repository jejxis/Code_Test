package Programmers;
//문자열 압축
public class StringCompression {
    public int solution(String s) {
        int length = s.length();
        int answer = 1000;
        for(int i = 1; i <= length; i++){//단위의 크기 늘려나가기
            int tl = i;//임시 길이 저장(정답 후보)
            int count = 1;// 특정 문자열이 반복되는 개수 저장
            String standard = s.substring(0, i);//기준이 되는 문자열
            for(int j = i;; j = j + i){//단위대로 자르면서 반복횟수 세기, 길이까지 계산
                if(j + i > length) {tl = tl + (length - j); break;} // 단위보다 남은 문자열이 짧을 때 남은 문자열의 길이를 임시 길이에 더해준다.
                String now = s.substring(j, j+i);//기준 문자열 standard와 비교할 문자열
                if(now.equals(standard)){//두 문자열이 같으면
                    count = count + 1;//반복 되므로 더하기 1
                }
                else{//다를 경우
                    if(count == 1) ;//standard가 반복되지 않았으므로 아무 일도 하지 않는다.
                    else if(count < 10) tl = tl + 1;//반복횟수가 한 자리 수
                    else if(count < 100) tl = tl + 2;// 두 자리 수
                    else if(count < 1000) tl = tl + 3;// 세 자리 수
                    else tl = tl + 4;//문자열 s의 길이가 1000 이하이므로 네 자리 수
                    tl = tl + i;//현재 문자열 길이 저장
                    count = 1;//다시 초기화
                    standard = now;//standard에 now 저장
                }
            }
            // 길이가 i인 단위를 모두 돌고 나서 마지막에 반복된 문자열은 계산되지 않았으므로 여기서 계산한다.
            if(count == 1) ;// j for문의 else 문과 동일
            else if(count < 10) tl = tl + 1;
            else if(count < 100) tl = tl + 2;
            else if(count < 1000) tl = tl + 3;
            else tl = tl + 4;
            //System.out.println("i:"+i+", tl:"+tl+", answer:"+answer);
            //가장 짧은 길이를 찾아야 한다.
            if(tl < answer) answer = tl;
        }
        return answer;
    }
}
