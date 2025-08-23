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
