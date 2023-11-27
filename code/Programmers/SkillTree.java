package Programmers;

public class SkillTree {
    //스킬트리
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int strlen = skill.length();//스킬순서 길이
        int arrlen = skill_trees.length;//주어진 스킬트리의 개수
        int index = 1;//스킬순서의 각 스킬이 몇번째에 등장하는지
        int check = 1;//주어진 스킬트리에서 스킬이 스킬순서에 포함된 스킬들 사이에서 몇 번째에 등장하는지
        boolean can = true;//스킬트리가 스킬 순서를 잘 지켰는지 여부
        int[] letter = new int[26];
        for(int i = 0; i < strlen; i++){//스킬 순서에서의 스킬 등장 순서 저장
            char c = skill.charAt(i);
            letter[c-'A'] = index;
            index += 1;
        }

        for(int i = 0; i < arrlen; i++){//각 스킬트리의
            int l = skill_trees[i].length();
            can = true;
            check = 1;
            for(int j = 0; j < l; j++){//스킬에 대해
                char c = skill_trees[i].charAt(j);
                if(letter[c-'A'] == check){//순서가 잘 지켜지면
                    check += 1;//다음 순서로
                }
                else if(letter[c-'A'] > check){//아직 나올 때가 아닌 스킬이 스킬순서의 다른 스킬들보다 먼저 나왔을 때
                    can = false;//순서를 지키지 못함
                    break;//반복문 탈출
                }
            }
            if(can) answer += 1;//해당 스킬트리가 스킬 순서를 잘 지켰으면 1 증가
        }
        return answer;
    }
}
