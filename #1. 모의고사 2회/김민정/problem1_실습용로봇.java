// 풀이 시간: 20분
// 시간 복잡도: O(N)
// 코드 설명: 명령어에 따라 방향을 바꾸고 그 방향으로 이동한다
// 취약한 부분: 방향 인덱스(d) 처리하는데 어려움이 있었음

import java.util.*;

class Solution {
    public int[] solution(String command) {

        // u r d l
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int r = 0, c = 0;
        int d = 0;
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                r += dr[d];
                c += dc[d];
            } else if (ch == 'B') {
                r -= dr[d];
                c -= dc[d];
            } else if (ch == 'R') {
                d = (d + 1) % 4;
            } else {
                d = (d + 3) % 4;
            }
        }

        return new int[] {r, c};
    }
}