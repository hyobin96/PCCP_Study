# 풀이 시간: 57분
# 시간 복잡도: 측정하기 애매. 백트래킹으로 많은 부분을 줄이는 듯 
# 코드 설명: dfs로 모든 경우를 탐색함. costs 배열을 이용해 현재 경로의 비용이 더 높다면 진행하지 않도록 함.
# 취약한 부분: 사실 이 문제는 다익스트라 같은데 생각이 안났다. 경로 + 최소 비용이면 바로 다익스트라를 떠올려야 할 듯.

def solution(board):
    N = len(board)
    
    dr, dc = (-1, 0, 1, 0), (0, 1, 0, -1)
    
    in_range = lambda r, c: 0 <= r < N and 0 <= c < N
    costs = [[10000000000] * N for _ in range(N)]
    
    def dfs(cost, curr, last_d):
        nonlocal costs
        r, c = curr
        if (r, c) == (N - 1, N - 1):
            return
        
        for d in range(4):
            nr, nc = r + dr[d], c + dc[d]
            if not in_range(nr, nc):
                continue
            if board[nr][nc]:
                continue
            
            if d == last_d or last_d == -1:
                if cost + 100 <= costs[nr][nc]:
                    costs[nr][nc] = cost + 100
                    dfs(cost + 100, (nr, nc), d)
            else:
                if cost + 600 <= costs[nr][nc]:
                    costs[nr][nc] = cost + 600
                    dfs(cost + 600, (nr, nc), d)
        
    dfs(0, (0, 0), -1)
        
    return costs[N - 1][N - 1]