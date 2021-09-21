package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//Strongly Connected Components
//(타잔 알고리즘)
public class BJ2150 {
	static int V, E, cnt, SN;	//정점, 간선 수, DFS 방문 순서, 몇 번째 SCC인지
	static List<List<Integer>> graph;	//방향 그래프
	static int[] dfsn;	//i 정점의 방문 순서(cnt)
	static int[] sn;	//i 정점의 SCC 번호(SN)
	static boolean[] finished;	//i번 정점이 SCC에 속하는지 여부
	static Stack<Integer> stack = new Stack<>();	//DFS에서 SCC를 추출하기 위한 스택
	static List<List<Integer>> SCC = new ArrayList<>();	//완성된 SCC들을 담기 위한 리스트
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {	//그래프 생성
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
		}
		
		dfsn = new int[V + 1];
		sn = new int[V + 1];
		finished = new boolean[V + 1];
		
		for(int i = 1; i < V + 1; i++) {	//컴포넌트가 여러개 존재 할 수 있으므로 모든 정점에서 DFS 탐색 시도
			if(dfsn[i] == 0) {
				dfs(i);
			}
		}
		
		bw.write(SN + "\n");	//SCC 개수
		Collections.sort(SCC, (a, b) -> a.get(0) - b.get(0));	//문제에서 정렬하여 출력하기 원하므로 정렬
		for(List<Integer> list : SCC) {	//SCC 출력
			for(int i : list) {
				bw.write(i + " ");
			}
			bw.write("-1\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static int dfs(int curr) {
		dfsn[curr] = ++cnt;	//방문 순서 번호
		stack.push(curr);	//현재 방문한 정점을 스택에 쌓는다.
		
		int result = dfsn[curr];	//현재 정점에서 도달가능한 최고 조상 방문 순서 번호
		for(int i : graph.get(curr)) {
			if(dfsn[i] == 0) {	//다음 정점이 아직 방문 전인 경우
				result = Math.min(result, dfs(i));
			}else if(!finished[i]) {	//방문 했으나 아직 SCC가 아닌 경우
				result = Math.min(result, dfsn[i]);
			}
		}
		
		if(result == dfsn[curr]) {	//최고 조상 방문 순서가 자기 방문 순서와 일치하면 SCC로 묶는다.
			List<Integer> currSCC = new ArrayList<>();
			while(true) {	//자기 정점 번호가 나올때까지 스택에서 뽑아 SCC구성
				int t = stack.pop();
				currSCC.add(t);
				finished[t] = true;	//t정점은 SCC임을 체크
				sn[t] = SN;	//t 정점이 SN 번호를 갖는 SCC임을 나타낸다.
				if(t == curr) {
					break;
				}
			}
			Collections.sort(currSCC);	//문제에서 정렬하길 원하므로 정렬
			SCC.add(currSCC);
			SN++;	//SCC 번호(개수) 증가
		}
		
		return result;	//curr 정점에서 도달 가능한 최고 조상 방문 순서 번호
	}
}
