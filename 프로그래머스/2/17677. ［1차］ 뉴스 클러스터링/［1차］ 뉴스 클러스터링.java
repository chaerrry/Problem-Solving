import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        // 소문자 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 두 글자씩 끊어서 Map
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        
        // A 자르기
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            // 영문자만 유효
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                //A.add("" + c1 + c2);
                String compare = "" + c1 + c2;
                // 문자로 만든 후 map에 바로 비교후 value값에 갯수
                if(map1.containsKey(compare)){
                    map1.put(compare, map1.get(compare) + 1);
                }else {
                    map1.put(compare, 1);
                }
            }
        }

        // B 자르기
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);

            // 영문자만 유효
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                //A.add("" + c1 + c2);
                String compare = "" + c1 + c2;
                // 문자로 만든 후 map에 바로 비교후 value값에 갯수
                if(map2.containsKey(compare)){
                    map2.put(compare, map2.get(compare) + 1);
                }else {
                    map2.put(compare, 1);
                }
            }
        }

        // 둘 다 공집합이면 65536 반환
        //if (A.size() == 0 && B.size() == 0) {
        // map은 empty 사용
        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }

        // 교집합
        int min = 0;
        int max = 0;

        for(String key : map1.keySet()){
            int cnt1 = map1.get(key);
            
            if(map2.containsKey(key)){
                int cnt2 = map2.get(key);
                
                min += Math.min(cnt1, cnt2);
                max += Math.max(cnt1, cnt2);
            }else{
                max += cnt1;
            }
        }
        
        // b에만 있는값 찾기
        for(String key : map2.keySet()){
            if(!map1.containsKey(key)){
                max += map2.get(key);
            }
        }
        
        double result = (double) min / max;

        return (int) (result * 65536);
    }
}