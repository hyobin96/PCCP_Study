# 풀이 시간: 20분 
# 시간 복잡도: NlogN + 4 * logN * number - 처음 정렬, number만큼 2번 뽑고 2번 넣어야 함
# 코드 설명: 능력치가 가장 낮은 계속해서 선택해야 하므로 pq 자료구조를 선택해야 함.
# 취약한 부분: pq를 빠르게 생각 못함... 그리고 python에서 pq를 안써봐서 문서를 보고 품. 숙련이 필요

import heapq

def solution(ability, number):
    answer = sum(ability)
    heapq.heapify(ability)
    for _ in range(number):
        n1 = heapq.heappop(ability)
        n2 = heapq.heappop(ability)
        answer += n1 + n2
        heapq.heappush(ability, n1 + n2)
        heapq.heappush(ability, n1 + n2)
        
    return answer