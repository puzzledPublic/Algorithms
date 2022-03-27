package programmers;

//3진법 뒤집기
public class Reverse3Radix {
    public static void main(String[] args) {
        int[] ns = {45, 125};

        for(int n : ns) {
            System.out.println(solution(n));
        }
    }
    static int solution(int n) {
        int answer = 0;

        String t = "";
        while(n > 0) {
            t = (n % 3) + t;
            n /= 3;
        }

        for(int i = 0; i < t.length(); i++) {
            int tt = t.charAt(i) - '0';
            for(int k = 0; k < i; k++) {
                tt *= 3;
            }
            answer += tt;
        }

        return answer;
    }

    static int solution2(int n) {
        int answer = 0;

        String t = "";
        while(n > 0) {
            t = t + (n % 3);
            n /= 3;
        }

        answer = Integer.parseInt(t, 3);

        return answer;
    }
}
