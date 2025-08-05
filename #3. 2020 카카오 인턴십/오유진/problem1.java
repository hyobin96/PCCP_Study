// 풀이 시간: 25분 초과
// 시간 복잡도: O(N)
// 코드 설명:
// 1. 키패드를 2차원 좌표로 모델링
// 2. 왼손/오른손의 현재 위치를 스택으로 관리
// 3. 숫자 입력마다 누를 손 결정
// 취약한 부분: 다른 사람의 접근 방식을 분석해서 효율적인 방식 습득이 필요할 듯

import java.util.Stack;

import static java.lang.Math.abs;

class Solution {
    public String solution(int[] numbers, String hand) {

        String answer = "";

        Stack<int[]> leftHandPosition = new Stack<>();
        leftHandPosition.push(new int[]{3, 0});
        Stack<int[]> rightHandPosition = new Stack<>();
        rightHandPosition.push(new int[]{3, 2});

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                answer += "L";
                leftHandPosition.push(new int[]{0, 0});
            } else if (numbers[i] == 4) {
                answer += "L";
                leftHandPosition.push(new int[]{1, 0});
            } else if (numbers[i] == 7) {
                answer += "L";
                leftHandPosition.push(new int[]{2, 0});
            } else if (numbers[i] == 3) {
                answer += "R";
                rightHandPosition.push(new int[]{0, 2});
            } else if (numbers[i] == 6) {
                answer += "R";
                rightHandPosition.push(new int[]{1, 2});
            } else if (numbers[i] == 9) {
                answer += "R";
                rightHandPosition.push(new int[]{2, 2});
            } else { //2,5,8,0
                if (numbers[i] == 2) {
                    int leftDistance = getDistance(leftHandPosition.peek(), new int[]{0, 1});
                    int rightDistance = getDistance(rightHandPosition.peek(), new int[]{0, 1});
                    if (leftDistance < rightDistance) {
                        answer += "L";
                        leftHandPosition.push(new int[]{0, 1});
                    } else if (leftDistance > rightDistance) {
                        answer += "R";
                        rightHandPosition.push(new int[]{0, 1});
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightHandPosition.push(new int[]{0, 1});
                        } else {
                            answer += "L";
                            leftHandPosition.push(new int[]{0, 1});

                        }
                    }
                } else if (numbers[i] == 5) {
                    int leftDistance = getDistance(leftHandPosition.peek(), new int[]{1, 1});
                    int rightDistance = getDistance(rightHandPosition.peek(), new int[]{1, 1});
                    if (leftDistance < rightDistance) {
                        answer += "L";
                        leftHandPosition.push(new int[]{1, 1});
                    } else if (leftDistance > rightDistance) {
                        answer += "R";
                        rightHandPosition.push(new int[]{1, 1});
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightHandPosition.push(new int[]{1, 1});
                        } else {
                            answer += "L";
                            leftHandPosition.push(new int[]{1, 1});
                        }
                    }
                } else if (numbers[i] == 8) {
                    int leftDistance = getDistance(leftHandPosition.peek(), new int[]{2, 1});
                    int rightDistance = getDistance(rightHandPosition.peek(), new int[]{2, 1});
                    if (leftDistance < rightDistance) {
                        answer += "L";
                        leftHandPosition.push(new int[]{2, 1});
                    } else if (leftDistance > rightDistance) {
                        answer += "R";
                        rightHandPosition.push(new int[]{2, 1});
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightHandPosition.push(new int[]{2, 1});
                        } else {
                            answer += "L";
                            leftHandPosition.push(new int[]{2, 1});
                        }
                    }
                } else if (numbers[i] == 0) {
                    int leftDistance = getDistance(leftHandPosition.peek(), new int[]{3, 1});
                    int rightDistance = getDistance(rightHandPosition.peek(), new int[]{3, 1});
                    if (leftDistance < rightDistance) {
                        answer += "L";
                        leftHandPosition.push(new int[]{3, 1});
                    } else if (leftDistance > rightDistance) {
                        answer += "R";
                        rightHandPosition.push(new int[]{3, 1});
                    } else {
                        if (hand.equals("right")) {
                            answer += "R";
                            rightHandPosition.push(new int[]{3, 1});
                        } else {
                            answer += "L";
                            leftHandPosition.push(new int[]{3, 1});
                        }
                    }
                }
            }


        }
        return answer;


    }

    private static int getDistance(int[] start, int[] end) {
        return abs(start[0] - end[0]) + abs(start[1] - end[1]);
    }
}

