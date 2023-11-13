package Programmers;
import java.util.*;

public class FurthestNode {
    //가장 먼 노드
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = -1;
        Queue<Integer> q = new LinkedList<Integer>();
        int len = edge.length;
        int[] distance = new int[n+1];
        ArrayList<Integer>[] nbs = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++){
            nbs[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < len; i++){//이웃 노드들 저장
            nbs[edge[i][0]].add(edge[i][1]);
            nbs[edge[i][1]].add(edge[i][0]);
        }

        q.add(1);//1번 노드와의 최단거리가 가장 긴 노드들을 찾을 것임.
        while(q.size() > 0){
            int now = q.poll().intValue();
            int l = nbs[now].size();
            for(int i = 0; i < l; i++){//이웃 노드들 탐색
                int num = nbs[now].get(i).intValue();
                if(distance[num] != 0){//방문한 적이 있는 노드인데 현재 노드에서 방문하는 것이 거리가 더 짧을 때
                    if(distance[now] + 1 < distance[num]){
                        distance[num] = distance[now] + 1;//해당 노드의 1번 노드와의 최단 거리 바꿔치기
                        q.add(num);//해당 노드의 이웃 노드들을 방문할 것임.
                    }
                }
                else{//방문한 적이 없는 노드
                    distance[num] = distance[now] + 1;//거리 저장
                    q.add(num);//해당 노드의 이웃 노드들을 방문할 것임.
                }
            }
        }

        for(int i = 2; i < n+1; i++){
            if(max == distance[i]) answer += 1;//최장거리랑 같으면 답 증가
            else if(max < distance[i]){//새로운 최장 거리가 나타나면
                answer = 1;//답 초기화
                max = distance[i];//최장 거리 바꿔치기
            }
            //System.out.println("distance: "+distance[i]+", i: "+i);
        }

        return answer;
    }
}
