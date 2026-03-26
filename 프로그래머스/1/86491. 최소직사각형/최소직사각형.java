class Solution {
    public int solution(int[][] sizes) {
        
        int w = 0;
        int h = 0;
        
        for (int[] size : sizes) {
            // 긴것중에 가장긴것 + 짧은것중에 제일 짧은것 필요
            
            int max_vaule = Math.max(size[0], size[1]);
            int min_value = Math.min(size[0], size[1]);
            // 제일 긴걸 w로 가정 제일 짧은것중 제일 짧은걸 h
            
            w = Math.max(w, max_vaule);
            h = Math.max(h, min_value);
        }
        
        return w * h;
    }
}