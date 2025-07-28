//풀이 시간 : 13분
//시간복잡도 : O(M × N)
//코드 설명 : 스택으로 바구니를 관리하고 나머지는 배열안에서 해결
//취약한 부분 : 인형 뽑고 인형을 삭제하는걸 처음에 놓침,,

package PCCP;

import java.io.*;
import java.util.*;
class 카카오2019_problem1_크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < moves.length; i++) {
            int idx = moves[i] - 1;
            int doll = 0; //뽑는 인형 번호 저장할 변수
            //인형뽑기 진행
            for(int j = 0; j < board.length; j++) { //위에서부터 내려가면서 인형있는지 확인
                if(board[j][idx] != 0) { //인형 있으면
                    doll = board[j][idx]; //인형번호 저장후
                    board[j][idx] = 0; //인형 삭제
                    break;
                }
            }
            if(doll == 0) continue;

            if(!st.isEmpty() && st.peek() == doll) {
                st.pop();
                answer += 2;
            } else {
                st.push(doll);
                System.out.print(doll);
            }
        }


        return answer;
    }
}
