package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//축사 배정
public class BJ2188 {
	static int[] cow;
	static int[] barn;
	static boolean[] visited;
	static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		cow = new int[N + 1];
		barn = new int[M + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int len = Integer.parseInt(st.nextToken());
			for(int j = 0; j < len; j++) {
				graph.get(i + 1).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		Arrays.fill(cow, -1);
		Arrays.fill(barn, -1);
		
		int match = 0;
		for(int i = 1; i < N + 1; i++) {
			if(cow[i] == -1) {
				Arrays.fill(visited, false);
				if(dfs(i)) {
					match++;
				}
			}
		}
		
		bw.write(match + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean dfs(int curr) {	//이분매칭
		visited[curr] = true;
		for(int next : graph.get(curr)) {
			if(barn[next] == -1 || (!visited[barn[next]] && dfs(barn[next]))) {
				cow[curr] = next;
				barn[next] = curr;
				return true;
			}
		}
		return false;
	}
}
