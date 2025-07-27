# 풀이 시간: 60분
# 시간 복잡도: log(2억) * 20만
# 코드 설명: 이분탐색으로 매 mid 마다 가능한 지 확인하여 최대 인원을 찾기
# 취약한 부분: 정해는 20~30분 안에 찾았으나 효율성에서 통과하지 못함. 왜 그런지 모르겠음. 민정이 코드보고 수정.

def solution(stones, k):
    def is_possible(mid):
        cnt = 0
        for stone in stones:
            if stone < mid:
                cnt += 1
                if cnt == k:
                    return False
            else:
                cnt = 0
            
        return True
    
    l = 1
    r = 200000000
    answer = 1
    while l <= r:
        mid = (l + r) // 2
        if is_possible(mid):
            answer = mid
            l = mid + 1
        else:
            r = mid - 1
    
    return answer