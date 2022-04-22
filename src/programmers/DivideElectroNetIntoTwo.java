package programmers;

//전력망을 둘로 나누기
public class DivideElectroNetIntoTwo {
    public static void main(String[] args) {
        int[] ns = {9, 4, 7};
        int[][][] wiress = {
                {
                        {1,3},
                        {2, 3},
                        {3, 4},
                        {4, 5},
                        {4, 6},
                        {4, 7},
                        {7, 8},
                        {7, 9},
                },
                {
                        {1, 2},
                        {2, 3},
                        {3, 4},
                },
                {
                        {1, 2},
                        {2, 7},
                        {3, 7},
                        {3, 4},
                        {4, 5},
                        {6, 7},
                }
        };

        for(int i = 0; i < ns.length; i++) {
            System.out.println(solution(ns[i], wiress[i]));
        }
    }

    static int solution(int n, int[][] wires) {
        int answer = n;

        boolean[][] graph = new boolean[n + 1][n + 1];

        for(int[] wire: wires) {    //트리 만들기
            graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = true;
        }

        for(int[] wire: wires) {
            boolean[] visited = new boolean[n + 1];

            graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = false;  //해당 연결 끊기

            //트리 형태이므로 하나의 연결을 끊으면 두개의 트리로 나뉜다.
            int one = dfs(wire[0], graph, visited);
            int another = dfs(wire[1], graph, visited);
            graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = true;   //연결 복구

            answer = Math.min(answer, Math.abs(one - another)); //
        }

        return answer;
    }
    //해당 트리의 노드 개수를 구한다.
    static int dfs(int x, boolean[][] graph, boolean[] visited) {
        int result = 1;
        visited[x] = true;
        for(int i = 1; i < graph.length; i++) {
            if(graph[x][i] && !visited[i]) {
                result += dfs(i, graph, visited);
            }
        }
        return result;
    }
}
