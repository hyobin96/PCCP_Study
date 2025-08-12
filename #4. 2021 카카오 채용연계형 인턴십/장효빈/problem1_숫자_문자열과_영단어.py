# 풀이 시간: 10분
# 시간 복잡도: O(N * 10)
# 코드 설명: 매핑해놓고 교체
# 취약한 부분: 

def solution(s):
    d = {'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4', 
         'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'}
    
    for num in d.keys():
        s = s.replace(num, d[num])
        
    return int(s)