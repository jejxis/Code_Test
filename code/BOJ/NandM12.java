package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class NandM12 {
    //N과 M(12) 실버2
    int[] arr;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr = Arrays.stream(arr).distinct().toArray();//중복 제거

        Arrays.sort(arr);//배열 정렬
        select(m, new int[m], m, 0, arr.length);
    }

    public void select(int m, int[] result, int count, int index, int n){//m: 뽑는 숫자의 수, result: 뽑은 숫자들, count: 더 뽑아야 하는 숫자의 수, index: arr의 어느 인덱스 숫자를 가져올 건지, n: arr의 길이
        if(count == 0) {//뽑을 만큼 뽑았을 때
            for(int i = 0; i < m; i++){//결과 출력
                System.out.print(result[i]);
                System.out.print(' ');
            }
            System.out.println();
            return;
        }
        if(index == n) return;//인덱스 범위 벗어났을 때 종료
        result[m-count] = arr[index];//m-count: result에 숫자를 넣을 인덱스
        select(m, result,count-1, index, n);//이 다음에 같은 숫자 더 뽑을 경우
        select(m, result, count, index+1, n);//다른 숫자로 덮어 쓰는 경우
    }

    public static void main(String[] args) throws Exception{
        new NandM12().solution();
    }
}
