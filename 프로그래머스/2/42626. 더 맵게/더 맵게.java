import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 우선순위큐 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int answer = 0;
        
        // 큐에 배열 담기
        for(int i : scoville){
            minHeap.offer(i);
        }
        
        for(answer = 0; minHeap.size() > 1; answer++){    
            int a = minHeap.poll();
            if(a >= K){
                return answer;
            }
            int b = minHeap.poll() * 2;   
            minHeap.offer(a+b);
        }
        
        return minHeap.peek() >= K ? answer : -1;
    }
}