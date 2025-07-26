// 풀이 시간: 80분
// 시간 복잡도: O(N × log(max))
// 코드 설명: 이진탐색을 사용하여 가능한 가장 작은 값을 찾음
// 취약한 부분: 이진탐색.. 생각하는데 오래 걸림 효율성 검사 통과하는데 오래 걸렸어요


import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid, k, stones)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int n, int k, int[] stones) {
        int cnt = 0;
        for (int s : stones) {
            if (s <= n) {
                cnt++;
                if (cnt == k) return true;
            } else cnt = 0;
        }

        return false;
    }
}

