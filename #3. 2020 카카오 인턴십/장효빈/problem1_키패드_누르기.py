# 풀이 시간: 16분
# 시간 복잡도: O(N)
# 코드 설명: 각 번호에 맞는 위치를 r, c로 표현하여 map에 키패드 번호: (r, c) 로 매핑 후 조건문에서 사용
# 취약한 부분: 없다?

def solution(numbers, hand):
    mapper = {0: (3, 1)}
    num = 1
    for i in range(3):
        for j in range(3):
            mapper[num] = (i, j)
            num += 1
    
    left_r, left_c = (3, 0)
    right_r, right_c = (3, 2)
    answer = []
    for n in numbers:
        if n in (1, 4, 7):
            answer.append('L')
            left_r, left_c = mapper[n]
        elif n in (3, 6, 9):
            answer.append('R')
            right_r, right_c = mapper[n]
        else:
            r, c = mapper[n]
            left_dis = abs(left_r - r) + abs(left_c - c)
            right_dis = abs(right_r - r) + abs(right_c - c)
            
            if left_dis > right_dis:
                right_r, right_c = mapper[n]
                answer.append('R')
            elif left_dis < right_dis:
                left_r, left_c = mapper[n]
                answer.append('L')
            else:
                if hand == 'left':
                    left_r, left_c = mapper[n]
                    answer.append('L')
                else:
                    right_r, right_c = mapper[n]
                    answer.append('R')
    answer = ''.join(answer)
    return answer