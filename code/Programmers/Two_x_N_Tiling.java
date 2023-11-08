package Programmers;

public class Two_x_N_Tiling {
    //2 x n 타일링
    //가로 길이를 기준으로 1과 2를 어떻게 배치할지가 관건이라고 생각했음.
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;// 가로길이가 1인 바닥을 채우는 방법
        dp[2] = 2;// 가로길이가 2인 바닥을 채우는 방법. 1,1 과 2 총 두 가지.
        for(int i = 3; i < n+1; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
            // 가로길이 3으로 예를 들면 dp[1]에서 2를 이어붙이는 방법과 dp[2]에서 1을 이어붙이는 방법이 있음.
        }
        answer = dp[n];
        return answer;
    }
}
