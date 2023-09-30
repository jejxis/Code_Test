package Programmers;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> map = new HashMap<>();
        int length = plays.length;
        for(int i = 0; i < length; i++){
            String genre = genres[i];
            if(map.containsKey(genre)){
                Genre g = map.get(genre);
                g.save(i, plays[i]);
                map.put(genre, g);
            }
            else{
                Genre g = new Genre();
                g.save(i, plays[i]);
                map.put(genre, g);
            }
        }
        ArrayList<Genre> gal = new ArrayList<>(map.values());
        Collections.sort(gal);
        ArrayList<Integer> il = new ArrayList<>();
        for(int i = 0; i < gal.size(); i++){
            Genre g = gal.get(i);
            int bn = g.bn;
            int sn = g.sn;
            if(bn > -1) il.add(bn);
            if(sn > -1) il.add(sn);
        }
        int[] answer = il.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
class Genre implements Comparable<Genre>{
    int p = 0; // 해당 장르 재생수
    int bn = -1; // 장르 내 최다 재생된 노래
    int bp = -1; // 장르 내 최다 재생된 노래의 재생수
    int sn = -1; // 장르 내 두번째로 많이 재생된 노래
    int sp = -1; // 장르 내 두번째로 많이 재생된 노래의 재생수

    public int compareTo(Genre g){ // p를 기준으로 내림차순
        if(g.p > p) return 1;
        else if(g.p == p) return 0;
        else return -1;
    }

    public void save(int number, int play){//노래의 고유번호와 재생된 횟수
        p = p + play;
        if(play > bp){
            sn = bn;
            sp = bp;
            bn = number;
            bp = play;
        }
        else if(play == bp){
            sn = number;
            sp = play;
        }
        else if(play > sp){
            sn = number;
            sp = play;
        }
    }
}