package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//우수 마을
public class BJ1949 {
	static boolean[] visited;
	//dp[i][0] = i 마을이 루트인 트리에서 i 마을이 우수 마을일때 최대 주민 수
	//dp[i][1] = i 마을이 루트인 트리에서 i 마을이 우수마을이 아닐때 최대 주민 수
	static int[][] dp;
	static List<List<Integer>> graph = new ArrayList<>();	//마을 트리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][2];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			dp[i][0] = Integer.parseInt(st.nextToken());	//각 마을의 주민 수
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		dfs(0);
		
		bw.write(Math.max(dp[0][0], dp[0][1]) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int start) {	//트리를 dfs돌며 dp테이블을 채운다.
		visited[start] = true;
		for(int next : graph.get(start)) {
			if(!visited[next]) {
				dfs(next);
				dp[start][0] += dp[next][1];	//현재 마을이 우수 마을이라면 자식 노드들은 우수 마을일 수 없다.
				dp[start][1] += Math.max(dp[next][0], dp[next][1]);	//현재 마을이 우수 마을이 아니라면 자식 노드들은 우수 마을이거나 우수 마을이 아닐 수 있다.
			}
		}
	}
}
