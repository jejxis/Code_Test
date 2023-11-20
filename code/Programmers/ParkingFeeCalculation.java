package Programmers;
import java.util.*;
public class ParkingFeeCalculation {
    //주차 요금 계산
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> map = new HashMap<>();//차량번호별 입차 시 시간 저장. 출차 시는 "O" 저장
        ArrayList<String> carNumList = new ArrayList<>();//차량 번호 저장
        HashMap<String, Integer> timeMap = new HashMap<>();//차량번호별 누적 주차 시간 저장
        int len = records.length;
        String[] record;
        String[] at1;
        String[] at2;
        for(int i = 0; i < len; i++){
            record = records[i].split(" ");
            if(map.containsKey(record[1])){//이미 해당 번호가 있을 때
                if(map.get(record[1]).equals("O")){//입차할 때
                    map.put(record[1], record[0]);//입차 시각 저장
                }
                else{//출차할 때..여기서 시간 계산
                    at2 = record[0].split(":");//출차 시각
                    at1 = map.get(record[1]).split(":");//입차 시각
                    int time = 0;
                    if(timeMap.containsKey(record[1])) {//누적 시간이 존재할 때
                        time += timeMap.get(record[1]).intValue();//더해준다.
                    }
                    time += (at2[0].charAt(0)-'0') * 600 + (at2[0].charAt(1)-'0') * 60 + (at2[1].charAt(0)-'0')*10 + at2[1].charAt(1)-'0' - ((at1[0].charAt(0)-'0') * 600 + (at1[0].charAt(1)-'0') * 60 + (at1[1].charAt(0)-'0')*10 + at1[1].charAt(1)-'0');
                    timeMap.put(record[1], time);//시간계산
                    map.put(record[1], "O");//출차 완료 표시
                }
            }
            else{//없을 때
                carNumList.add(record[1]);//차량 번호 저장
                map.put(record[1], record[0]);//입차 시각 저장
            }
        }
        Collections.sort(carNumList);//차량 번호순대로 정렬
        int s = map.size();
        int[] answer = new int[s];
        for(int i = 0; i < s; i++){
            int time;
            String num = carNumList.get(i);
            if(map.get(num).equals("O")){//해당 차량의 마지막 기록이 출차일 때
                time = timeMap.get(carNumList.get(i)).intValue();//누적 시간이 모두 계산되어있을 것이므로 그대로 time에 저장
            }
            else{//마지막 기록이 입차일 때.. 시간 계산 후 요금 책정
                at2 = "23:59".split(":");
                at1 = map.get(num).split(":");//입차 시각부터 23:59까지의 시간을 계산한 뒤,
                time = (at2[0].charAt(0)-'0') * 600 + (at2[0].charAt(1)-'0') * 60 + (at2[1].charAt(0)-'0')*10 + at2[1].charAt(1)-'0' - ((at1[0].charAt(0)-'0') * 600 + (at1[0].charAt(1)-'0') * 60 + (at1[1].charAt(0)-'0')*10 + at1[1].charAt(1)-'0');
                if(timeMap.containsKey(num)){//누적 시간이 존재하면
                    time += timeMap.get(num).intValue();//마저 더해준다.
                }
            }
            if(time <= fees[0]) answer[i] = fees[1];//누적 시간이 기본시간 보다 적으면 기본 요금 책정
            else{//아닐 경우
                int cut = (time - fees[0]) / fees[2];//단위 요금에 곱해줄 시간을 구한다. 시간에 대해서는 올림을 해줘야 한다.
                if(cut * fees[2] < time - fees[0]){//올림을 해줘야 할 상황일 때
                    answer[i] = fees[1] + (cut+1) * fees[3];//올려서 곱해서 더해준다.
                }
                else answer[i] = fees[1] + cut * fees[3];//아닐 때는 그냥 곱해서 더해준다.
            }
        }
        return answer;
    }
}
