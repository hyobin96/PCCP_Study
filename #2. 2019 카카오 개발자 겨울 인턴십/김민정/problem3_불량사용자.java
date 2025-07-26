// 풀이 시간: 90분
// 시간 복잡도: O(P(U, B) × B log B) (U : user_id 개수, B : banned_id 개수)
// 코드 설명: 각 banned_id가 될 수 있는 id들을 찾음 -> banned_id 길이의 순열을 돌려서 가능한 경우를 하나씩 셈
// 취약한 부분: 중복된 경우를 제외하는 로직을 생각하는데 시간이 오래 걸림

import java.util.*;

class Solution {
    
    Map<String, Set<String>> cntId;
    String[] sel, users, banned;
    int len, answer;
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        
        cntId = new HashMap<>();
        
        for (String banned : banned_id) {
            Set<String> tmp = new HashSet<>();
            for (String user : user_id) {
                if (banned.length() == user.length()) {
                    boolean isOk = true;
                    for (int i = 0; i < user.length(); i++) {
                        if (banned.charAt(i) != '*') {
                            if (user.charAt(i) != banned.charAt(i)) {
                                isOk = false;
                                break;
                            }
                        }
                    }
                    if (isOk) tmp.add(user);
                }
            }
            cntId.put(banned, tmp);
        }
        
        // System.out.println(cntId);
        
        len = banned_id.length;
        sel = new String[len];
        users = user_id;
        banned = banned_id;
        visited = new boolean[users.length];
        perm(0);
        
        return answer;
    }
    
    boolean[] visited;
    Set<List<String>> set = new HashSet<>();
    public void perm(int sidx) {
        if (sidx == len) {
            // System.out.println(Arrays.toString(sel));
            List<String> tmp = Arrays.asList(Arrays.copyOf(sel, sel.length));
            Collections.sort(tmp);
            if (!set.contains(tmp)) {
                check(sel, tmp);
            }
            return;
        }
        for (int i = 0; i < users.length; i++) {
            if (!visited[i]){
                sel[sidx] = users[i];
                visited[i] = true;
                perm(sidx+1);
                visited[i] = false;
            }
        }
    }
    
    public void check(String[] sel, List<String> tmp) {
        
        boolean isOk = true;
        for (int i = 0; i < len; i++) {
            if (!cntId.get(banned[i]).contains(sel[i])) {
                isOk = false;
                break;
            }
        }
        if (isOk) {
            // System.out.println("check " + Arrays.toString(sel));
            set.add(tmp);
            answer++;
        }
    }
}