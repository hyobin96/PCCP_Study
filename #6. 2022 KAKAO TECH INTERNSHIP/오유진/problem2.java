// 풀이 시간: 1시간
// 시간 복잡도: O(N)
// 코드 설명: 한 큐에서 다른 큐로 원소를 옮기며 합을 조정하고, 불가능하면 -1을 반환
// 취약한 부분: 예외 상황과 안전 종료 조건 설계 미흡

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int res = 0;
        
        long sum1 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        
        long sum2 = 0;
        for(int i=0; i<queue2.length; i++){
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        long total = sum1 + sum2;
        long half = total/2;
        
        //총합이 홀수면 바로 -1 반환
        if(total % 2 != 0) return -1;
        
        //최악 이동 횟수 상한
        int limit = queue1.length * 4;
        
        while(true){
        if(sum1 == half){
            return res;
        }
        //무한 루프 방지 조건 (아무리 옮겨도 두 큐의 합을 같게 만들 수 없음)
        if(res > limit){
            return -1;
        }    
        
        if(sum1 < half){
            int temp1 = q2.poll();
            q1.offer(temp1);
            sum1+= temp1;
            sum2-= temp1;
            res++;
        }else{
            int temp2 = q1.poll();
            q2.offer(temp2);
            sum2+= temp2;
            sum1-= temp2;
            res++;
        } 
        }
    }
}
