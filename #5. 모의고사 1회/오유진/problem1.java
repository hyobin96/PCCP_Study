// 풀이 시간: 1시간?
// 시간 복잡도: O(N)
// 코드 설명: 등장한 알파벳의 인덱스를 저장한 뒤, 이중 반복문을 통해 연속되지 않은 쌍이 있는지 확인하여 외톨이 알파벳을 판별함
// 취약한 부분: 자료구조 안에 자료구조 접근법 / 이중 get,, 낯설다

import java.util.*;

class Solution {
    public String solution(String input_string) {

        Map<Character, List<Integer>> map = new HashMap<>();

        //알파벳을 맵의 키로 저장
        for(int i=0; i<26; i++){
            map.put((char)(97+i),new ArrayList<>());
        }

        char[] arr = input_string.toCharArray();

        //입력값으로 등장한 알파벳만 저장
        Set<Character> alpha = new HashSet<>();

        //알파벳의 인덱스를 알파벳별 밸류로 저장
        for(int i=0; i< arr.length; i++){
            map.get(arr[i]).add(i);
            alpha.add(arr[i]);
        }

        String answer = "";

        //외톨이 알파벳인지 체크
        for(Character c: alpha){
            int res = 0;
            for(int i=0; i< map.get(c).size()-1; i++){
                if(map.get(c).get(i+1)-map.get(c).get(i) > 1){
                    res++;
                }
            }
            if(res != 0){
                answer += c;
            }
        }

        //외톨이 알파벳이 아니면 N으로 처리
        if(answer.length()==0){
            answer = "N";
        }
        return answer;
    }
}