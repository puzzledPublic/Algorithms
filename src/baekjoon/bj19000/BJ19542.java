package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//전단지 돌리기
public class BJ19542 {
	static int N, S, D;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int totalLen, minusLen;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		dfs(S);
		
		bw.write((totalLen - 2 * minusLen) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dfs(int curr) {
		visited[curr] = true;
		int result = 0;
		for(int next : graph.get(curr)) {
			if(!visited[next]) {
				totalLen++;	//진행할때
				int len = dfs(next) + 1;	//next를 루트로 하는 서브트리의 최대 높이
				totalLen++;	//돌아올때
				result = Math.max(result, len);
				if(len <= D) {	//서브트리 높이가 D보다 작은 높이면 가지 않아도 됨.
					minusLen++;
				}
			}
		}
		return result;
	}
}
