# 풀이 시간: 25분
# 시간 복잡도: O(n**4 * 100)
# 코드 설명: req의 길이가 2이면 배열을 돌면서 req[0]과 같으면 값을 0으로 바꿈
#           req의 길이가 1이면 배열을 돌면서 req와 같으면 bfs를 돌려 지게차로 접근할 수 있는지 확인
#           접근할 수 있으면 리스트에 좌표를 추가해놨다가 배열을 모두 돈 후에 해당 좌표를 일괄 0처리
#           requests를 모두 처리한 후에 남은 알파벳 개수 세서 리턴
# 취약한 부분: 문제가 잘 안 읽힌다.


from collections import deque

def solution(storage, requests):
    
    n, m = len(storage), len(storage[0])
    
    grid = []
    
    for string in storage:
        grid.append(list(string))
        
    drs, dcs = (-1, 1, 0, 0), (0, 0, -1, 1)
    in_range = lambda r, c: 0 <= r < n and 0 <= c < m
    
    def bfs(start):
        q = deque()
        visited = [[0] * m for _ in range(n)]
        q.append(start)
        r, c = start
        visited[r][c] = 1
        
        while q:
            r, c = q.popleft()
            
            for dr, dc in zip(drs, dcs):
                nr, nc = r + dr, c + dc
                if not in_range(nr, nc):
                    return True
                
                if not grid[nr][nc] and not visited[nr][nc]:
                    q.append((nr, nc))
                    visited[nr][nc] = 1
            
        
    for req in requests:
        l = []
        
        if len(req) == 1:
            for r in range(n):
                for c in range(m):
                    if grid[r][c] == req and bfs((r, c)):
                         l.append((r, c))
                            
            for r, c in l:
                grid[r][c] = 0
            
        else:
            for r in range(n):
                for c in range(m):
                    if grid[r][c] == req[0]:
                        grid[r][c] = 0
            
    answer = 0
    
    for r in range(n):
        for c in range(m):
            if grid[r][c]:
                answer += 1
            
    return answer