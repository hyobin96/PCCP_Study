# 풀이 시간: 30분 
# 시간 복잡도: O(N^2 + M)
# 코드 설명: 
# 1. 각 열을 큐로 관리하여 인형을 위에서부터 뽑을 수 있도록 함
# 2. moves 배열을 순회하면서 해당 열에서 인형을 하나씩 뽑음
# 3. 뽑은 인형은 스택에 쌓으며, 스택의 top과 같으면 터트려 점수를 얻음
# 취약한 부분: 
# - 큐 배열을 사용할 때 제네릭 타입을 명시하지 않아 타입 안정성이 떨어질 수 있음
# - Object 타입으로 poll() 결과를 받고 있어 명시적인 타입 캐스팅이 필요함

import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Queue[] qArr = new LinkedList[board.length+1];
        for(int i=1;i<=board.length;i++){
            qArr[i] = new LinkedList<Integer>();
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if (board[j][i] != 0) qArr[i+1].add(board[j][i]);
            }
        }
        System.out.println(Arrays.deepToString(qArr));
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i : moves){
            if (qArr[i].isEmpty()) continue;
            Object tmp = qArr[i].poll();
            if(!stack.isEmpty()){
                if(stack.peek() == (int)tmp){
                    stack.pop();
                    answer+=2;
                } else {
                    stack.push((int)tmp);
                }
            } else {
                stack.push((int)tmp);
            }
        }
        
        
        return answer;
    }
}