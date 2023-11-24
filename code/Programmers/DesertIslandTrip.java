package Programmers;
import java.util.*;

public class DesertIslandTrip {
    //무인도 여행
    public int[] solution(String[] maps) {
        int[] answer = {};
        int w = maps[0].length();//직사각형 가로길이
        int h = maps.length;//직사각형 세로길이
        int[] dx = {-1, 0, 1, 0};//주변 탐색용
        int[] dy = {0, -1, 0, 1};
        int sum = 0;//땅들의 값의 합
        boolean[][] visited = new boolean[h][w];//방문 여부
        ArrayList<Integer> al = new ArrayList<>();//땅들의 값의 합을 저장할 곳.
        Queue<int[]> q = new LinkedList<>();//탐색용 큐
        for(int i = 0; i < h; i++){//칸 하나하나 돌아봄
            for(int j = 0; j < w; j++){
                if(visited[i][j]) continue;//방문한 적 있으면 다음 칸으로 넘어감
                char c = maps[i].charAt(j);//어떤 칸인지
                visited[i][j] = true;//저장했다고 표시해두고
                if(c == 'X') {continue;}//바다면 다음칸으로
                int[] node = {i, j};//아니면
                q.add(node);//큐에 저장
                sum = maps[i].charAt(j) - '0';//칸에 적힌 값 저장
                while(!q.isEmpty()){//큐가 비기 전까지
                    int[] arr = q.poll();//큐에서 하나 꺼냄
                    for(int k = 0; k < 4; k++){//이웃한 칸들을 살핌
                        int x = arr[0] + dx[k];
                        int y = arr[1] + dy[k];
                        if(x < 0 || x >= h || y < 0 || y >= w) continue;
                        if(visited[x][y]) continue;//방문한 적 있으면 다음 칸으로
                        visited[x][y] = true;//방문 표시
                        if(maps[x].charAt(y) == 'X') {continue;}//바다면 다음 칸으로
                        sum += maps[x].charAt(y) - '0';//아니면 값 더해주기
                        int[] node2 = {x, y};//큐에 현재 방문 한 칸 저장
                        q.add(node2);
                    }
                }
                al.add(sum);//합을 저장
            }
        }
        if(al.size() == 0) {//저장된 합이 없으면
            answer = new int[1];
            answer[0] = -1;
            return answer;// [-1] 반환
        }
        al.sort(Comparator.naturalOrder());//정렬하고 배열로 변환해 반환
        answer = al.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
