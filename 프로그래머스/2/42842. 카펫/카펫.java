class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        for (int h = 1; h <= yellow; h++) {
            if (yellow % h != 0) {
                continue;
            }
            
            int w = yellow / h;
            
            // 양쪽이 2씩 늘어남 
            // 노란색 영역 기준으로 늘어나야돼서 2씩 증가
            int final_w = w + 2;
            int final_h = h + 2;
            
            int brown_cnt = final_w * final_h - yellow;
            
            if (brown_cnt == brown) {
                answer[0] = final_w;
                answer[1] = final_h;
                break;
            }
        }
        
        return answer;
    }
}