package Programmers;

public class FineRectangle { // 멀쩡한 사각형
    //기울기를 이용하여 대각선 밑의 멀쩡한 사각형을 세는 방식
    public long solution(int w, int h) {
        long count = 0;
        for(int i = 0; i < w; i++){
            //예시에서 주어진 사각형을 좌우반전 시키고 대각선을 y = ax 꼴로 생각해서 i값을 넣어가며 대각선 밑의 사각형을 센다.
            count = count + ((long)h * i / w);//h 앞에 long 붙여줘야 함. 자료형 때문에 오답 발생함.
        }
        long answer = count * 2;// 직사각형은 대각선을 기준으로 대칭으로 곱하기 2.
        return answer;
    }
}
