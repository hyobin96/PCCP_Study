# 풀이 시간: 40분
# 시간 복잡도: N * log(N) 
# 코드 설명: 이진 탐색 + 윈도우 슬라이딩 + 해시
# 취약한 부분: 처음에 생각이 안 나서 경주로부터 풀고 다시 왔는데 생각이 났음. dp인 거 같기도 한데 잘 모르겠음.

def solution(gems):
    s = set(gems)
    answer = (0, 0)
    
    def add_dict(d, bosuk):
        if bosuk in d:
            d[bosuk] += 1
        else:
            d[bosuk] = 1
    
    def remove_dict(d, bosuk):
        d[bosuk] -= 1
        if d[bosuk] == 0:
            del d[bosuk]
    
    def is_possible(length):
        nonlocal answer
        d = dict()
        for i in range(length):
            add_dict(d, gems[i])
                
        start, end = 0, length - 1
        if len(d) == len(s):
            answer = (start + 1, end + 1)
            return True
        
        for i in range(length, len(gems)):
            start += 1
            end += 1
            add_dict(d, gems[i])
            remove_dict(d, gems[i - length])
            if len(d) == len(s):
                answer = (start + 1, end + 1) 
                return True
    
    l, r = 1, len(gems)
    while l <= r:
        mid = (l + r) // 2
        if is_possible(mid):
            r = mid - 1
        else:
            l = mid + 1
    
    
    return list(answer)