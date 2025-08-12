# 풀이 시간: 20분
# 시간 복잡도: O(N * 12)
# 코드 설명: 응시자가 있는 경우 탐색 시작하여 먼저 사방탐색. 응시자가 존재하면 return False 
#           비어있으면 왔던 쪽은 제외하고 사방탐색. 응시자가 존재하면 return False 
#           모두 통과하면 return True
# 취약한 부분: 

def solution(places):
    drs, dcs = (-1, 0, 1, 0), (0, 1, 0, -1) # 북동남서
    in_range = lambda r, c: 0 <= r < 5 and 0 <= c < 5
    def is_possible(place):
        nonlocal drs, dcs
        for i in range(5):
            for j in range(5):
                if place[i][j] == 'P':
                    for d1 in range(4):
                        nr, nc = i + drs[d1], j + dcs[d1]
                        if not in_range(nr, nc) or place[nr][nc] == 'X':
                            continue
                        if place[nr][nc] == 'P':
                            return False
                        
                        start = (d1 + 3) % 4
                        for d2 in range(start, start + 3):
                            d2 %= 4
                            nr2, nc2 = nr + drs[d2], nc + dcs[d2]
                            if not in_range(nr2, nc2):
                                continue
                            if place[nr2][nc2] == 'P':
                                return False
        return True
                            
    answer = []
    for place in places:
        answer.append(int(is_possible(place)))
        
    return answer