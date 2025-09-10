# 풀이 시간: 21분
# 시간 복잡도: O(30C5)
# 코드 설명: 모든 조합을 구해서 가능한 지 확인
# 취약한 부분: 문제가 잘 안 읽힌다.


from itertools import combinations

def solution(n, q, ans):
    
    answer = 0
    
    for l in list(combinations(range(1, n + 1), 5)):
        s = set(l)
        
        is_possible = True
    
        for i in range(len(q)):
            cnt = 0
            for num in q[i]:
                if num in s:
                    cnt += 1
                    
            if cnt != ans[i]:
                is_possible = False
                break
                
                
        if is_possible:
            answer += 1
            
            
    return answer