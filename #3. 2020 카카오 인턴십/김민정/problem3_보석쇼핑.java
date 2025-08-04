// 풀이 시간: 약 40분
// 시간 복잡도: O(N) (N : gems.length)
// 코드 설명: left와 right를 두고 그 사이에 보석이 종류별로 있으면 left--해서 최소길이를 구하고 종류별로 있지 않으면 right++해서 보석의 수를 늘린다
// 취약한 부분: 투포인터를 떠올리는데 시간이 좀 걸림

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemType = new HashSet<>();
        for (String g : gems) gemType.add(g);

        if (gemType.size() == 1) return new int[] {1, 1};

        Map<String, Integer> gemCnt = new HashMap<>();

        int left = 0;
        int right = 0;
        int resLen = Integer.MAX_VALUE;
        gemCnt.put(gems[0], 1);
        while (left <= right) {
            if(left >= gems.length || right >= gems.length) break;

            if (gemCnt.size() == gemType.size()) { // 보석을 종류 별로 포함하고 있음
                if (right - left < resLen) {
                    resLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                if (gemCnt.get(gems[left]) == 1) gemCnt.remove(gems[left]);
                else gemCnt.put(gems[left], gemCnt.get(gems[left])-1);
                left++;


            } else { // 보석 덜 포함
                if (right + 1 < gems.length) {
                    right++;
                    gemCnt.put(gems[right], gemCnt.getOrDefault(gems[right], 0) + 1);
                } else break;

            }

        }

        return answer;
    }
}