package Programmers;
import java.util.*;
public class DividingElectricGridInTwo {
    //전력망을 둘로 나누기
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] nbs = new ArrayList[n+1];//각 송전탑의 이웃 송전탑 저장
        Queue<Integer> q = new LinkedList<>();
        int answer = 200;
        for(int i = 0; i <= n; i++){//각 송전탑에 ArrayList 할당
            nbs[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < n-1; i++){//서로 이웃하는 송전탑 저장
            nbs[wires[i][0]].add(wires[i][1]);
            nbs[wires[i][1]].add(wires[i][0]);
        }
        for(int i = 0; i < n-1; i++){
            int cut = wires[i][0];//잘라낼 송전탑
            int rem = wires[i][1];//남은 송전탑
            q.add(rem);//남은 송전탑 큐에 추가
            int count = 1;//큐에 추가했으므로 남길 송전탑 개수는 1.
            boolean[] visited = new boolean[101];//송전탑 방문 확인용 배열
            visited[rem] = true;//큐에 넣었으므로 탐색한 것.
            visited[cut] = true;//버리는 곳은 더 이상 탐색하지 않기 위함.
            while(!q.isEmpty()){
                int now = q.poll().intValue();//큐에 있는 걸 꺼내서
                int size = nbs[now].size();
                for(int j = 0; j < size; j++){//이웃 송전탑 살펴보고 안 가봤으면 큐에 넣기
                    int val = nbs[now].get(j).intValue();
                    if(visited[val]) continue;
                    q.add(val);
                    count += 1;
                    visited[val] = true;
                    //System.out.println("now: "+now+",val: "+val+", count: "+count);
                }
            }
            int temp = Math.abs(n - count - count);
            if(temp < answer) answer = temp;
        }
        return answer;
    }
}
