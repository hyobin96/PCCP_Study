# 풀이 시간: 40분
# 시간 복잡도: O(N * (max(stones) / min(stones))), 매우 비효율적
# 코드 설명: 
# 1. 디딤돌의 최소값을 찾고, 그 값만큼 모든 디딤돌에서 동시에 건너뜀
# 2. 연속된 0의 개수가 k개가 되면 그때의 누적 건너뛴 수가 정답
# 3. 한 번에 여러 칸을 건너뛰는 방식으로 시간을 단축하려 함
# 취약한 부분: 
# - 시간 복잡도가 지나치게 높아 큰 입력에 대해 시간초과 발생
# - 매번 최솟값을 찾아 전체 배열을 업데이트하는 방식으로 비효율적
# - 이분탐색이나 세그먼트 트리 등 더 효율적인 알고리즘이 필요함
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        
        while(true) {
            
            int gap = 0;
            int min = Integer.MAX_VALUE;
            
            for(int i=0;i<stones.length;i++){
                if(stones[i] == 0) continue;
                min = Math.min(min, stones[i]);
            }
            
            for(int i=0;i<stones.length;i++){
                if(stones[i] > 0){
                    stones[i] -= min;
                }    
            }

            answer += min;
            
            for(int i=0;i<stones.length;i++){
                if (stones[i] == 0) {
                    gap++;
                    if (gap == k) return answer;
                } else {
                    gap = 0;
                }
            }
            
        }
        
    }
}