// 풀이 시간: 꽤 오래걸림... 1-2시간..?
// 시간 복잡도: O(6 × M² + N) → O(M²) (N : expression.length(), M : 연산자 수)
// 코드 설명: 문자열에서 숫자와 연산자를 분리하고 가능한 연산자의 우선순위 순열을 구한 후에 ..연산한다
// 취약한 부분: arraylist remove 안 하고 해보려고 어떻게 저렇게 해보다가 결국 arraylist remove 했습니다 처음부터 그냥 이렇게 할 걸..

import java.util.*;

class Solution {

    List<Character> ops;
    List<Long> nums;

    char[] allOps = {'+', '-', '*'};
    char[] sel = new char[3];
    boolean[] visited = new boolean[3];

    long answer = Long.MIN_VALUE;

    public long solution(String expression) {

        ops = new ArrayList<>();
        nums = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                ops.add(ch);
                if (sb.length() != 0) {
                    nums.add(Long.parseLong(sb.toString()));
                    sb.setLength(0);
                }
            } else {
                sb.append(ch);
            }
        }
        nums.add(Long.parseLong(sb.toString()));

        perm(0);

        return answer;
    }

    public void perm(int sidx) {
        if (sidx == 3) {
            cal(sel);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                sel[sidx] = allOps[i];
                visited[i] = true;
                perm(sidx+1);
                visited[i] = false;
            }
        }
    }

    public void cal (char[] sel) {
        List<Character> opp = new ArrayList<>(ops);
        List<Long> numss = new ArrayList<>(nums);
        Long tmp = 0L;

        for (char op : sel) {
            int idx = 0;
            while (idx < opp.size()) {

                if (opp.get(idx) == op) {
                    long c = calculate(numss.get(idx), numss.get(idx+1), op);
                    numss.remove(idx+1);
                    numss.set(idx, c);
                    opp.remove(idx);
                } else idx++;
            }
        }

        answer = Math.max(Math.abs(numss.get(0)), answer);
    }

    public Long calculate(long l1, long l2, char op) {
        if (op == '+') return l1 + l2;
        else if (op == '-') return l1 - l2;
        else return l1 * l2;
    }
}