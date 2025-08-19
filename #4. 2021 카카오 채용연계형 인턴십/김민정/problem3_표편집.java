// 풀이 시간: 오랜 시간
// 시간 복잡도: O(Tlogn) (T는 총 이동 횟수-> U x / D x 에서 x들의 합)
// 코드 설명: pq1에는 선택된 행의 앞에 있는 행들을 넣고 pq2에는 뒤에 있는 행들을 넣었습니다. 삭제한 행은 스택에 넣어 관리했습니다.
// 취약한 부분: 이런 문제가 제일 어려워요... 효율성에서 막혀서 오래 걸렸습니다..

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            if (i < k) pq1.add(i);
            else pq2.add(i);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (String c : cmd) {
            String[] cc = c.split(" ");
            
            if ("U".equals(cc[0])) {
                for (int i = 0; i < Integer.parseInt(cc[1]); i++) {
                    pq2.add(pq1.poll());
                }
            } else if ("D".equals(cc[0])) {
                 for (int i = 0; i < Integer.parseInt(cc[1]); i++) {
                    pq1.add(pq2.poll());
                }
            } else if ("C".equals(cc[0])) {
                stack.add(pq2.poll());
                if (pq2.isEmpty()) pq2.add(pq1.poll());
            } else {
                int curr = stack.pop();
                if (curr < pq2.peek()) pq1.add(curr);
                else pq2.add(curr);
            }
        }
        
        StringBuilder ans = new StringBuilder();
        boolean[] isDel = new boolean[n];
        while (!stack.isEmpty()) {
            isDel[stack.pop()] = true;
        }
        for (boolean isD : isDel) {
            if (isD) ans.append("X");
            else ans.append("O");
        }
        
        return ans.toString();
    }
}
