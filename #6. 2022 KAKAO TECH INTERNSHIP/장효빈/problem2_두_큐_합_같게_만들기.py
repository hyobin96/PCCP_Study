# 풀이 시간: 27분
# 시간 복잡도: O(N)
# 코드 설명: 합이 작은 큐에서 큰 큐로 계속 옮김. 그리디
# 취약한 부분: 풀었지만 직관적으로 이해가 잘 안됨.

from collections import deque

def solution(queue1, queue2):
    s1, s2 = sum(queue1), sum(queue2)
    
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    cnt = 0
    
    while s1 != s2:
        if s1 > s2:
            element = q1.popleft()
            s1 -= element
            s2 += element
            q2.append(element)
            
        else:
            element = q2.popleft()
            s2 -= element
            s1 += element
            q1.append(element)
            
        cnt += 1
        
        if cnt > 3 * len(queue1):
            return -1
    
    return cnt