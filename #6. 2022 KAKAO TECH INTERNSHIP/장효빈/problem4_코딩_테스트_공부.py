# 풀이 시간: 90분 
# 시간 복잡도: O(2 ** n) 
# 코드 설명: 완전탐색 
# 취약한 부분: dp같은데... 그리디로 풀려했는데 도저히 답이 없다

import sys

sys.setrecursionlimit(10000000)

def solution(alp, cop, problems):
    max_alp, max_cop = 0, 0
    
    for p in problems:
        max_alp = max(max_alp, p[0])
        max_cop = max(max_cop, p[1])
        
        
    min_cost = 300
    
    def dfs(alp, cop, cost):
        nonlocal min_cost
        if alp >= max_alp and cop >= max_cop:
            min_cost = min(min_cost, cost)
            return
        
        if min_cost < cost:
            return
        
        for p in problems:
            if alp >= p[0] and cop >= p[1] and (p[2] + p[3] / p[4] > 1) \
            and (alp + p[2] <= max_alp or cop + p[3] <= max_cop):
                dfs(alp + p[2], cop + p[3], cost + p[4])
                
        if alp < max_alp:
            dfs(alp + 1, cop, cost + 1)
        
        if cop < max_cop:
            dfs(alp, cop + 1, cost + 1)
                
    dfs(alp, cop, 0)
        
    return min_cost