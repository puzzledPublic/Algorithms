package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//이진 변환 반복하기
public class RepeatingBinaryTransform {
    public static void main(String[] args) {
        String[] ss = {
                "110010101001", //3, 8
                "01110",    //3, 3
                "1111111",   //4, 1
                "101"
        };

        for(String s : ss) {
            Arrays.stream(solution(s)).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
    }

    static int[] solution(String s) {
        int[] answer = {};

        int len = 0;    //1의 개수
        int removed = 0;    //지워진 0 개수
        int count = 1;  //변환 횟수
        for(char ch : s.toCharArray()) {
            if(ch == '0') {
                removed++;
            }else {
                len++;
            }
        }

        while(len != 1) {
            int one = 0;
            int zero = 0;
            while(true){    //len의 이진수에서 1과 0의 개수를 알아낸다.
                if(len % 2 == 0) {
                    zero++;
                }else {
                    one++;
                }
                if(len / 2 == 0) {
                    break;
                }
                len /= 2;
            }
            removed += zero;    //0은 지워지고
            len = one;  //1의 개수는 다음 변환을 위해..
            count++;    //변환 횟수++
        }

        return answer = new int[]{count, removed};
    }
}
