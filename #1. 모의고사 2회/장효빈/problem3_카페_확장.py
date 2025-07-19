# 풀이 시간: 35분 
# 시간 복잡도 O(N)
# 코드 설명: 먼저 온 손님의 음료를 먼저 제조하므로 queue 자료구조를 선택하여 품
# 취약한 부분: 큐를 떠올리는 것?

from collections import deque

def solution(menu, order, k):
    q = deque()
    answer = 0
    for o in order:
        time = k
        q.append(menu[o])
        answer = max(answer, len(q))
        while q and time > 0:
            if q[0] <= time:
                time -= q[0]
                q.popleft()
            else:
                q[0] -= time
                time = 0
        
    return answer