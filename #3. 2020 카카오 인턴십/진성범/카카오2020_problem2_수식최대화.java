//풀이 시간 : 60분
//시간복잡도 : O(N²)
//코드 설명 : 배열 두개 만들고, 각각 경우마다 계산할 임시배열도 두개씩 만들어서 계산.
//취약한 부분 : 이런문제 진짜 너무 어렵다..

package PCCP;

import java.util.*;
class 카카오2020_problem2_수식최대화 {
    public long solution(String expression) {

        String[] number = expression.split("[-+*]");
        List<Character> ops = new ArrayList<>(); //기호 리스트
        List<Long> nums = new ArrayList<>(); //숫자 리스트

        //기호 넣기
        for(int i = 0; i < expression.length(); i++) {
            char a = expression.charAt(i);
            if(a == '+' || a == '-' || a == '*') {
                ops.add(a);
            }
        }
        //숫자 넣기
        for(int i = 0; i < number.length; i++) {
            nums.add(Long.parseLong(number[i]));
        }

        String[][] perm = {
                {"+", "-", "*"}, {"+", "*", "-"}, {"-", "+", "*"},
                {"-", "*", "+"}, {"*", "+", "-"}, {"*", "-", "+"}
        };

        long max = 0;

        for (String[] order : perm) {
            List<Long> tmpNums = new ArrayList<>(nums);
            List<Character> tmpOps = new ArrayList<>(ops);

            for (String op : order) {
                for (int i = 0; i < tmpOps.size(); ) {
                    if (String.valueOf(tmpOps.get(i)).equals(op)) {
                        long a = tmpNums.remove(i);
                        long b = tmpNums.remove(i);
                        tmpNums.add(i, calc(a, b, op)); //그 자리에 계산된 값을 넣고
                        tmpOps.remove(i); //기호는 썼으니 삭제
                    } else {
                        i++;
                    }
                }
            }

            max = Math.max(max, Math.abs(tmpNums.get(0)));
        }

        return max;
    }

    private long calc(long a, long b, String op) {
        if(op.equals("+")) return a + b;
        else if(op.equals("-")) return a - b;
        else return a * b;
    }
}
