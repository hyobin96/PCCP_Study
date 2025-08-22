# 풀이 시간: 27분
# 시간 복잡도: O(log N)
# 코드 설명: 재귀적으로 부모를 찾음
# 취약한 부분: p % 4에서 4번째 자리를 0번 인덱스로 처리해야 하는 걸 인지를 늦게함

import math

def solution(queries):
    d = {'RR': ['RR', 'RR', 'RR', 'RR'], 
         'Rr': ['rr', 'RR', 'Rr', 'Rr'], 
         'rr': ['rr', 'rr', 'rr', 'rr']}
    
    def recur(n, p):
        nonlocal d
        
        if n == 1:
            return 'Rr'
        
        parent = recur(n - 1, math.ceil(p / 4))
        return d[parent][p % 4]
    
    answer = []
    
    for n, p in queries:
        answer.append(recur(n, p))
    
    return answer