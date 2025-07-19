// 풀이 시간: 10분
// 시간 복잡도: O(N log N + number log N)
// - N은 초기 배열 크기
// - 각 연산마다 PriorityQueue에서 poll/add 연산이 log N이므로 number 번 반복 시 log N 비용
// 코드 설명:
// - 능력치 배열을 오름차순 우선순위 큐(PriorityQueue)에 모두 삽입
// - number만큼 가장 작은 두 수를 꺼내 합산 후, 그 합을 두 번 다시 큐에 삽입
// - 마지막에 모든 큐 요소를 더해 최종 능력치 총합 반환
// 취약한 부분: 시간 복잡도 계산을 안하고 그냥 일단 sort를 했다가 시간초과 나서 갈아엎음.

import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 초기 능력치를 PQ에 삽입
        for (int i = 0; i < ability.length; i++) {
            pq.add(ability[i]);
        }

        // number번 합산 작업 반복
        for (int i = 0; i < number; i++) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            int sum = n1 + n2;
            pq.add(sum);
            pq.add(sum);
        }

        // 최종 능력치 총합 계산
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        return answer;
    }
}
