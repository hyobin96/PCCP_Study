// 풀이 시간: 잘 기억이 안 납니다...
// 시간 복잡도: O(N)
// 코드 설명: replace로 다 바꿨습니다
// 취약한 부분: ...그냥 구현한 듯..?

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String tmp = s.replace("zero", "0").replace("one", "1")
                     .replace("two", "2").replace("three", "3")
                     .replace("four", "4").replace("five", "5")
                     .replace("six", "6").replace("seven", "7")
                     .replace("eight", "8").replace("nine", "9");
        
        return Integer.parseInt(tmp);
    }
}
