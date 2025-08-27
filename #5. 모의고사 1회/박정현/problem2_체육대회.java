// 풀이 시간: 60분
// 시간 복잡도: O(N^2)?? 순열.... 복잡도.. ?
// 코드 설명: 순열을 돌려서 모든 경우를 다 찾아봄.
// 취약한 부분: 시간적으로 최악일 것.. 하지만 이게 되네? 였다...

class Solution {
    int size, max;
    int[] arr;
    int[][] aability;
    boolean[] visited;
    public int solution(int[][] ability) {
        size = ability[0].length;
        arr = new int[size];
        visited = new boolean[ability.length];
        aability = ability;
        int answer = 0;
        
        perm(0);
        
        return max;
    }
    
    public void perm(int sidx) {
        if(sidx == size) {
            int temp = 0;
            for(int i=0; i<size; i++) {
                temp += aability[arr[i]][i];
            }
            
            max = Math.max(max, temp);
            return;
        }
        
        for(int i=0; i<aability.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[sidx] = i;
                perm(sidx+1);
                visited[i] = false;
            }
        }
    }
}
