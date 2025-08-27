// 풀이 시간 : 30분(코드 치는 시간만 쳤을때,,,,)
// 시간 복잡도: O(N)
// 코드 설명: q 두개 합을 각각 구해서 같아 질 때까지 주고 받음. 그러다가 만약에 두 큐 총 개수 + 2 번만큼 했는데 결과가 안나온다 -> -1 출력
// 취약한 부분: 와 이거.. 생각해내는데 진짜 오래걸림. 아니 어케풀지.. 이렇게 생각만 하고 있다가 그냥 시키는대로 하면 되는 거여서 굉장히 허무했다.

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0;
        for(int i : queue1){
            q1.add(i);
            sum1 += i;
        }
        
        long sum2 = 0;
        for(int i : queue2){
            q2.add(i);
            sum2 += i;
        }
        while(true) {
            
            if (answer > queue1.length + queue2.length + 2) {
                answer = -1;
                break;
            }
            
            if (sum1 > sum2) {
                int curr = q1.poll();
                sum1 -= curr;
                q2.add(curr);
                sum2 += curr;
                answer++;
            }
            else if (sum1 < sum2) {
                int curr = q2.poll();
                sum2 -= curr;
                q1.add(curr);
                sum1 += curr;
                answer++;
            } else break;
        }
        
        return answer;
    }
}
