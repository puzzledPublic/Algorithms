package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//마약수사대
public class BJ17220 {
	static boolean[][] graph;
	static int[] indegree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N][N];	//인접 배열 그래프
		indegree = new int[N];	//마약 원산지를 알아내기 위한 각 정점의 진입차수
		visited = new boolean[N];	//dfs를 위한 체크 배열
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int src = st.nextToken().charAt(0) - 'A';
			int dst = st.nextToken().charAt(0) - 'A';
			graph[src][dst] = true;	//src -> dst 경로 표시
			indegree[dst]++;	//dst 진입차수 증가
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int arrestCount = Integer.parseInt(st.nextToken());
		for(int i = 0; i < arrestCount; i++) {
			int suspect = st.nextToken().charAt(0) - 'A';	//체포된 마약 공급처
			for(int j = 0; j < N; j++) {
				graph[suspect][j] = graph[j][suspect] = false;	//체포된 마약 공급처와 관련된 경로를 모두 끊는다.
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(indegree[i] == 0) {	//마약 원산지부터 dfs를 통해 마약 공급처 개수를 알아낸다.
				result += (dfs(i) - 1);	//마약 원산지는 마약을 공급받지 않으므로 개수에서 뺀다.
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int dfs(int src) {
		visited[src] = true;
		int ret = 1;
		for(int dst = 0; dst < graph.length; dst++) {
			if(graph[src][dst] && !visited[dst]) {
				ret += dfs(dst);
			}
		}
		return ret;
	}
}
