package programmers;

import java.util.Arrays;
import java.util.Stack;

//뒤에 있는 큰 수 찾기
public class FindingBehindBiggerNumber {
    public static void main(String[] args) {
        int[][] numbers = {
                {2, 3, 3, 5},
                {9, 1, 5, 3, 6, 2}
        };
        for (int i = 0; i < numbers.length; i++) {
            Arrays.stream(solution(numbers[i])).forEach(k -> System.out.print(k + " "));
            System.out.println();
        }
    }

    static int[] solution(int[] numbers) {
        int[] answer = {};
        answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length - 1; i >= 0; i--) {
            while(true) {
                if(stack.isEmpty()) {   //현재 수 보다 뒷 큰 수가 없는 경우
                    answer[i] = -1;
                    stack.push(numbers[i]);
                    break;
                }else if(numbers[i] < stack.peek()) {   //현재 수 보다 가장 가까운 뒷 큰 수가 있는 경우
                    answer[i] = stack.peek();
                    stack.push(numbers[i]);
                    break;
                }else { //현재 수 보다 뒷 큰 수를 찾기위해 pop
                    stack.pop();
                }
            }
        }

        return answer;
    }
}
