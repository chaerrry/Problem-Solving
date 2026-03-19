import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        // 처음엔 굳이 닉네임 고려 x
        for (int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            String inout = arr[0];
            String id = arr[1];
            String nickname = "";
            if (inout.equals("Enter")) {
                nickname = arr[2];
                map.put(id, nickname);
                list.add(new String[]{id, "님이 들어왔습니다."});
            } else if (inout.equals("Leave")) {
                list.add(new String[]{id, "님이 나갔습니다."});
            } else if (inout.equals("Change")) {
                nickname = arr[2];
                map.put(id, nickname);
            }
        }
        
        String[] answer = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            String id = list.get(i)[0];
            String msg = list.get(i)[1];
            
            answer[i] = map.get(id) + msg;
        }
        
        return answer;
    }
}