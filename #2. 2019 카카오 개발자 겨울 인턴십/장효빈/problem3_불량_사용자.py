# 풀이 시간: 60분
# 시간 복잡도: 
# 코드 설명: 조합으로 가능한 경우를 구해서 경우의 수 세기
# 취약한 부분: 정규표현식을 쓰기 위해 re 모듈을 읽는 데 시간이 많이 걸렸고 아이디 목록의 내용이 동일하다면 같은 것으로 처리해야 하는 것을 놓쳐서 시간을 날림

import re

def solution(user_id, banned_id):
    for i, b_id in enumerate(banned_id):
        banned_id[i] = b_id.replace('*', '[a-z0-9]')
    
    ids = set()
    ids2 = set()
    ids3 = set()
    answer = 0
    
    def combi(start):
        nonlocal ids, answer
        if len(ids) == len(banned_id):
            s = tuple(sorted(list(ids3)))
            if s not in ids2:
                answer += 1
                ids2.add(s)
            return
        
        for i in range(start, len(user_id)):
            for j in range(len(banned_id)):
                if j not in ids and re.fullmatch(banned_id[j], user_id[i]):
                    ids.add(j)
                    ids3.add(i)
                    combi(i + 1)
                    ids.remove(j)
                    ids3.remove(i)
                    
    combi(0)
    return answer