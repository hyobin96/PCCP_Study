//풀이 시간 : 30분
//시간복잡도 : O(log(max) × N)
//코드 설명 : 이진탐색을 통해 해결
//취약한 부분 : 원래였으면 완탐하려했다가 문득 이진탐색은 어떨까라는 생각이 들어서 홧김에 구현

package PCCP;

class 카카오2019_problem4_징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < stones.length; i++) {
            max = Math.max(max, stones[i]);
        }

        int L = 0;
        int R = max;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(find(stones, mid, k)) {
                R = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                L = mid + 1;
            }
        }
        return answer;
    }

    //연속된 0이 k개가 있는지 체크
    static boolean find(int[] arr, int a, int k) {
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - a <= 0) {
                cnt++;
                if(cnt == k) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }
}
