package programmers;

//합승 택시 요금
public class SharedTaxiFee {
    public static void main(String[] args) {
        int[] ns = {6, 7, 6};
        int[] ss = {4, 3, 4};
        int[] as = {6, 4, 5};
        int[] bs = {2, 1, 6};
        int[][][] faiess = {
                {
                        {4, 1, 10},
                        {3, 5, 24},
                        {5, 6, 2},
                        {3, 1, 41},
                        {5, 1, 24},
                        {4, 6, 50},
                        {2, 4, 66},
                        {2, 3, 22},
                        {1, 6, 25}, //82
                },
                {
                        {5, 7, 9},
                        {4, 6, 4},
                        {3, 6, 1},
                        {3, 2, 3},
                        {2, 1, 6},  //14
                },
                {
                        {2, 6, 6},
                        {6, 3, 7},
                        {4, 6, 7},
                        {6, 5, 11},
                        {2, 5, 12},
                        {5, 3, 20},
                        {2, 4, 8},
                        {4, 3, 9},  //18
                },
        };

        for (int i = 0; i < ns.length; i++) {
            System.out.println(solution(ns[i], ss[i], as[i], bs[i], faiess[i]));
        }
    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[][] graph = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                graph[i][j] = 200_000_001;  //i -> j로 가는 길이 없음을 표시
            }
        }

        for(int[] fare : fares) {
            graph[fare[0]][fare[1]] = graph[fare[1]][fare[0]]= fare[2];
        }

        //floyd
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(!(i == j) && graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        //자기자신으로 가는 비용을 0으로
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            boolean g1 = graph[s][i] >= 200_000_001 ? false : true;
            boolean g2 = graph[i][a] >= 200_000_001 ? false : true;
            boolean g3 = graph[i][b] >= 200_000_001 ? false : true;
            if(g1 && g2 && g3) {    //s -> i, i -> a, i -> b 가는 경로가 있는 경우 최소 비용 계산
                min = Math.min(min, graph[s][i] + graph[i][a] + graph[i][b]);
            }
        }

        return answer = min;
    }
}
