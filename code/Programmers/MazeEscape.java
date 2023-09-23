package Programmers;
import java.util.Queue;
import java.util.LinkedList;
//미로탈출
public class MazeEscape {
    int startX = -1;
    int startY = -1;
    int leverX = -1;
    int leverY = -1;
    int endX = -1;
    int endY = -1;
    int ls = -1;
    int es = -1;
    public int solution(String[] maps) {
        Queue<Node> q = new LinkedList<>();
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        int rows = maps.length;
        int cols = maps[0].length();

        boolean[][] v = new boolean[rows][cols];
        boolean[][] v2 = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                switch(maps[i].charAt(j)){
                    case 'S':
                        startX = i;
                        startY = j;
                        break;
                    case 'L':
                        leverX = i;
                        leverY = j;
                    case 'E':
                        endX = i;
                        endY = j;
                }
            }
        }

        //start -> lever
        q.add(new Node(startX, startY, 0));
        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i = 0; i < 4; i++){
                int x = n.x + dx[i];
                int y = n.y + dy[i];
                if(x < 0 || x >= rows || y < 0 || y >= cols) continue;
                if(v[x][y]) continue;
                char c = maps[x].charAt(y);
                if(c == 'X') continue;
                //System.out.print(x+", "+y+": "+c+" ");
                if(c == 'L'){
                    ls = n.s + 1;
                    q.clear();
                    break;
                }
                Node nn = new Node(x, y, n.s + 1);
                q.add(nn);
                v[x][y] = true;
                //System.out.println(n.s);
            }
        }
        if(ls == -1) return -1;

        //lever -> end
        q.add(new Node(leverX, leverY, ls));
        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i = 0; i < 4; i++){
                int x = n.x + dx[i];
                int y = n.y + dy[i];
                if(x < 0 || x >= rows || y < 0 || y >= cols) continue;
                if(v2[x][y]) continue;
                char c = maps[x].charAt(y);
                if(c == 'X') continue;
                //System.out.print(x+", "+y+": "+c+" ");
                if(c == 'E'){
                    es = n.s + 1;
                    q.clear();
                    break;
                }
                Node nn = new Node(x, y, n.s + 1);
                q.add(nn);
                v2[x][y] = true;
                //System.out.println(n.s);
            }
        }


        int answer = es;

        return answer;
    }
}
class Node{
    public Node(int x, int y, int s){
        this.x = x;
        this.y = y;
        this.s = s;
    }
    public int x;
    public int y;
    public int s;
}
