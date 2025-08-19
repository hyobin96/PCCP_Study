// 풀이 시간: 기억이 안 남
// 시간 복잡도: O(N)
// 코드 설명: 문자 순회
// 취약한 부분: 쓰던 메서드만 씀, 내장 메서드를 다양하게 사용해야 할 듯

import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";

        Map<String, String> num = new HashMap<>();

        num.put("one", "1");
        num.put("two", "2");
        num.put("three", "3");
        num.put("four", "4");
        num.put("five", "5");
        num.put("six", "6");
        num.put("seven", "7");
        num.put("eight", "8");
        num.put("nine", "9");
        num.put("zero", "0");

        String temp = ""; //키로 만들기 위한 임시 변수

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){ //숫자면
                answer += ch;
            }else{ //문자면
                temp += ch;
                if(num.containsKey(temp)){
                    answer+= num.get(temp);
                    temp = "";
                }
            }
        }
        return Integer.parseInt(answer);
    }
}


