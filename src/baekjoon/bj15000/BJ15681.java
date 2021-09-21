package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//트리와 쿼리
public class BJ15681 {
	static List<List<Integer>> tree = new ArrayList<>();
	static int[] sum;	//sum[i] = i를 루트로 하는 서브트리의 정점들의 개수
	static boolean[] chk;
	static int N, R, Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		sum = new int[N + 1];
		chk = new boolean[N + 1];
		Arrays.fill(sum, 1);
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			tree.get(U).add(V);	//트리 구성.
			tree.get(V).add(U);
		}
		
		dfs(R);	//R을 루트로 하는 서브트리의 정점들의 개수를 구한다.
		
		for(int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			bw.write(sum[q] + "\n");
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
				sum[root] += sum[sub];
			}
		}
	}
}
