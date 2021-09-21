package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//여러분의 다리가 되어드리겠습니다!
public class BJ17352 {
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];
		
		for(int i = 0; i < N - 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//두 컴포넌트가 있으므로 dfs 돌려서 구분 해 놓는다.
		dfs(1);
		
		boolean first = visited[1];	//1번 섬을 고정하고 다른 컴포넌트에 속한 섬이 등장하면 출력 후 종료
		for(int i = 2; i <= N; i++) {
			if(first != visited[i]) {
				bw.write("1 " + i + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int start) {
		visited[start] = true;
		for(int next : graph.get(start)) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
}
