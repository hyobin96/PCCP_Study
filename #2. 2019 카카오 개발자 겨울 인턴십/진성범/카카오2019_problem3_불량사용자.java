//풀이 시간 : 60분
//시간복잡도 : O(U! / (U - B)!)
//코드 설명 : set안에 set을 넣어서 중복제거, DFS+백트래킹을 통해 조합 구현
//취약한 부분 : Set안에 List가 들어가면 중복제거가 안된다네.. 백트래킹 구현이 너무오랜만이라 이전코드를 좀 참조함..

package PCCP;

import java.util.*;
class 카카오2019_problem3_불량사용자 {
    Set<Set<String>> result = new HashSet<>();
    boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {

        visited = new boolean[user_id.length];
        DFS(new HashSet<>(), 0, user_id, banned_id);
        return result.size();
    }

    void DFS(Set<String> set, int depth, String[] user_id, String[] banned_id) {
        if(depth == banned_id.length) {
            result.add(new HashSet<>(set));
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i]) {
                if (isMatched(user_id[i], banned_id[depth])) {
                    visited[i] = true;
                    set.add(user_id[i]);

                    DFS(set, depth + 1, user_id, banned_id);

                    set.remove(user_id[i]);
                    visited[i] = false;
                }
            }
        }
    }

    //매칭하는지 체크하는 메서드
    static boolean isMatched(String user_id, String banned_id) {
        //길이부터 체크
        if(user_id.length() != banned_id.length()) return false;

        //문자 체크
        for(int i = 0; i < user_id.length(); i++) {
            if(banned_id.charAt(i) == '*') continue;
            if(user_id.charAt(i) != banned_id.charAt(i)) return false;
        }

        return true;
    }
}
