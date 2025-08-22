# 풀이 시간: 10분
# 시간 복잡도: O(N!)
# 코드 설명: 각 종목에 선발할 학생들의 번호의 경우의 수를 순열로 구함.
#           각 경우의 수마다 계산해서 최대값을 구함.
# 취약한 부분: 

from itertools import permutations

def solution(ability):
    n = len(ability[0])
    
    perm = list(permutations(range(len(ability)), n))
    
    answer = 0
    
    for p in perm:
        total = 0
        for i in range(n):
            total += ability[p[i]][i]
        answer = max(answer, total)
    
    return answer