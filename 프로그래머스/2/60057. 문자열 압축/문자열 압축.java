import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int answer1 = s.length();
        
        for(int i = 1; i <= answer/ 2; i++){
            int cnt = 1;
            String word = "";
            String target = s.substring(0, i);
        
            for(int j = i; j <= answer; j= j+i){
                int tnum = Math.min(answer, j+i);
                String comword = s.substring(j, tnum);
                boolean compare = comword.equals(target);
                if(compare){
                    cnt++;
                }else {
                    if(cnt > 1){
                        word += cnt;
                        cnt = 1;
                    }   
                    word += target;
                    target = comword;
                }
            }
            // 오류난 이유
           // 마지막 조각은 따로 붙여줘야함
            word += target;
            answer1 = Math.min(answer1, word.length());
        }
        return answer1;
    }
}