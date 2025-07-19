// 풀이 시간: 50분
// 시간 복잡도: O(number*logN + N)
// 코드 설명: k초마다 카페에 사람이 얼마나 있는지 확인한다
// 취약한 부분: 'k초마다' 확인해도 된다는 걸 떠올리는데 시간이 오래 걸림

import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = Integer.MIN_VALUE;

        Map<Integer, Integer> cnt = new HashMap<>();
        int prev = 0;
        for (int i = 0; i < order.length; i++) {
            int orderNum = order[i];

            int start = i * k;
            int end = Math.max(prev, start) + menu[orderNum];

            for (int j = start; j < end; j+=k) {
                cnt.put(j, cnt.getOrDefault(j, 0) + 1);
                answer = Math.max(answer, cnt.get(j));
            }

            prev = end;
        }

        return answer == Integer.MIN_VALUE ? 1 : answer;
    }
}