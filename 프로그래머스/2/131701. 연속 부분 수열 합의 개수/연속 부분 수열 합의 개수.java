import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        // 원형수열 *2배열로 재배치
        int[] new_elements = new int[n*2];
        for(int i = 0; i < n*2; i++){
            new_elements[i] = elements[i%n]; // 나머지값으로 길이 늘리기
        }
        // 중복제거용 hashset
        Set<Integer> set = new HashSet<>();
        // 순서대로 끊어서 계산
        for(int i = 0; i < n ; i++){
            // 시작지점에서 모든 길이의 합 구하기
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += new_elements[i+j];
                set.add(sum);
            }
        }

        return set.size();
        
    
    }
}