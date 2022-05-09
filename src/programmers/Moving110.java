package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//110 옮기기
public class Moving110 {
    public static void main(String[] args) {
        String[] s =
                {
                        "1110", //1101
                        "100111100",    //100110110
                        "0111111010",   //0110110111
                        "1011110",  //1011011
                        "01110",    //01101
                        "101101111010", //101101101101
                        "1100111011101001"  //0101101101101101
                };

        Arrays.stream(solution(s)).forEach(r -> System.out.print(r + " "));
    }
    //해당 문자열에서 110을 반복해서 모두 제거 한 후의 문자열에 제거한 횟수 만큼 110을 붙여준다.
    //사전 순으로 앞서야 하므로 제거된 문자열 끝에 붙은 연속된 1이 있다면 뒤로 미뤄야한다.
    static String[] solution(String[] s) {
        String[] answer = {};

        List<String> results = new ArrayList<>();

        for (String ss : s) {
            char[] chs = ss.toCharArray();
            Stack<Character> stack = new Stack<>();
            int curr = 0;   //탐색 위치
            int count = 0;  //0앞의 연속된 1의 개수
            int save = 0;   //제거된 110 개수
            while (curr < chs.length) {
                if(chs[curr] == '0') {  //'0'인 경우
                    if(count >= 2) {    //연속된 1의 개수가 2이상인 경우 110을 만족. 110을 찾은 횟수 증가
                        stack.pop();
                        stack.pop();
                        count -= 2;
                        save++;
                    }else { //110이 안되는 경우 (ex 100) 앞의 1 횟수 초기화
                        count = 0;
                        stack.push('0');
                    }
                }else { //'1'인 경우
                    count++;
                    stack.push('1');
                }
                curr++;
            }
            int one = 0;
            while(!stack.isEmpty() && stack.peek() == '1') {    //사전순을 위해 맨 뒤의 연속된 '1'을 스택서 잠시 뺀다.
                stack.pop();
                one++;
            }

            for(int i = 0; i < save; i++) { //110을 제거한 횟수만큼 110을 스택에 넣는다
                stack.push('1');
                stack.push('1');
                stack.push('0');
            }

            for(int i = 0; i < one; i++) {  //잠시 뺀 1을 다시 스택에 넣는다
                stack.push('1');
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {  //결과 문자열을 만든다.
                sb.append(stack.pop());
            }

            results.add(sb.reverse().toString());   //stack이므로 reverse한 문자열을 얻는다.
        }

        return answer = results.toArray(new String[0]);
    }
}
