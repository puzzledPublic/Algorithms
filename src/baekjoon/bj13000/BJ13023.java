package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//ABCDE
public class BJ13023 {
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static boolean isEnd;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);	//그래프생성
			graph.get(b).add(a);
		}
		
		for(int i = 0; i < N; i++) {	//모든 정점에 대해 dfs
			if(!visited[i]) {
				dfs(i, 0);
			}
			if(isEnd) break;	//친구관계가 존재하면 바로 종료
		}
		
		bw.write((isEnd ? 1 : 0) + "\n"); 
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int curr, int dep) {
		visited[curr] = true;
		if(isEnd) return;
		if(dep == 4) {	//친구 관계가 존재하면 바로 종료
			isEnd = true;
			return;
		}
		for(int next : graph.get(curr)) {
			if(!visited[next]) {
				dfs(next, dep + 1);
			}
		}
		visited[curr] = false;	//현재 온 경로보다 더 긴 경로가 존재할 수 있으므로 초기화 해서 다음에 방문할 수 있도록 한다.
		//ex) 0-1, 1-2, 1-3, 2-3, 3-4
	}
}
