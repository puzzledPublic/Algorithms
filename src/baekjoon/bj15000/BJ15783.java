package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//세진 바이러스 (scc 사용)
public class BJ15783 {
	static int N, M, order, sccNum;
	static int[] visitOrder;
	static int[] sccNums;
	static boolean[] finished;
	static List<List<Integer>> graph;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		visitOrder = new int[N];
		sccNums = new int[N];
		finished = new boolean[N];
		stack = new Stack<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
		}
		
		for(int i = 0; i < N; i++) {
			if(visitOrder[i] == 0) {
				dfs(i);
			}
		}
		
		//scc들 중 indegree가 0인 scc의 개수가 바이러스의 최소 개수가 된다.
		boolean[] chk = new boolean[sccNum];
		for(int i = 0; i < N; i++) {
			for(int j : graph.get(i)) {
				if(sccNums[i] != sccNums[j]) {	//i -> j 간선이 존재할때 i, j정점이 서로 다른 scc에 존재할 경우 j가 속한 scc는 indegree가 생긴다.
					chk[sccNums[j]] = true;
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < chk.length; i++) {
			if(!chk[i]) {
				count++;
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dfs(int curr) {
		visitOrder[curr] = ++order;
		stack.push(curr);
		int result = visitOrder[curr];
		
		for(int next : graph.get(curr)) {
			if(visitOrder[next] == 0) {
				result = Math.min(result, dfs(next));
			}else if(!finished[next]) {
				result = Math.min(result, visitOrder[next]);
			}
		}
		
		if(result == visitOrder[curr]) {
			while(true) {
				int t = stack.pop();
				finished[t] = true;
				sccNums[t] = sccNum;
				if(t == curr) {
					break;
				}
			}
			sccNum++;
		}
		
		return result;
	}
}
