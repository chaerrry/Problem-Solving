import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        
        for(int i = 0; i < n; i++){
            answer = n-i;
            if(citations[i] >= answer){
                return answer;
            }
        }
        return 0;
    }
}