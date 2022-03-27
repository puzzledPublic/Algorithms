package programmers;

//나머지가 1이 되는 수 찾기
public class FindNumberMakingRemainder1 {
    public static void main(String[] args) {
        int[] ns = {10, 12};    //3, 11

        for (int n : ns) {
            System.out.println(solution(n));
        }
    }

    static int solution(int n) {
        int answer = 0;

        for(int i = 2; i <= n - 1; i++) {
            if((n - 1) % i == 0) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
