// 풀이 시간 : 예전에 풀어서 기억이 안 납니다....
// 시간 복잡도: O(N)
// 코드 설명: 맵에 각 유형별 점수를 저장합니다. 선택지가 4보다 클 때와 작을 때로 구분하여 점수 계산한 뒤에 총합이 더 높은 유형을 선택했습니다.
// 취약한 부분: 어려웠던 기억이 있는데요... 자세한 건 잘 모르겠습니다.....

import java.util.*;

class Solution {

    public String solution(String[] survey, int[] choices) {
        
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        Map<Character, Integer> score = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            score.put(types[i][0], 0);
            score.put(types[i][1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                char type = survey[i].charAt(1);
                score.put(type, score.get(type) + choices[i]-4);
            } else if (choices[i] < 4) {
                char type = survey[i].charAt(0);
                score.put(type, score.get(type) + (4 - choices[i]));
            }
        }       
        
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            char type1 = types[i][0];
            char type2 = types[i][1];
            
            if (score.get(type1) > score.get(type2)) {
                ans.append(type1);
            } else if (score.get(type2) > score.get(type1)) {
                ans.append(type2);
            } else {
                ans.append(type1 > type2 ? type2 : type1);
            }
        }

        return ans.toString();
    }
    
}
