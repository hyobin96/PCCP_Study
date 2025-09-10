# 풀이 시간: 20분
# 시간 복잡도: O(n)
# 코드 설명: 분으로 바꿔서 차가 10보다 크면 지각처리. startday는 startday % 7 + 1 로 1 ~ 7 반복
# 취약한 부분: 오랜만에 코테를 푸니 잘 문제가 잘 안 읽힌다.

def solution(schedules, timelogs, startday):
    answer = len(schedules)
    
    for i in range(len(timelogs)):
        s = startday
        for j in range(7):
            if s not in (6, 7):
                end = timelogs[i][j] // 100 * 60 + timelogs[i][j] % 100
                start = schedules[i] // 100 * 60 + schedules[i] % 100    

                if end - start > 10:
                    answer -= 1
                    break
                
            s = s % 7 + 1
                
    return answer