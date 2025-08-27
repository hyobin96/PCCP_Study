// 풀이 시간: n시간...
// 시간 복잡도: O(N)
// 코드 설명: 부모를 먼저 찾고 RR, rr 이면 그대로 리턴, 아니면 한 단계 더 내려가서 확인해봅니다.
// 취약한 부분: 규칙을 정리해서 구현하는게 어려웠습니다..

import java.util.*;

class Solution {
    String tmp;
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        int idx = 0;
        
        for (int[] query : queries) {
            int n = query[0]; // 4
            int p = query[1]-1; // 25     
            
            tmp = "Rr";
            rec(n, p);
            
            answer[idx++] = tmp;
        }
        return answer;
    }
    
    public void rec(int n, int p) {
        if (n == 1) {
            tmp = "Rr";
            return;
        }

        rec(n-1, p / 4);
        
        if (tmp.equals("Rr")) {
            if (p % 4 == 0) {
                tmp = "RR";
                return;
            } else if (p % 4 == 3) {
                tmp = "rr";
                return;
            }
        }
        
    }
}
}
