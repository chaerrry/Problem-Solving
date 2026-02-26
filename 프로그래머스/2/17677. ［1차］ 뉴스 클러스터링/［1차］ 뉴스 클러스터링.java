import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        // 소문자 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 두 글자씩 끊어서 리스트 만들기
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();

        // A 자르기
        for (int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            // 영문자만 유효
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                A.add("" + c1 + c2);
            }
        }

        // str2 자르기
        for (int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);

            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                B.add("" + c1 + c2);
            }
        }

        // 둘 다 공집합이면 65536 반환
        if (A.size() == 0 && B.size() == 0) {
            return 65536;
        }

        // 교집합
        boolean[] used = new boolean[B.size()];
        int result = 0;

        for (int i = 0; i < A.size(); i++) {

            for (int j = 0; j < B.size(); j++) {
                if (!used[j] && A.get(i).equals(B.get(j))) {
                    used[j] = true;
                    result++;
                    break;  
                }
            }
        }
        // 합집합
        int result2 = A.size() + B.size() - result;

        double result3 = (double) result / result2;

        return (int) (result3 * 65536);
    }
}