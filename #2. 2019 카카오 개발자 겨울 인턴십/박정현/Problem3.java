# 풀이 시간: give up
# 시간 복잡도: 몹시 복잡함
# 코드 설명: 조합 구현 불가 이슈
# 취약한 부분: 늙고 병들었따.. 미안하다..

import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        String[] copy_user = user_id.clone();
        
        List<String> list = new ArrayList<>();
        for(int i=0; i<banned_id.length; i++){
            for(int j=0;j<banned_id[i].length();j++){
                int curr = banned_id[i].charAt(j); 
                if(curr == '*') {
                    
                }
                
                for(int m = 0; m<user_id.length;m++){
                    if(user_id[m].charAt(j) == curr) {
                        list.add(user_id[m]);
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}