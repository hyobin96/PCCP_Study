// 풀이 시간: 15분
// 시간 복잡도: O(N)
// 코드 설명: 이전 문자와 비교하면서 문자열을 순회하고 외톨이알파벳 후보군을 맵(알파벳, 등장횟수), 리스트(정렬용)에 저장한다. 
//            리스트 정렬 후 등장횟수가 2 이상인 것들을 찾는다.
// 취약한 부분: 


import java.util.*;

class Solution {
    public String solution(String input_string) {
        
        List<Character> alpha = new ArrayList<>();
        Map<Character, Integer> cnt = new HashMap<>();
        char prev = '\u0000';
        
        for (int i = 0; i < input_string.length(); i++) {
            char curr = input_string.charAt(i);
            if (curr != prev) {
                prev = curr;
                cnt.put(curr, cnt.getOrDefault(curr, 0) + 1);
                alpha.add(curr);
            }
        }
        
        Collections.sort(alpha);
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < alpha.size(); i++) {
            char curr = alpha.get(i);
            if (cnt.containsKey(curr) && cnt.get(curr) >= 2) {
                ans.append(curr);
                cnt.remove(curr);
            }
        }
        
        return ans.length() == 0 ? "N" : ans.toString();
    }
}
