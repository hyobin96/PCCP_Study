// 풀이 시간: 이것도 기억이 잘 안 나지만,,, 1번보다는 확실히 오래걸림..
// 시간 복잡도: O(L + N log N) (L : s의 길이, N : 숫자의 종류)
// 코드 설명: 입력받은 문자열을 돌면서 각 숫자가 몇 번 나왔는지 셈 -> 가장 많이 등장한 숫자부터 리턴배열에 넣음
// 취약한 부분: Map에 들어있는 값들을 value 기준으로 정렬해야 했는데 이 과정이 처음이라 어려움이 있었음

import java.util.*;

class Solution {
    public int[] solution(String s) {

        Map<Integer, Integer> numCnt = new HashMap<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch-'0' >= 0 && ch-'0' <= 9) {
                num.append(ch);
            } else {
                if (num.length() != 0) {
                    int tmp = Integer.parseInt(num.toString());
                    numCnt.put(tmp, numCnt.getOrDefault(tmp, 0) + 1);
                    num.setLength(0);
                }
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numCnt.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        
        int[] answer = new int[numCnt.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            answer[idx++] = entry.getKey();
        }        
        
        return answer;
    }
}