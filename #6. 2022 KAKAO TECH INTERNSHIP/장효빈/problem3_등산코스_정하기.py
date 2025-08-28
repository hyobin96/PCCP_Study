# 풀이 시간: 80분
# 시간 복잡도: paths의 길이 * log(10000000)
# 코드 설명: 완전탐색, 백트래킹, 이진탐색, 산봉우리 번호순으로 정렬한 다음 출입구에 도착할 #           수 있으면 해당 intensity가 가능.
# 취약한 부분: 서로 다른 두 지점을 직접 연결하는 등산로는 최대 1개라는 것이 중요.
#             그렇기 때문에 bfs로 해도 무방.

import sys
sys.setrecursionlimit(100000)

def solution(n, paths, gates, summits):
    connected = [[] for _ in range(n + 1)]
    summits.sort()
    
    for i, j, w in paths:
        connected[i].append((j, w))
        connected[j].append((i, w))
        
    ends = [0] * (n + 1)
    for s in summits:
        ends[s] = 1
        
    starts = [0] * (n + 1)
    for g in gates:
        starts[g] = 1
        
    no = n + 1
    is_pos = False
    
    def dfs(s, intensity):
        nonlocal no, is_pos, visited
        visited[s] = flag
        
        if starts[s]:
            is_pos = True
            return
        
        for e, w in connected[s]:
            if visited[e] == flag or w > intensity or ends[e] or is_pos:
                continue
                
            dfs(e, intensity)
            # visited[e] = 0
            
    def is_possible(intensity):
        nonlocal is_pos, no
        is_pos = False
        
        for summit in summits:
            dfs(summit, intensity)
            if is_pos:
                no = summit
                break

        return is_pos

    flag = 0
    answer = [0, 0]
    visited = [0] * (n + 1)
    l, r = 1, 10000000
    while l <= r:
        mid = (l + r) // 2
        flag += 1
        if is_possible(mid):
            answer[0], answer[1] = no, mid
            r = mid - 1
        else:
            l = mid + 1
    
    
    return answer