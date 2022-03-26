package programmers;

//내적
public class InnerProduct {
    public static void main(String[] args) {
        int[][] as = {
                {1, 2, 3, 4},   //3
                {-1, 0, 1},     //-2
        };

        int[][] bs = {
                {-3, -1, 0, 2},
                {1, 0, -1},
        };

        for(int i = 0; i < as.length; i++) {
            System.out.println(solution(as[i], bs[i]));
        }
    }

    static int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
        }

        return answer;
    }
}
