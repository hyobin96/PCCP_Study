// 풀이 시간: 60분
// 시간 복잡도: O(n × m)
// 코드 설명: 신발을 신었는지 여부를 큐에 같이 저장하여 bfs를 한다
// 취약한 부분: 아니 내가 진짜로 장난치는게 아니고 한 시간동안 코드를 치면서 풀었는데 이게 날아감. 믿어줘 그리고 BFS는 다시 쉬운 문제부터 감 좀 잡아야 될 것 같아서 넘어갔음 헤헷큥 ㅅㄱ 코드는 민정이거임 :)

import java.util.*;

class Solution {

    int nn, mm;
    int[][] map;

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int n, int m, int[][] hole) {
        int answer = 0;

        nn = n; mm = m;

        map = new int[m+1][n+1];
        for (int[] h : hole) {
            map[h[1]][h[0]] = 1;
        }

        return bfs(1, 1);
    }

    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[mm+1][nn+1][2];

        q.add(new int[] {r, c, 0});
        visited[r][c][0] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                if (curr[0] == mm && curr[1] == nn) return cnt;

                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];

                    if (nr <= 0 || nr > mm || nc <= 0 || nc > nn) continue;
                    if (visited[nr][nc][curr[2]]) continue;

                    if (map[nr][nc] == 0) {  // 장애물 안 만남 -> 그냥 가면 됨
                        q.add(new int[] {nr, nc, curr[2]});
                        visited[nr][nc][curr[2]] = true;
                    } else { // 장애물 만남
                        if (curr[2] == 0) { // 아직 신발 안 신음 -> 신발을 신자
                            int nnr = nr + dr[d];
                            int nnc = nc + dc[d];

                            if (nnr <= 0 || nnr > mm || nnc <= 0 || nnc > nn) continue;
                            if (visited[nnr][nnc][1] || map[nnr][nnc] == 1) continue;

                            visited[nnr][nnc][1] = true;
                            q.add(new int[] {nnr, nnc, 1});
                        } else { // 이미 신발 신음 -> 못 감
                            continue;
                        }
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}