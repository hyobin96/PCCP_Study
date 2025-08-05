//풀이 시간 : 60분
//시간복잡도 : O(N²)
//코드 설명 : bfs를 기본으로 하고 cost가 더 낮은 쪽으로만 이동하도록 설정
//취약한 부분 : bfs에 cost가 더 낮은쪽으로 가야겠다 까진 구상을 했는데, 방향을 어케해야할지 겁나 오래 고민함.

package PCCP;

import java.util.*;
class 카카오2020_problem4_경주로건설 {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int h, w;
    int[][][] cost;
    public int solution(int[][] board) {

        w = board[0].length; //가로
        h = board.length; //세로

        cost = new int[h][w][4];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                for(int k = 0; k < 4; k++) {
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(0,0,board);

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            answer = Math.min(answer, cost[h - 1][w - 1][i]);
        }
        return answer;
    }

    void bfs(int x, int y, int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        queue.add(new int[]{x, y, 1});
        for(int i = 0; i < 4; i++) {
            cost[x][y][i] = 0;
        }

        while(!queue.isEmpty()) {
            int[] now_node = queue.poll();
            for(int j = 0; j < 4; j++) {
                int r = now_node[0] + dr[j];
                int c = now_node[1] + dc[j];
                int dir = now_node[2]; //들어온 노드의 현재 방향

                if(r >= 0 && r < h && c >= 0 && c < w && board[r][c] == 0) {
                    if(dir == j) {
                        if(cost[r][c][j] > cost[now_node[0]][now_node[1]][dir] + 100) {
                            queue.add(new int[]{r, c, j});
                            cost[r][c][j] = cost[now_node[0]][now_node[1]][dir] + 100;
                        }
                    } else {
                        if(cost[r][c][j] > cost[now_node[0]][now_node[1]][dir] + 600) {
                            queue.add(new int[]{r, c, j});
                            cost[r][c][j] = cost[now_node[0]][now_node[1]][dir] + 600;
                        }
                    }
                }
            }
        }
    }
}
