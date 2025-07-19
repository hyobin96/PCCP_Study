// 풀이 시간: 25분
// 시간 복잡도: O(N) — 명령어(command)의 길이만큼 순회
// 코드 설명: 
// - 현재 위치와 방향을 추적하며 명령어를 하나씩 처리한다.
// - 방향은 0:북, 1:동, 2:남, 3:서로 설정하고,
//   G(전진), B(후진), R(오른쪽 회전), L(왼쪽 회전)에 따라 위치를 갱신한다.
// 취약한 부분: % 연산하는데 음수 생각 안함(이게 20분 먹음) 


class Solution {
    public int[] solution(String command) {
        int[] curr_pos = {0, 0};
        int curr_dir = 0;
        
        for(int i=0;i<command.length();i++){
            if(command.charAt(i) == 'G'){
                if(curr_dir % 4 == 0){
                    curr_pos[1]++;
                } else if(curr_dir % 4 == 1){
                    curr_pos[0]++;
                } else if(curr_dir % 4 == 2){
                    curr_pos[1]--;
                } else if(curr_dir % 4 == 3){
                    curr_pos[0]--;
                }
            } else if(command.charAt(i) == 'B'){
                if(curr_dir % 4 == 0){
                    curr_pos[1]--;
                } else if(curr_dir % 4 == 1){
                    curr_pos[0]--;
                } else if(curr_dir % 4 == 2){
                    curr_pos[1]++;
                } else if(curr_dir % 4 == 3){
                    curr_pos[0]++;
                }
            } else if(command.charAt(i) == 'R'){
                curr_dir++;
                if(curr_dir == 4) curr_dir -= 4;
            } else if(command.charAt(i) == 'L'){
                curr_dir--;
                if(curr_dir < 0) curr_dir += 4;
            }
        }
        
        return curr_pos;
    }
}