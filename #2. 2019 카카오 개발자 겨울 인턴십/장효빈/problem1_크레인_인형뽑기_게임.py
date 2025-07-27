# 풀이 시간: 22분
# 시간 복잡도: board 배열의 크기 + moves 배열의 크기
# 코드 설명: board의 각 열의 원소들을 스택에 저장, 그 후 하나씩 뽑으면서 바구니에 넣음. 만약 바구니 맨 위가 같다면 넣지 않고 터뜨림.
# 취약한 부분: 

def solution(board, moves):
    size = len(board)
    board_stacks = [[] for _ in range(size)]
    for j in range(size):
        for i in range(size - 1, -1, -1):
            if board[i][j] == 0:
                break
            board_stacks[j].append(board[i][j])
            
            
    basket, answer = [], 0
    for move in moves:
        move -= 1   # 인덱스 맞추기
        if board_stacks[move]:
            doll = board_stacks[move].pop()
            if basket and basket[-1] == doll:
                basket.pop()
                answer += 2
            else:
                basket.append(doll)
                
    return answer