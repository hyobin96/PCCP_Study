//풀이 시간 : 60분
//시간복잡도 : O(nxm)
//코드 설명 : 신발 보유 여부를 추가로 큐에 저장하면서 사방탐색으로 이동
//취약한 부분 : 0,0에서 시작한게 아닌, n-1,0에서 시작한거를 체크못함..ㅜ

package PCCP;

import java.util.*;

class problem4_보물지도 {
    public int solution(int n, int m, int[][] hole) {
        int answer = 0;
        int[][] arr = new int[n][m];
        for(int i = 0; i < hole.length; i++) {
            int x = hole[i][0] - 1;
            int y = m - (hole[i][1]);
            arr[x][y] = 1;
        }
        answer = BFS(arr, n, m);
        return answer;
    }

    static int BFS(int[][] arr, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n - 1, 0, 0});

        boolean[][][] visited = new boolean[n][m][2];
        visited[n - 1][0][0] = true;

        int count = 0;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        boolean isAns = false; //보물상자에 도착했는지 여부 확인

        outer:
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] now_node = queue.poll();
                if(now_node[0] == 0 && now_node[1] == m - 1) {
                    isAns = true;
                    break outer;
                }
                for(int i = 0; i < 4; i++) {
                    int r = now_node[0] + dr[i];
                    int c = now_node[1] + dc[i];

                    int jumpUsed = now_node[2];

                    int x = now_node[0] + 2 * dr[i];
                    int y = now_node[1] + 2 * dc[i];

                    if(r >= 0 && r < n && c >= 0 && c < m) {
                        if(arr[r][c] == 0 && !visited[r][c][jumpUsed]) {
                            queue.add(new int[]{r, c, jumpUsed});
                            visited[r][c][jumpUsed] = true;
                        }
                    }

                    if(jumpUsed == 0) {
                        if(x >= 0 && x < n && y >= 0 && y < m && arr[x][y] == 0 && !visited[x][y][1]) {
                            queue.add(new int[]{x, y, 1});
                            visited[x][y][1] = true;
                        }
                    }
                }
            }
            count++;
        }
        if(isAns) {
            return count;
        } else {
            return -1;
        }
    }
}