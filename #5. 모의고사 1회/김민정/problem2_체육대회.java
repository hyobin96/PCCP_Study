// 풀이 시간: 25분
// 시간 복잡도: O(nPm)
// 코드 설명: 종목 수만큼 출전 선수 순열을 뽑아서 최대값 계산한다.
// 취약한 부분: 처음에 dp인가 했다가 이전에 출전한 선수인지 알 수 없을 거 같아서 순열로 틀었습니다.


import java.util.*;

class Solution {
    
    int stNum, type;
    int[] sel;
    boolean[] visited;
    int max = Integer.MIN_VALUE;
    
    public int solution(int[][] ability) {
        int answer = 0;
        
        stNum = ability.length;
        type = ability[0].length;

        visited = new boolean[stNum];
        sel = new int[type];
        perm(0, ability);
        
        return max;
    }
    
    public void perm(int idx, int[][] ability) {
        if (idx == type) {
            int sum = 0;
            for (int i = 0; i < type; i++) {
                sum += ability[sel[i]][i];
            }
            max = Math.max(max, sum);
            return;
        }
        
        for (int i = 0; i < stNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[idx] = i;
                perm(idx+1, ability);
                visited[i] = false;
            }
        }
    }
}
