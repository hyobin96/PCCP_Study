# 풀이 시간: 120분
# 시간 복잡도: 400000 * 400000, 시간초과
# 코드 설명: 트리를 만든 후 루트를 바꿔가며 재귀적으로 홀짝, 역홀짝 트리가 가능한지 각각 체크
# 취약한 부분: 트리 문제에 약한 것 같다. 시간초과를 해결할 방법이 떠오르지 않는다.


import sys

sys.setrecursionlimit(4000000)

def solution(nodes, edges):
    arr = [[] for _ in range(1000001)]
    
    for u, v in edges:
        arr[u].append(v)
        arr[v].append(u)
        
        
    visited = [0] * (1000001)
    visited_key = 1
    
    forest = []
        
    def dfs(u):
        nonlocal visited, forest
        visited[u] = visited_key
        
        forest[-1].append(u)
        
        for v in arr[u]:
            if visited[v] == visited_key:
                continue
                
            dfs(v)
        
        
    for n in nodes:
        if visited[n]:
            continue
            
        forest.append([])
        dfs(n)
        
    # print(forest)
        
    def dfs2(u):
        nonlocal visited, is_reverse_odd_even, is_odd_even
        
        if not is_reverse_odd_even and not is_odd_even:
            return
        
        visited[u] = visited_key
        count = 0
        
        for v in arr[u]:
            if visited[v] == visited_key:
                continue
                
            count += 1
            dfs2(v)
            
        # print(u, count)
        
        if (count - 1) % 2 == u % 2:
            is_reverse_odd_even = False
        
        else:
            is_odd_even = False
                
        
        
    answer = [0, 0]

    for tree in forest:
        answer1, answer2 = 0, 0

        for root in tree:
            visited_key += 1
            is_odd_even, is_reverse_odd_even, is_possible = True, True, True
            dfs2(root)
            
            answer1 += int(is_odd_even)
            answer2 += int(is_reverse_odd_even)
            
            if answer1 and answer2:
                break
                
            # print(root, is_odd_even, is_reverse_odd_even)
        
        if answer1:
            answer[0] += 1
        
        if answer2:
            answer[1] += 1
    
    
    return answer[::-1]