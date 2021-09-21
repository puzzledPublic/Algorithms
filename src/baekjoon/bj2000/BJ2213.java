package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//트리의 독립집합
public class BJ2213 {
	static int[][] dp;	//dp[i][j] = i정점을 루트로 하는 서브트리에서 i정점을 j(0=안골랐을때, 1=골랐을때)상태일 때  최대 가중치 합.
	static int N;
	static List<List<Integer>> tree = new ArrayList<>();
	static List<Integer> resultSet = new ArrayList<>();	//독립집합 중 하나의 집합을 담을 리스트
	static boolean[] chk;	//dfs를 위한 방문 체크 배열
	static boolean[] include;	//독립집합 원소를 구하기 위한 체크 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][2];
		chk = new boolean[N + 1];
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			dp[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		
		dfs(1);	//dp, 가중치 최대 합 구하기
		
		Arrays.fill(chk, false);
		include = new boolean[N + 1];
		findSet(1, 1);	//독립집합 구하기
		
		resultSet.sort((a, b) -> a - b);	//오름차순 정렬
		
		bw.write(Math.max(dp[1][0], dp[1][1]) + "\n");
		for(int i : resultSet) {
			bw.write(i + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int root) {
		chk[root] = true;
		for(int sub : tree.get(root)) {
			if(!chk[sub]) {
				dfs(sub);
				dp[root][0] += Math.max(dp[sub][0], dp[sub][1]);	//현재 정점을 선택하지 않는 경우 각 자식 정점 선택하거나 선택하지 않는 경우가 있다.
				dp[root][1] += dp[sub][0];	//현재 정점을 선택했다면 자식 노드는 선택될 수 없다.
			}
		}
	}
	
	static void findSet(int root, int prev) {
		chk[root] = true;
		
		if(dp[root][0] < dp[root][1] && !include[prev]) {	//선택했고, 가중치 합이 더 크고, 이전 정점을 선택하지 않았다면 독립집합 원소
			resultSet.add(root);
			include[root] = true;
		}
		
		for(int sub : tree.get(root)) {
			if(!chk[sub]) {
				findSet(sub, root);
			}
		}
	}
}
