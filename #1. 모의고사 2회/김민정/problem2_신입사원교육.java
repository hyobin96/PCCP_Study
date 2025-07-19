// 풀이 시간: 4분
// 시간 복잡도: O(number*logN + N)
// 코드 설명: 정렬한 후 제일 작은 값 두 개를 뽑아서 처리한다
// 취약한 부분:

import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : ability) pq.add(a);

        for (int i = 0; i < number; i++) {
            int a1 = pq.poll();
            int a2 = pq.poll();

            pq.add(a1+a2);
            pq.add(a1+a2);
        }

        for (int i = 0; i < ability.length; i++) {
            answer += pq.poll();
        }

        return answer;
    }
}