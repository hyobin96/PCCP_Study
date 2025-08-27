// 풀이 시간 : 예전에 풀어서 기억이 안 납니다....
// 시간 복잡도: O(N)
// 코드 설명: 각 큐에 담으면서 합을 먼저 구해두고 sum1과 sum2의 크기를 비교하여 어디에서 어디로 숫자를 옮길지 결정했습니다.
// 취약한 부분: while 조건 설정하는게 어려웠습니다. 

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0L;
        long sum2 = 0L;
        
        int len = queue1.length;
        for (int i = 0; i < len; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        if (sum1 == sum2) return 0;
        
        while (answer <= len*3) {
            if (sum1 < sum2) {
                if (q2.isEmpty()) return -1;
                int t = q2.poll();
                sum2 -= t;
                q1.add(t);
                sum1 += t;
                answer++;
            } else if (sum1 > sum2) {
                if (q1.isEmpty()) return -1;
                int t = q1.poll();
                sum1 -= t;
                q2.add(t);
                sum2 += t;
                answer++;
            } else break;
        }
        
        return sum1 == sum2 ? answer : -1;
    }
}
