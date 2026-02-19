class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ", -1);
        String word = "";
        String plusWord = "";
        
        for (int i = 0; i < arr.length; i++) {   
            word = arr[i];                       
            plusWord = "";                       

            if (!word.isEmpty()) {
                for (int j = 0; j < word.length(); j++) {
                    char c = word.charAt(j);

                    if (j == 0) {
                        if (Character.isLetter(c)) {
                            plusWord += Character.toUpperCase(c);
                        } else {
                            plusWord += c;
                        }
                    } else {
                        if (Character.isLetter(c)) {
                            plusWord += Character.toLowerCase(c);
                        } else {
                            plusWord += c;
                        }
                    }
                }
            }

            answer += plusWord;

            if (i < arr.length - 1) {   
                answer += " ";
            }
        }

        return answer;
    }
}