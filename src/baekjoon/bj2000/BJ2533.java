package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//사회망 서비스(SNS)
public class BJ2533 {
	static int[][] dp;	//dp[i][j] = i번호 사람을 루트로 하는 서브트리에서 i번호 사람이 j상태(0=얼리어답터x, 1=얼리어답터o)일 때 모든 사람이 아이디어를 얻도록 필요한 최소 얼리어답터 수 
	static boolean[] chk;
	static List<List<Integer>> tree = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1][2];
		chk = new boolean[N + 1];
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
			dp[i][1] = 1;
		}
		
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			tree.get(U).add(V);
			tree.get(V).add(U);
		}
		
		dfs(1);	//1번 사람을 최상위 루트로 정한다.
		
		bw.write(Math.min(dp[1][0], dp[1][1]) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		chk[root] = true;
		for(int sub : tree.get(root)) {
			if(!chk[sub]) {
				dfs(sub);
				dp[root][0] += dp[sub][1];	//현재 사람이 얼리어답터가 아니라면 현재 사람의 친구들은 모두 얼리어답터야 한다.
				dp[root][1] += Math.min(dp[sub][0], dp[sub][1]);	//현재 사람이 얼리어답터라면 친구들은 얼리어답터일 수도 아닐 수도 있다.
			}
		}
	}
}
