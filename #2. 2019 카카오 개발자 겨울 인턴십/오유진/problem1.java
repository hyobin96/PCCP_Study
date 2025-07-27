// 풀이 시간: 25분 초과
// 시간 복잡도: O(M·N + K²)
// 코드 설명: moves배열의 각 열에서 가장 위에 있는 인형을 찾아 temp에 담고 board에서 해당 인형을 제거함 -> temp를 순회하면서 연속된 두 인형이 같으면 제거함 -> 인형이 제거되면 리스트 구조가 변하므로 i=-1로 설정해 처음부터 다시 확인함
// 취약한 부분: 자료구조, 스택써야할 거 같은 감은 있었는데 시도해보다가 시간만 까먹고 어레이리스트로 돌아감 

import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        ArrayList<Integer>temp = new ArrayList<>();
        
        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][moves[i]-1]!=0){
                    temp.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<temp.size()-1; i++){
            if(temp.get(i)==temp.get(i+1)){
                answer+=2;
                temp.remove(i);
                temp.remove(i);
                i=-1;
        }
        }
        
        return answer;
    }
}