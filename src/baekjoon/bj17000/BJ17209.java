package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//새내기와 헌내기 (이분그래프)
//정점이 서로 연결돼 있을때 한 정점이 새내기라면 바로 이어지는 정점은 헌내기가 돼야한다.
//이는 이분그래프를 조사하는 것과 같고, 그래프가 여러개 있을 수 있으니 각 그래프마다 최대 개수를 구해 더해주면 된다.
public class BJ17209 {
	static List<TreeSet<Integer>> graph = new ArrayList<>();
	static int[] visited;
	static int a, b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			graph.add(new TreeSet<>());
		}
		visited = new int[N];
		
		for(int i = 0; i < N; i++) {
			char[] points = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				if(points[j] == '1') {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(visited[i] == 0) {
				a = b = 0;
				visited[i] = 1;
				dfs(i);
				result += Math.max(a, b);
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int src) {
		if(visited[src] == 1) {
			a++;
		}else {
			b++;
		}
		for(int next : graph.get(src)) {
			if(visited[next] == 0) {
				visited[next] = 3 - visited[src];
				dfs(next);
			}
		}
	}
}
