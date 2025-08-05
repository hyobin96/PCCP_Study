//풀이 시간 : 40분
//시간복잡도 : O(N)
//코드 설명 : 그냥 노가다
//취약한 부분 : 코드를 줄일 순 없을까?

package PCCP;

import java.util.*;
class 카카오2020_problem1_키패드누르기 {
    int[] left = {3, 0};
    int[] right = {3, 2};
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int[][] keyPad = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
    public String solution(int[] numbers, String hand) {
        String answer = "";
        for(int i = 0; i < numbers.length; i++) {
            //왼쪽 손 까지의 거리와 오른쪽 손 까지의 거리를 담은 배열
            int[] LR = calcDistance(keyPad[numbers[i]][0], keyPad[numbers[i]][1], hand);
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left[0] = keyPad[numbers[i]][0];
                left[1] = keyPad[numbers[i]][1];
            }  else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right[0] = keyPad[numbers[i]][0];
                right[1] = keyPad[numbers[i]][1];
            } else {
                if(LR[0] < LR[1]) {
                    answer += "L";
                    left[0] = keyPad[numbers[i]][0];
                    left[1] = keyPad[numbers[i]][1];
                } else if(LR[1] < LR[0]) {
                    answer += "R";
                    right[0] = keyPad[numbers[i]][0];
                    right[1] = keyPad[numbers[i]][1];
                } else {
                    if(hand.equals("right")) {
                        answer += "R";
                        right[0] = keyPad[numbers[i]][0];
                        right[1] = keyPad[numbers[i]][1];
                    } else {
                        answer += "L";
                        left[0] = keyPad[numbers[i]][0];
                        left[1] = keyPad[numbers[i]][1];
                    }
                }
            }

        }

        return answer;
    }
    int[] calcDistance(int x, int y, String hand) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[4][3];
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int[] dist = {-1, -1}; // 왼쪽 손, 오른쪽 손 까지의 거리를 저장할 배열

        int count = 0; // 거리를 계산할 변수

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] now_node = queue.poll();
                if(now_node[0] == left[0] && now_node[1] == left[1]) dist[0] = count;
                if(now_node[0] == right[0] && now_node[1] == right[1]) dist[1] = count;
                if(dist[0] != -1 && dist[1] != -1) return dist;

                for(int j = 0; j < 4; j++) {
                    int r = now_node[0] + dr[j];
                    int c = now_node[1] + dc[j];
                    if(r >= 0 && r < 4 && c >= 0 && c < 3 && !visited[r][c]) {
                        queue.add(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            count++;
        }
        return dist;
    }
}
