# 풀이 시간: 12분
# 시간 복잡도: O(N)
# 코드 설명: 문자열을 순회하면서 현재 알파벳이 이전 알파벳과 같지 않으면 각 알파벳에 
# 해당하는 인덱스에 ++ 해줌. 2번 이상 세어졌으면 외톨이인 것.
# 취약한 부분: 딱히 없다.

def solution(input_string):
    count_arr = [0] * 26
    
    count_arr[ord(input_string[0]) - ord('a')] += 1
    for i in range(1, len(input_string)):
        alpha = input_string[i]
        if alpha != input_string[i - 1]:
            idx = ord(alpha) - ord('a')
            count_arr[idx] += 1
    
    alphas = []
    for i in range(len(count_arr)):
        if count_arr[i] > 1:
            alphas.append(chr(i + ord('a')))
    
    answer = ''.join(alphas)
    if not answer:
        answer = 'N'
    return answer