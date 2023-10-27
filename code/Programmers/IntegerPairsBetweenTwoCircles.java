package Programmers;

public class IntegerPairsBetweenTwoCircles {
    // 두 원 사이의 정수쌍
    public long solution(int r1, int r2) {
        long answer = 0;
        // 1사분면의 점의 개수 구하기. x축, y축 위의 점 제외
        for(long i = 1; i < r1; i++){// x 좌표가 1부터 r1-1까지 일 때
            double y1 = Math.ceil(Math.sqrt((long)r1 * r1 - i*i));//작은 원의 y좌표 소수점 올림
            double y2 = Math.floor(Math.sqrt((long)r2 * r2 - i*i));//큰 원의 y 좌표 소수점 버림
            answer += y2-y1+1;
        }
        for(long i = r1; i < r2; i++){// x 좌표가 r1부터 r2-1까지 일 때
            double y2 = Math.floor(Math.sqrt((long)r2 * r2 - i*i));//큰 원의 y 좌표 소수점 버림
            answer += (y2);
        }
        answer *= 4;// 전체 사분면의 점의 개수
        answer += (r2 - r1 + 1) * 4;//x축, y축 위의 점들 더하기
        return answer;
    }
}
