// 풀이 시간: 기억이 안 납니다,,, 나름 금방 풀었던 거 같음
// 시간 복잡도: O(M × N) (moves길이 : M / board : N*N배열)
// 코드 설명: 뽑은 인형을 스택에 담아두고 스택의 제일 위에 있는 인형과 지금 뽑은 인형이 같다면 pop 후 answer+2
// 취약한 부분:

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move-1] != 0) {
                    if (!stack.isEmpty() && board[i][move-1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[i][move-1]);
                    }
                    
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}