package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//축구 전술 (Strongly Connected Components)
//Indegree가 0인 SCC가 2개 이상 존재하면 Confused, 1개라면 그 SCC 정점들을 출력하면 된다.
public class BJ3977 {
	static int N, M, SCCNum, count;
	static int[] visitNumber;
	static int[] SCCNums;
	static boolean[] finished;
	static Stack<Integer> stack;
	static List<List<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				graph.add(new ArrayList<>());
			}
			count = SCCNum = 0;
			visitNumber = new int[N];
			SCCNums = new int[N];
			finished = new boolean[N];
			stack = new Stack<>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				graph.get(A).add(B);
			}
			
			for(int i = 0; i < N; i++) {
				if(visitNumber[i] == 0) {
					dfs(i);
				}
			}
			
			int[] indegree = new int[SCCNum];
			for(int i = 0; i < N; i++) {
				for(int j : graph.get(i)) {
					if(SCCNums[i] != SCCNums[j]) {	//i -> j로 가는 간선이 있을때 두 정점이 같은 SCC가 아니라면 j가 속한 SCC는 Indegree가 존재한다.
						indegree[SCCNums[j]]++;
					}
				}
			}
			
			int noInDegree = 0, amount = 0;
			for(int i = 0; i < indegree.length; i++) {
				if(indegree[i] == 0) {	//Indegree가 0인 SCC의 개수를 센다.
					noInDegree = i;
					amount++;
				}
			}
			
			if(amount == 1) {	//Indegree가 0인 SCC가 1개라면 그 SCC 정점들 출력
				for(int i = 0; i < N; i++) {
					if(SCCNums[i] == noInDegree) {
						bw.write(i + "\n");
					}
				}
			}else {	//그 외의 경우 Confused
				bw.write("Confused\n");
			}
			
			if(test != T - 1) {
				bw.write("\n");
				br.readLine();
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	//타잔 알고리즘
	static int dfs(int curr) {
		visitNumber[curr] = ++count;
		stack.add(curr);
		int result = visitNumber[curr];
		
		for(int next : graph.get(curr)) {
			if(visitNumber[next] == 0) {
				result = Math.min(result, dfs(next));
			}else if(!finished[next]) {
				result = Math.min(result, visitNumber[next]);
			}
		}
		
		if(result == visitNumber[curr]) {
			while(!stack.isEmpty()) {
				int t = stack.pop();
				finished[t] = true;
				SCCNums[t] = SCCNum;
				if(t == curr) {
					break;
				}
			}
			SCCNum++;
		}
		
		return result;
	}
}
