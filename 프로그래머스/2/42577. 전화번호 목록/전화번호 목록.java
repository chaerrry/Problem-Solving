import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 접두사로 인접
        Arrays.sort(phone_book);
        
        // 뭔가 시작점에 값이 있는지 없는지를 찾는게 있을것같은데...
        // 메소드를 모르겠어서...좀 비효율적으로 짜야만할것같은데...
        
        // 배열의 마지막은 더 비교할 값이 없으므로 제외
        for(int i = 0; i < phone_book.length - 1; i++){
            String a = phone_book[i];
            String b = phone_book[i+1];
            
            boolean answer = true;
            // 더 긴값이 접두사로 올 수 없음
            if(a.length() > b.length()){
                continue;
            }
            
            for(int j = 0; j < a.length(); j ++){
                if(a.charAt(j) != b.charAt(j)){
                    answer = false;
                    break;
                }
            }
            
            if(answer)
                return false;
        }

        return true;
    }
}