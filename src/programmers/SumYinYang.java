package programmers;

//음양 더하기
public class SumYinYang {
    public static void main(String[] args) {
        int[][] absolutess = {
                {4, 7, 12}, //9
                {1, 2, 3},  //0
        };

        boolean[][] signss = {
                {true, false, true},
                {false, false, true},
        };

        for(int i = 0; i < absolutess.length; i++) {
            System.out.println(solution(absolutess[i], signss[i]));
        }
    }

    static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < signs.length; i++) {
            answer += signs[i] == true ? absolutes[i] :-absolutes[i];
        }

        return answer;
    }
}
