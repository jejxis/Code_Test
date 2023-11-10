package Programmers;
import java.util.*;

public class OpenChatRoom {
    //오픈채팅방
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();//유저 아이디와 닉네임 저장
        String[] temp;//레코드를 공백 기준으로 분할했을 때 저장할 배열
        for(int i = 0; i < record.length; i++){
            temp = record[i].split(" ");//공백 기준으로 분할
            if(temp.length == 3){//누군가가 들어오거나 닉네임을 변경할 때
                map.put(temp[1], temp[2]);//유저 아이디와 닉네임 저장
            }
        }
        List<String> al = new ArrayList<>();// 정답을 저장할 리스트
        for(int i = 0; i < record.length; i++){//레코드 길이만큼 반복
            temp = record[i].split(" ");// 공복 기준으로 분할하여
            if(temp[0].equals("Enter")){//누군가 들어왔으면
                al.add(map.get(temp[1])+"님이 들어왔습니다.");//유저 아이디로 맵에서 닉네임을 꺼내 문장을 만들어 저장
            }
            else if(temp[0].equals("Leave")){//누군가 나갔으면
                al.add(map.get(temp[1])+"님이 나갔습니다.");// 유저 아이디로 맵에서 닉네임을 꺼내 문장을 만들어 저장
            }
        }

        String[] answer = new String[al.size()];
        al.toArray(answer);//어레이리스트를 배열로 전환
        return answer;
    }
}
