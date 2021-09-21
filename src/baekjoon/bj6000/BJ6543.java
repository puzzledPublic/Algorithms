package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

//그래프의 싱크 (Strongly Connected Components)
public class BJ6543 {
	static int V, E, order, sccNum;
	static int[] sccNums;	//i정점이 SCC에 속한 번호
	static int[] visitOrder;	//방문 순서
	static boolean[] finished;	//SCC에 속했는지 검사
	static Stack<Integer> stack = new Stack<>();
	static List<List<Integer>> graph = new ArrayList<>();
	static List<List<Integer>> SCCList = new ArrayList<>();	//각 SCC에 속한 정점 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if(st.countTokens() == 1) {
				break;
			}
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			SCCList.clear();	//변수들 초기화
			graph.clear();
			for(int i = 0; i < V + 1; i++) {
				graph.add(new ArrayList<>());
			}
			order = sccNum = 0;
			sccNums = new int[V + 1];
			visitOrder = new int[V + 1];
			finished = new boolean[V + 1];
			stack.clear();
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 0; i < E; i++) {	//그래프 생성
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				graph.get(A).add(B);
			}
			
			for(int i = 1; i < V + 1; i++) {	//아직 방문하지 않은 정점에 대해 타잔 알고리즘 적용하여 SCC를 구한다.
				if(visitOrder[i] == 0) {
					dfs(i);
				}
			}
			
			Set<Integer> outDegreeNotZeroSCCSet = new TreeSet<>();	//outdegree(진출 차수)가 있는 SCC 번호를 넣을 set
			for(int i = 1; i < V + 1; i++) {
				for(int j : graph.get(i)) {
					if(sccNums[i] != sccNums[j]) {	//정점 i -> j로 가는 간선이 있을때 i와 j가 같은 SCC가 아니라면 정점 i에 속한 SCC는 outdegree가 존재한다.
						outDegreeNotZeroSCCSet.add(sccNums[i]);
					}
				}
			}
			
			List<Integer> result = new ArrayList<>();
			for(int i = 0; i < SCCList.size(); i++) {
				if(!outDegreeNotZeroSCCSet.contains(i)) {	//outDegree가 존재하지 않는 SCC라면 결과에 저장.
					result.addAll(SCCList.get(i));
				}
			}
			
			Collections.sort(result);	//정렬 후 출력
			for(int i : result) {
				bw.write(i + " ");
			}
			bw.write("\n");
		}
		
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
			List<Integer> scc = new ArrayList<>();
			while(!stack.isEmpty()) {
				int t = stack.pop();
				scc.add(t);
				finished[t] = true;
				sccNums[t] = sccNum;
				if(t == curr) {
					break;
				}
			}
			SCCList.add(scc);
			sccNum++;
		}
		
		return result;
	}
}
