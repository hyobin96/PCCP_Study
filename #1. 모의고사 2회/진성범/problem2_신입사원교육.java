//풀이 시간 : 15분
//시간복잡도 : O(N + number)
//코드 설명 : 프리오리티큐 활용해서 능력치가 제일 작은 두명의 합을 더함
//취약한 부분 : 처음에 배열로 sort 해볼려다가 시간초과 실패

package PCCP;

import java.io.*;
import java.util.*;

class problem2_신입사원교육 {
    public int solution(int[] ability, int number) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < ability.length; i++) {
            pq.add(ability[i]);
        }
        for(int i = 0; i < number; i++) {
            int sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }
        for(int num : pq) {
            answer += num;
        }
        return answer;
    }
}
