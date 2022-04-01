package programmers;

import java.util.Stack;

//괄호 회전하기
public class RotateParentheses {
    public static void main(String[] args) {
        String[] ss = {
                "[](){}",   //3
                "}]()[{",   //2
                "[)(]",     //0
                "}}}",      //0
        };

        for (String s : ss) {
            System.out.println(solution(s));
        }
    }

    static int solution(String s) {
        int answer = 0;

        char[] chArr = s.toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            //괄호 문자열 회전
            char ch = chArr[0];
            for (int j = 1; j < chArr.length; j++) {
                chArr[j - 1] = chArr[j];
            }
            chArr[chArr.length - 1] = ch;

            //올바른 괄호 문자열인지 체크
            boolean isOk = true;
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < chArr.length; j++) {
                char c = chArr[j];
                if (c == '(' || c == '[' || c == '{') { //왼쪽 괄호는 스택에 저장
                    stack.push(c);
                } else if (stack.isEmpty()) {   //오른쪽 괄호이고 왼쪽 괄호가 존재하지 않으면 잘못된 괄호 문자열
                    isOk = false;
                    break;
                } else {    //오른쪽 괄호이고 짝이 맞는다면 왼쪽 괄호를 스택에서 제거
                    char top = stack.peek();
                    if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                        stack.pop();
                    } else {    //짝이 다르다면 잘못된 괄호 문자열
                        isOk = false;
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                isOk = false;
            }

            if (isOk) {
                answer++;
            }
        }

        return answer;
    }
}
