package Programmers;
import java.util.*;
public class ThatSongJustNow {
    //방금그곡
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        ArrayList<Music> musics = new ArrayList<>();
        String result = "";

        for(int i = 0; i < m.length(); i++){//m에서 #이 붙은 음을 소문자로 만들어준다. 예) C# -> c
            if(m.charAt(i) == '#'){
                char c = m.charAt(i-1);
                result = result.substring(0, result.length()-1) + Character.toString(c + ('a' - 'A'));
            }
            else result = result + Character.toString(m.charAt(i));
        }

        for(int i = 0; i < musicinfos.length; i++){//음악 목록 저장
            String[] info = musicinfos[i].split(",");
            Music music = new Music(info[0], info[1], info[2], info[3]);
            musics.add(music);
        }
        int pt = -1;//result를 포함하는 노래가 둘 이상일 때 재생시간이 더 긴 노래를 저장하기 위해.
        for(int i = 0; i < musics.size(); i++){//각 음악마다 재생시간 동안 들을 수 있는 음이 result를 포함하는지 확인한다.
            Music music = musics.get(i);
            if(music.playscore.contains(result)){
                if(music.playtime > pt){ pt = music.playtime; answer = music.title;}
            }
        }

        return answer;
    }
}
class Music{
    String start = "";//시작 시각
    String end = "";//끝나는 시각
    String title = "";//제목
    String score = "";//악보
    int playtime = 0;//재생 새간
    String playscore = "";//재생시간 동안 들리는 음

    Music(String s, String e, String t, String sc){
        start = s;
        end = e;
        title = t;
        score = sc;
        playtime = getPlayTime(s, e);
        playscore = getPlayScore(playtime, score);
        //System.out.println(playscore);
    }

    int getPlayTime(String s, String e){//재생 시간 분 단위로 구하기
        String[] sar = s.split(":");
        String[] ear = e.split(":");
        int sh = Integer.parseInt(sar[0]);
        int sm = Integer.parseInt(sar[1]);
        int eh = Integer.parseInt(ear[0]);
        int em = Integer.parseInt(ear[1]);

        if(eh == sh){//시간 단위가 같을 때
            return em - sm;//분 단위 차 반환
        }
        else if(eh > sh){//끝나는 시각의 시간 단위가 시작 시각의 시간 단위보다 클 때
            if(em < sm){ eh -= 1; em += 60;}//평범하게 시간 연산 해준다.
            return (eh - sh)*60 + (em - sm);
        }
        else{//자정을 넘기는 경우
            return eh * 60 + em + (23 - sh) * 60 + (60 - sm);//끝나는 시각의 시간*60과 분을 더하고 거기에 24:00에서 시작 시각을 뺀 값을 더한다.
        }
    }

    String getPlayScore(int time, String score){
        int i = 0;
        int j = 0;
        String st = "";
        String result = "";
        for(int k = 0; k < score.length(); k++){// #이 붙은 음을 소문자로 만들어준다. 예) C# -> c
            if(score.charAt(k) == '#'){
                char c = score.charAt(k-1);
                st = st.substring(0, st.length()-1) + Character.toString(c + ('a' - 'A'));
            }
            else st = st + Character.toString(score.charAt(k));
        }
        int len = st.length();
        while(i != time){//재생 시간 동안 듣는 음들을 문자열로 만든다.
            if(j >= len){ j = j - len;}
            result = result + Character.toString(st.charAt(j));
            i++;
            j++;
        }
        return result;
    }
}