import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 접두사로 인접
        Arrays.sort(phone_book);
        
        // 배열의 마지막은 더 비교할 값이 없으므로 제외
        for(int i = 0; i < phone_book.length - 1; i++){

            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }
        return true;
    }
}