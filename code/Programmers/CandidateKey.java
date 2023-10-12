package Programmers;
import java.util.*;
public class CandidateKey {
    //후보키
    int answer = 0;
    int rows = 0;
    int cols = 0;
    boolean[] ck = new boolean[8];//후보키에 사용된 속성들 확인
    String[][] table;
    ArrayList<Integer> arr = new ArrayList<>();//조합의 종류를 저장할 곳.
    public int solution(String[][] relation) {
        rows = relation.length;//데이터 수
        cols = relation[0].length;//속성 수
        table = relation;//조합 구해서 Map으로 확인할 때 필요함.
        for(int i = 1; i <= cols; i++){
            nCr(ck, 0, cols, i);
        }
        return answer;
    }

    public void nCr(boolean[] visited, int depth, int n, int r){
        if(r == 0){
            HashMap<String, String> map = new HashMap<>();
            int sum = 0;//2진수로 생각해서 포함관계가 있는지 생각할 것임. 00001001 -> 0번 속성과 3번 속성으로 이루어진 후보키
            for(int i = 0; i < cols; i++){
                if(visited[i]) sum += 1<<i;//조합에 있는 해당 자리수를 1로 바꿔줌.
            }
            for(int i = 0; i < rows; i++){
                String s = "";
                for(int j = 0; j < cols; j++){
                    if(visited[j]){
                        s = s + table[i][j] + "/";// "/"를 붙이는 이유: 말은 안되지만 예시로 나이와 학번이 (2, 22) (22, 2)인 사람을 구별하기 위함. 중간에 슬래시를 안 넣으면 둘 다 222 라서 구분 못함.
                    }
                }
                map.put(s, "");
            }
            if(map.size() == rows){//map 크기과 rows가 같으면 중복되는 것이 없다는 뜻.
                boolean check = true;//포함관계가 없는지.
                if(arr.size() == 0) {arr.add(sum); answer += 1;}//arr 크기가 0이면 추가해 주자.
                else{
                    for(int i = 0; i < arr.size(); i++){
                        int num = arr.get(i);//arr의 요소를 하나씩 꺼내보며
                        if((num | sum) == sum || (num | sum) == num) {//비트연산 |를 해 포함 관계면
                            check = false;//false로 바꿔준다.
                        }
                    }
                    if(check){//포함 관계가 없을 때
                        arr.add(sum);
                        answer += 1;
                    }
                }

            }
            return;
        }

        if(depth == n) {
            return;
        }

        visited[depth] = true;
        nCr(visited, depth+1, n, r - 1);

        visited[depth] = false;
        nCr(visited, depth +1, n, r);
    }
}
