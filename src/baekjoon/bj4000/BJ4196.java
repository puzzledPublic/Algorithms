package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//도미노 (Strongly Connected Components)
//타잔 알고리즘
public class BJ4196 {
	static int N, M, order, sccNum;
	static int[] visitOrder;
	static int[] sccNums;
	static int[] inDegree;
	static boolean[] finished;
	static Stack<Integer> stack = new Stack<>();
	static List<List<Integer>> graph = new ArrayList<>();
//	static List<List<Integer>> SCCList = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//필요한 변수들 초기화
			graph.clear();
			for(int j = 0; j < N + 1; j++) {
				graph.add(new ArrayList<>());
			}
			order = sccNum = 0;
			visitOrder = new int[N + 1];
			sccNums = new int[N + 1];
			finished = new boolean[N + 1];
			stack.clear();
//			SCCList.clear();
			
			for(int j = 0; j < M; j++) {	//그래프 생성
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph.get(x).add(y);
			}
			
			for(int j = 1; j < N + 1; j++) {	//모든 정점에 대하여 타잔 DFS
				if(visitOrder[j] == 0) {
					dfs(j);
				}
			}
			
			//SCC를 구성한 상태에서 SCC간 DAG가 성립하고 이때 indegree가 0인 SCC의 개수가 쓰러뜨릴 최소 도미노 수와 같다.
			inDegree = new int[sccNum];
			for(int j = 1; j < N + 1; j++) {
				for(int k : graph.get(j)) {	//j -> k의 간선이 있을때 정점 j와 k가 같은 scc에 속하지 않으면 k가 속한 SCC의 진입차수(indegree)는 증가한다.
					if(sccNums[j] != sccNums[k]) {
						inDegree[sccNums[k]]++;
					}
				}
			}
			int result = 0;
			for(int j = 0; j < sccNum; j++) {
				if(inDegree[j] == 0) {
					result++;
				}
			}
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int dfs(int curr) {
		visitOrder[curr] = ++order;	//방문 순서 번호
		stack.push(curr);	//SCC를 위해 현재 정점 스택 쌓기
		int result = visitOrder[curr];	//현재 정점에서 도달 가능한 가장 높은 조상 방문 순서 번호
		
		for(int next : graph.get(curr)) {
			if(visitOrder[next] == 0) {	//다음 정점이 아직 방문 안한 경우
				result = Math.min(result, dfs(next));
			}else if(!finished[next]) {	//다음 정점을 방문 했으나 아직 SCC가 아닌 경우
				result = Math.min(result, visitOrder[next]);
			}
		}
		
		//가장 높은 조상 방문 순서 번호가 자기 자신 방문 순서 번호와 같다면 SCC 구성
		if(result == visitOrder[curr]) {
//			List<Integer> scc = new ArrayList<>();
			while(!stack.isEmpty()) {	//현재 정점이 나올때까지 정점을 뽑는다.
				int t = stack.pop();
//				scc.add(t);
				finished[t] = true;	//해당 정점이 SCC에 속함을 표시
				sccNums[t] = sccNum;	//같은 scc에 있음을 알게끔 넘버링
				if(t == curr) {
					break;
				}
			}
//			SCCList.add(scc);
			sccNum++;
		}
		
		return result;	//현재 정점에서 도달 가능한 가장 높은 조상 순서 번호
	}
}
