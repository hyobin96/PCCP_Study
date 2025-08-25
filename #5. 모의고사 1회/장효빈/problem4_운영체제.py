# 풀이 시간: 26분
# 시간 복잡도: O(2N log N)
# 코드 설명: pq를 두 개 이용해서 하나는 호출시간순으로 정렬, 하나는 우선순위, 호출시간 순으로 정렬. 호출시간순으로 정렬하는 pq에 프로그램을 다 넣은 다음 peek에서 호출시간이 현재시간 이하이면 꺼내서 다른 pq에 넣음. 다른 pq에서 하나씩 꺼내서 현재 시간 갱신.
# 취약한 부분: heapq가 아직 익숙하지 않다.

import heapq

def solution(program):
    pq1, pq2 = [], []
    
    for a, b, c in program:
        heapq.heappush(pq1, (b, a, c))
    
    
    curr_time = 0
    answer = [0] * 11
    
    while pq1 or pq2:
        while pq1 and pq1[0][0] <= curr_time:
            b, a, c = heapq.heappop(pq1)
            heapq.heappush(pq2, (a, b, c))
        
        if not pq2:
            b, a, c = heapq.heappop(pq1)
            heapq.heappush(pq2, (a, b, c))
            
        a, b, c = heapq.heappop(pq2)
        
        if curr_time < b:
            curr_time = b
        
        answer[a] += curr_time - b
        
        curr_time += c
               
    
    answer[0] = curr_time
    return answer