# 풀이 시간: 10분? 기억이 안 남 
# 시간 복잡도: O(N)
# 코드 설명: 명령에 맞게 방향을 전환하거나 이동함. d를 간단히 조작해서 코드를 간단화 할 수 있음.
# 취약한 부분: 해당 문제는 x, y의 좌표평면임. 따라서 r, c로 하기보다는 x, y에 맞게 좌표와 dx, dy를 설정하는 것이 좋아보임.

def solution(command):
    dcs, drs = (0, 1, 0, -1), (1, 0, -1, 0)
    
    r, c, d = 0, 0, 0
    for com in command:
        if com == 'R':
            d = (d + 1) % 4
        elif com == 'L':
            d = (d + 3) % 4
        elif com == 'G':
            r += drs[d]
            c += dcs[d]
        elif com == 'B':
            r, c = r - drs[d], c - dcs[d]
        
    answer = [c, r]
    return answer