class Solution {
    public String solution(String p) {
        
        // 조건 1
        if (p.equals("")) {
            return "";
        }
        
        int front = 0;
        int back = 0;
        int n = p.length();
        String answer = "";
        int chk = 0;
        
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '(') {
                front += 1;
            } else {
                back += 1;
            }
            
            if (front == back) {
                chk = i;
                break;
            }
        }
        
        String u = p.substring(0, chk + 1);
        String v = p.substring(chk + 1, n);
        
        int num = 0;
        boolean right = true;
        
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                num += 1;
            } else {
                num -= 1;
            }
            
            if (num < 0) {
                right = false;
                break;
            }
        }
        
        if (right) {
            answer += u;
            answer += solution(v);
        } else {
            // 문제 조건
            answer += "(";
            answer += solution(v);
            answer += ")";
            
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    answer += ")";
                } else {
                    answer += "(";
                }
            }
        }
        
        return answer;
    }
}