package programmers;

//약수의 개수와 덧셈
public class AmountAndSumOfAliquot {
    public static void main(String[] args) {
        int[] lefts = {13, 24};
        int[] rights = {17, 27};

        for(int i = 0; i < lefts.length; i++) {
            System.out.println(solution(lefts[i], rights[i]));
        }
    }

    static int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            int count = 0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count++;
                }
            }
            if(count % 2 == 0) {
                answer += i;
            }else {
                answer -= i;
            }
        }

        return answer;
    }
}
