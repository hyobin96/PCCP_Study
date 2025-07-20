//풀이 시간 : 90분 + a
//시간복잡도 : O(N × max(menu))
//코드 설명 : 현재시간, 현재손님,남은음료제조시간,음료만들손님번호를 다 다른 변수로 둔 뒤에 체크
//취약한 부분 : 처음에 어디서 틀린지 몰라서 겁나 헤맴, 엥 근데 분명 아까전에 정답처리되었는데 갑자기 방금 시간초과뜸.. 뭐임?

package PCCP;

class problem3_카페확장 {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int customer = order.length;
        int nowTime = 0;
        int num = 0;

        int timer = 0; // 현재 남은 음료 제조 시간
        int orderIdx = 0; // 음료 만들 손님 번호

        while (orderIdx < customer || timer > 0) {

            //먼저 퇴장부터 처리
            if (timer == 0 && orderIdx < customer) {
                if (nowTime >= orderIdx * k) { // 손님이 도착한 이후부터 만들 수 있음
                    if (orderIdx > 0) num--; // 이전 손님 퇴장
                    timer = menu[order[orderIdx]]; // 다음 음료 시작
                    orderIdx++;
                }
            }

            //입장: nowTime % k == 0일 때 손님 입장
            if (nowTime % k == 0 && nowTime / k < customer) {
                num++; // 손님 입장
            }

            answer = Math.max(answer, num);

            timer = Math.max(0, timer - 1);
            nowTime++;
        }

        return answer;
    }
}

