// 풀이 시간: 3일(6시간)
// 시간 복잡도: O(N) — order 배열의 길이만큼 시간 흐름을 시뮬레이션
// 코드 설명:
// - 손님은 k초 간격으로 도착하며, 각 손님의 메뉴 번호에 해당하는 조리 시간을 큐에 저장
// - cookEndTime: 현재 조리가 끝나는 시간
// - 조리가 끝나면 큐에서 제거하고, 새로운 조리가 필요하면 큐의 앞에서 꺼내 cookEndTime 갱신
// - 시간 흐름(time)을 1초 단위로 증가시키며 큐 크기의 최대값을 갱신
// 취약한 부분:
// 내 로직이 틀렸대.... 그래서 도저히 모르겠어서... 피티 사용하면서 공부 하면서 했읍니다.... 많이 배웠데이....

import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int cookEndTime = 0;
        int idx = 0;

        while (idx < order.length || !q.isEmpty()) {
            // 손님 도착 시간에 맞춰 큐에 조리 시간 추가
            if (idx < order.length && time == idx * k) {
                q.add(menu[order[idx]]);
                idx++;
            }

            // 조리가 끝난 경우 (조리 완료 시각 == 현재 시간)
            if (cookEndTime == time && time != 0) {
                q.poll();
            }

            // 조리가 가능한 상태면 조리 시작
            if (cookEndTime <= time && !q.isEmpty()) {
                cookEndTime = time + q.peek();
            }

            // 현재 대기 중인 손님 수의 최대값 갱신
            answer = Math.max(answer, q.size());

            time++; // 1초 증가
        }

        return answer;
    }
}
