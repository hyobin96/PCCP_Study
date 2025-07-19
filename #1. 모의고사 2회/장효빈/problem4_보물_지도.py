# 풀이 시간: 45분
# 시간 복잡도: O(배열의 크기)이나 구멍의 개수만큼 추가 분기가 발생함
# 코드 설명: BFS를 사용하나 신발을 사용한 경우와 사용하지 않은 경우를 나누어서 처리함
# 취약한 부분: solution 함수 안에서 매개변수를 받다 보니 global 변수에 할당하는 부분이 익숙치 않았음
#            또한 BFS 내부에서 메서드를 더 쪼갤 필요가 있음

from collections import deque

used_visited = []
visited = []
grid = []
q = deque()
N, M = 0, 0

def solution(n, m, hole):
    global used_visited, visited, grid, q, N, M
    used_visited = [[0] * (n + 2) for _ in range(m + 2)]
    visited = [[0] * (n + 2) for _ in range(m + 2)]
    grid = [[0] * (n + 2) for _ in range(m + 2)]
    N, M = n, m
    
    for c, r in hole:
        grid[r][c] = 1 
        
    answer = bfs()
    return answer

in_range = lambda r, c: 1 <= r <= M and 1 <= c <= N

def bfs():
    global used_visited, visited, grid, q
    visited[1][1] = 1
    q.append((1, 1, 1)) # r, c, 남은
    
    drs, dcs = (-1, 1, 0, 0), (0, 0, -1, 1)
    time = 0
    while q:
        q_size = len(q)
        for _ in range(q_size):
            r, c, cnt = q.popleft()
            if (r, c) == (M, N):
                return time
            for dr, dc in zip(drs, dcs):
                nr, nc = r + dr, c + dc
                if cnt == 0:
                    if in_range(nr, nc) and grid[nr][nc] != 1:
                        if used_visited[nr][nc]:
                            continue
                        used_visited[nr][nc] = 1
                        q.append((nr, nc, cnt))
                else:
                    if in_range(nr, nc):
                        if grid[nr][nc] != 1:
                            if not visited[nr][nc]:
                                visited[nr][nc] = 1
                                q.append((nr, nc, cnt))

                        if grid[nr][nc] == 1:
                            if in_range(nr + dr, nc + dc) and grid[nr + dr][nc + dc] != 1:
                                used_visited[nr + dr][nc + dc] = 1
                                q.append((nr + dr, nc + dc, 0))

                        if (nr + dr, nc + dc) == (M, N):
                            if used_visited[nr + dr][nc + dc]:
                                continue
                            used_visited[nr + dr][nc + dc] = 1
                            q.append((nr + dr, nc + dc, 0))
        time += 1
    return -1
