# 풀이 시간: 41분
# 시간 복잡도: O(s)
# 코드 설명: 입력을 쪼개서 숫자로 바꾸고 길이순 정렬 후 원소를 하나씩 체크해 set에 없으면 정답 배열과 set에 추가
# 취약한 부분: 정규표현식을 써보려고 했는데 파이썬이라 익숙하지가 않아서 시간만 날렸다

def solution(s):
    l = []
    s = s[2:-2].split(r"},{")
    for e in s:
        l.append(list(map(int, e.split(','))))
    
    l.sort(key = lambda x: len(x))
    
    elements = set()
    answer = []
    for e in l:
        for element in e:
            if element not in elements:
                answer.append(element)
                elements.add(element)
            
    return answer