
// 풀이 시간: 25분 초과
// 시간 복잡도: O((N + K) log N)
// 코드 설명:  우선순위 큐를 사용해서 매번 가장 작은 두 수를 뽑고 더한다
// 취약한 부분: 배열, arraylist로 해결하려다가 계속 시간초과나서 지피티한테 도움 요청함. 자료구조 공부를 빨리 끝내야 할 거 같음.


import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int a : ability) {
            pq.offer(a);
        }

        for (int i = 0; i < number; i++) {
            int first = pq.poll();   
            int second = pq.poll();  

            int sum = first + second;

            pq.offer(sum);
            pq.offer(sum);
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        return answer;
    }
}
