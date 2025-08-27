// 풀이 시간 : 25분
// 시간 복잡도: O(N)
// 코드 설명: 모든 경우를 하드 코딩 했읍니다...... 몇개 안되더라구요........
// 취약한 부분: 아무래도 있어빌리티가 좀 떨어지는 감이 없지않아 있다.

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] arr = new int[4];
        String[] types = {"RT", "CF", "JM", "AN"};
        for(int i=0;i<survey.length;i++){
            switch(survey[i]){
                case "RT":{
                    arr[0] += choices[i] - 4;
                    break;
                }
                case "TR":{
                    arr[0] += 4 - choices[i];
                    break;
                }
                case "CF":{
                    arr[1] += choices[i] - 4;
                    break;
                }
                case "FC":{
                    arr[1] += 4 - choices[i];
                    break;
                }
                case "JM":{
                    arr[2] += choices[i] - 4;
                    break;
                }
                case "MJ":{
                    arr[2] += 4 - choices[i];
                    break;
                }
                case "AN":{
                    arr[3] += choices[i] - 4;
                    break;
                }
                case "NA":{
                    arr[3] += 4 - choices[i];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<4;i++){
            if (arr[i] <= 0) answer += types[i].charAt(0);
            else answer += types[i].charAt(1);
        }
        return answer;
    }
}
