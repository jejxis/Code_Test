package Programmers;
import java.util.*;
public class DiscController {
    //디스크 컨트롤러
    public int solution(int[][] jobs) {
        int answer = 0;//정답
        int now = 0;//현재 시간
        int sum = 0;//소요시간 합
        ArrayList<MyJob> al = new ArrayList<MyJob>();//할 일 목록

        for(int i = 0; i < jobs.length; i++){
            al.add(new MyJob(jobs[i][0], jobs[i][1]));//할일 목록 저장
        }

        al.sort(Comparator.naturalOrder());//요청 시간 순으로 정렬

        while(al.size()>0){//할 일이 남아 있는 동안 반복
            MyJob j = al.get(0);//맨 처음 요청 들어온 일 가져오기
            int index = 0;
            if(j.at >= now){//현재 시각 이후에 들어온 일일 때
                for(int i = 1; i < al.size()&& al.get(i).at == j.at; i++){//j와 같은 요청시간이 있는지 찾아보기
                    if(j.ing > al.get(i).ing ) {j = al.get(i); index = i;}//j와 같이 요청이 들어왔는데 처리 시간이 더 짧으면 그 일을 j에 저장
                }
                now = j.at + j.ing;//기다리는 시간이 없으므로 now는 요청시각에 처리 시간을 더한 값
                sum += j.ing;//소요 시간에는 처리 시간만 더한다.
                al.remove(index);//처리한 일 삭제
            }
            else{//현재 시각 전에 들어온 일일 때
                for(int i = 1; i < al.size()&& al.get(i).at < now; i++){
                    if(j.ing > al.get(i).ing ) {j = al.get(i); index = i;}//가장 처리 시간이 짧은 일을 고른다.
                }
                now += j.ing;//현재 시각에 처리 시간 더한 값을 더해준다.
                sum += now - j.at;//소요시간에 (현재시각 now에서 요청 시간을 빼준 값)을 더해준다.
                al.remove(index);//처리한 일 삭제
            }
        }

        answer = (int)Math.floor(sum / jobs.length);//소수점 이하 버리기
        return answer;
    }
}
class MyJob implements Comparable<MyJob>{
    int at = 0;//요청 시각
    int ing = 0;//처리하는 데 걸리는 시간

    public MyJob(int at, int ing){
        this.at = at;
        this.ing = ing;
    }

    @Override
    public int compareTo(MyJob job){// 요청 시간 순으로 정렬. 요청시간을 1순위로 비교하고 걸리는 시간을 2순위로 비교했으면 좋았을 것 같다.
        if(this.at < job.at) return -1;
        else if(this.at == job.at) return 0;
        else return 1;
    }
}