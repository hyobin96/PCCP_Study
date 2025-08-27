// 풀이 시간: 25분
// 시간 복잡도: O(N)
// 코드 설명: 
//   첫 번째 문자를 map에 기록하고, 이후부터 문자열을 순회한다. 이전 문자와 현재 문자가 다르면서, 현재 문자가 이미 map에 존재할 경우 set에 추가한다.
//   TreeSet을 사용해 자동으로 정렬된 상태로 중복 없는 문자 집합을 유지한다. set의 문자를 이어붙여 반환하며, 비어있을 경우 "N"을 반환한다.
// 취약한 부분: ㅎ 잘한듯 칭찬좀.

import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        
        Map<Character, Integer> map = new HashMap<>();
        map.put(input_string.charAt(0), 1);
        Set<Character> set = new TreeSet<>();
        for(int i = 1; i < input_string.length(); i++){
            char prev = input_string.charAt(i-1);
            char curr = input_string.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if (prev != curr && map.get(curr) > 1) {
                set.add(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : set) sb.append(c);
        answer = sb.toString();
        if (answer.length() == 0) answer = "N";
        
        return answer;
    }
}
