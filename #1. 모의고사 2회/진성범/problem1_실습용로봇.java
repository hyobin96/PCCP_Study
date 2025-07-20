//풀이 시간 : 30분
//시간복잡도 : O(N)
//코드 설명 : 모든 케이스 다 나눠서 일일히 노가다
//취약한 부분 : 더 간략하게 풀어야 할 것 같음

package PCCP;

class problem1_실습용로봇 {
    public int[] solution(String command) {
        int[] answer = {0, 0};
        char dir = 'y';
        boolean plus = true;
        for(int i = 0; i < command.length(); i++) {
            char lett = command.charAt(i);
            if(lett == 'G') {
                if(dir == 'x') {
                    if(plus) {
                        answer[0]++;
                    } else {
                        answer[0]--;
                    }
                } else if(dir == 'y') {
                    if(plus) {
                        answer[1]++;
                    } else {
                        answer[1]--;
                    }
                }
            } else if(lett == 'R') {
                if(dir == 'x') {
                    if(plus) {
                        dir = 'y';
                        plus = false;
                    } else {
                        dir = 'y';
                        plus = true;
                    }
                } else if(dir == 'y') {
                    dir = 'x';
                }
            } else if(lett == 'L') {
                if(dir == 'x') {
                    dir = 'y';
                } else if(dir == 'y') {
                    if(plus) {
                        dir = 'x';
                        plus = false;
                    } else {
                        dir = 'x';
                        plus = true;
                    }
                }
            } else if(lett == 'B') {
                if(dir == 'x') {
                    if(plus) {
                        answer[0]--;
                    } else {
                        answer[0]++;
                    }
                } else if(dir == 'y') {
                    if(plus) {
                        answer[1]--;
                    } else {
                        answer[1]++;
                    }
                }
            }
        }
        return answer;
    }
}
