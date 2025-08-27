// 풀이 시간: 90분
// 시간 복잡도: O(N)
// 코드 설명: 스택에 계속해서 담아가면서 2세대 부모까지 찾아 올라감. 그리고 그 부모가 Rr 인 경우에만 스택을 타고 내려 오면서 몇 번째인지 확인하면서 자기 위치까지 내려오면 자기 형질이 나옴.
// 취약한 부분: 백트래킹 좀 할 부분 많은 것 같은데 힘드게 푸느라 그런거 못했음.

import java.util.*;

class Solution {
    public String[] solution(int[][] queries) {
        for(int[] temp : queries) {
            temp[1]--;
        }
        
        String[] answer = new String[queries.length];
        String[] gen2 = {"RR", "Rr", "Rr", "rr"};
        int idx = 0;
        for(int[] curr : queries){
            if(curr[0] == 1) {
                answer[idx++] = "Rr";
                continue;
            }
            Stack<int[]> stack = new Stack<>();
            int[] child = new int[2];
            child = curr;
            while(child[0] >= 2) {
                stack.add(child.clone());
                
                child[1] /= 4;
                child[0]--;
            }
            
            int[] temp = stack.pop();
            // System.out.println(temp[0] + "," + temp[1]);
            String parent = gen2[temp[1]];
            while(!stack.isEmpty()){
                temp = stack.pop();
                            
                if(parent.equals("RR")){
                    continue;
                } else if(parent.equals("Rr")){
                    // System.out.println("parent : " + parent + " temp[1] : " + temp[1]);
                    if(temp[1] % 4 == 0) parent = "RR";
                    else if(temp[1] % 4 == 1 || temp[1] % 4 == 2) parent = "Rr";
                    else if(temp[1] % 4 == 3) parent = "rr";
                } else if(parent.equals("rr")){
                    continue;
                }
            }
            
            answer[idx++] = parent;
        }
        
        
        
        return answer;
    }
}
