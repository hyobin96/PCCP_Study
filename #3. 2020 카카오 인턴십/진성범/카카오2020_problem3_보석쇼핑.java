//풀이 시간 : 50분
//시간복잡도 : O(N)
//코드 설명 : 해쉬맵을 통해 보석 종류와 보석 개수를 담아놓음
//취약한 부분 : 맵을 잘 못써서 set으로 어떻게든 해보려다가 시간초과때문에 결국 맵으로 해결

package PCCP;

import java.util.*;
class 카카오2020_problem3_보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>(Arrays.asList(gems)); //담아야 할 모든 물건 넣어놓기
        int len = set.size(); //4

        Deque<String> deque = new ArrayDeque<>();

        int L = 0;
        int R = 0;
        int answerLeft = 0;
        int answerRight = gems.length - 1;
        int minLen = gems.length;

        HashMap<String, Integer> map = new HashMap<>();

        while(R < gems.length) {
            map.put(gems[R], map.getOrDefault(gems[R], 0) + 1); //넣고 개수 하나 증가

            while (map.size() == len) {
                if (R - L < minLen) {
                    minLen = R - L;
                    answerLeft = L;
                    answerRight = R;
                }

                // 왼쪽 줄이기
                map.put(gems[L], map.get(gems[L]) - 1);
                if (map.get(gems[L]) == 0) {
                    map.remove(gems[L]);
                }
                L++;
            }

            R++;
        }
        answer[0] = answerLeft + 1;
        answer[1] = answerRight + 1;

        return answer;
    }
}
