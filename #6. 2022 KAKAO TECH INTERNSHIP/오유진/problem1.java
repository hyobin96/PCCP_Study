
// 풀이 시간: 1시간
// 시간 복잡도: O(N)
// 코드 설명:
//1. 8개 성격 유형 점수를 0으로 초기화
//2. 각 설문 문항을 순회하며 선택값에 따라 점수를 누적
//3. 각 성격 쌍을 비교해서 점수가 높은 쪽을 결과에 추가
//4. 최종 네 글자 성격 유형을 반환
// 취약한 부분: 효율화 최적화와 먼 코드가 아닌지,,

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for(int i=0; i<survey.length; i++){
            char[] c = survey[i].toCharArray();
            int choice = choices[i];

            if(choice == 1){
                map.put(c[0],map.get(c[0])+3);
            }else if(choice == 2){
                map.put(c[0],map.get(c[0])+2);
            }else if(choice == 3){
                map.put(c[0],map.get(c[0])+1);
            }else if(choice == 4){
                map.put(c[0],map.get(c[0])+0);
            }else if(choice == 5){
                map.put(c[1],map.get(c[1])+1);
            }else if(choice == 6){
                map.put(c[1],map.get(c[1])+2);
            }else if(choice == 7){
                map.put(c[1],map.get(c[1])+3);
            }
        }

        String ans = "";

        if(map.get('R') >= map.get('T')){
            ans += "R";
        }else if(map.get('R') < map.get('T')){
            ans += "T";
        }

        if(map.get('C') >= map.get('F')){
            ans += "C";
        }else if(map.get('C') < map.get('F')){
            ans += "F";
        }

        if(map.get('J') >= map.get('M')){
            ans += "J";
        }else if(map.get('J') < map.get('M')){
            ans += "M";
        }

        if(map.get('A') >= map.get('N')){
            ans += "A";
        }else if(map.get('A') < map.get('N')){
            ans += "N";
        }

        return ans;
    }
}