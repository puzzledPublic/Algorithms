package programmers;

import java.util.Arrays;

//N-Queen
public class NQueen {
    public static void main(String[] args) {
        int[] n = {14};

        Arrays.stream(n).forEach(r -> System.out.println(solution(r)));
    }

    static boolean[][] visited; //0-세로, 1-대각1, 2-대각2
    static int N;

    static int solution(int n) {
        int answer = 0;

        N = n;
        visited = new boolean[3][n * 2 - 1];

        answer = test(0);

        return answer;
    }

    static int test(int x) {
        if(x == N) {
            return 1;
        }
        
        int result = 0;

        for(int i = 0; i < N; i++) {
            if(!visited[0][i] && !visited[1][x + i] && !visited[2][N - x - 1 + i]) {    //세로, 대각선 방향에 퀸이 이미 놓여있는지 검사
                visited[0][i] = visited[1][x + i] = visited[2][N - x - 1 + i] = true;
                result += test(x + 1);
                visited[0][i] = visited[1][x + i] = visited[2][N - x - 1 + i] = false;
            }
        }

        return result;
    }
}
