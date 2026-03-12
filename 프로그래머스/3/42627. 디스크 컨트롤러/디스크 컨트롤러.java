import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // Comparator 활용하여 우선순위큐 생성
        // [요청시간, 소요시간]
        // 소요시간 짧은것 > 요청시간 빠른것 > 작업의 번호가 작은 것
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        // 소요시간 통해 반환시간 구하기
        int sumTime = 0; 
        int returnTime = 0;
        int cnt = 0;
        int index = 0;
        int size = jobs.length;
        
        // 요청시간 정렬로 pass 되는 케이스 없도록 조절
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        while(cnt < size) {
            // 요청시각에 따라 대기큐에 쌓이기 때문에 확인하면서 우선순위큐에 순차적으로 넣음
            while (index < size && jobs[index][0] <= sumTime) { // for문보다 조건 명확하게 확인가능
                pq.offer(jobs[index]);
                index++;
            }
            
            if (!pq.isEmpty()) {
                int[] workTime = pq.poll();
                sumTime += workTime[1];
                returnTime += (sumTime - workTime[0]);
                cnt++;
            } else {
                sumTime = jobs[index][0];   // 시작할 수 있는 값을 없을 경우 무한루프 방지
                                            // 반환시간의 평균이기 때문에 결과값의 영향x
            }
        }

        return returnTime/size;
    }
}