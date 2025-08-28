# 풀이 시간: 20분
# 시간 복잡도: O(N)
# 코드 설명: 성격 유형을 키로 해서 점수를 더해줌
# 취약한 부분: 어떻게 하면 깔끔할까 고민

def solution(survey, choices):
    d = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 
         'A': 0, 'N': 0}
    
    for s, c in zip(survey, choices):
        if c < 4:
            d[s[0]] += 4 - c
        elif c > 4:
            d[s[1]] += c % 4
            
    answer = ''
    for key in ('RT', 'CF', 'JM', 'AN'):
        if d[key[0]] >= d[key[1]]:
            answer += key[0]
        else:
            answer += key[1]
    
    return answer