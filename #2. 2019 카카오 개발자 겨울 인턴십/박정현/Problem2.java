# 풀이 시간: 50분 
# 시간 복잡도: O(N log N)
# 코드 설명: 
# 1. 문자열을 "}" 기준으로 분리하여 각 튜플을 추출
# 2. 튜플의 길이를 기준으로 오름차순 정렬 (짧은 것부터 처리)
# 3. 앞에서부터 순서대로 숫자를 확인하며 중복되지 않은 숫자만 결과에 추가
# 취약한 부분: 
# - substring(2)로 고정된 인덱스를 사용하여 입력 형식이 다를 경우 오류 발생 가능
# - 예외 처리가 없어 잘못된 입력 형식에 취약함

import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] temp = s.split("}");
        List<String> tupleList = new ArrayList<>();

        for(String str : temp) {
            tupleList.add(str.substring(2,str.length()));
        }
        
        
        // for(int i=0;i<tupleList.size();i++){
        //     tupleList.split(",");
        // }
        
        Collections.sort(tupleList, (o1, o2) -> o1.length() - o2.length());
        
//         for(int i=0;i<tupleList.size();i++){
//             System.out.println(tupleList.get(i));
//         }

        Set<Integer> set = new HashSet<>();
    
        int[] answer = new int[tupleList.size()];
        int idx = 0;
        for (String str : tupleList) {
            String[] nums = str.split(",");
            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                if (!set.contains(num)) {
                    set.add(num);
                    answer[idx++] = num;
                }
            }
        }
        
        
        return answer;
    }
}