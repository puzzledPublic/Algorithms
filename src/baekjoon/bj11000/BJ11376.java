package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//열혈강호2
public class BJ11376 {
	static int[] employee;
	static int[] job;
	static boolean[] visited;
	static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		employee = new int[N * 2 + 1];
		visited = new boolean[N * 2 + 1];
		job = new int[M + 1];
		
		for(int i = 0; i < N * 2 + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 1; i < N * 2 + 1; i += 2) {
			st = new StringTokenizer(br.readLine(), " ");
			int len = Integer.parseInt(st.nextToken());
			for(int j = 0; j < len; j++) {
				int job = Integer.parseInt(st.nextToken());
				graph.get(i).add(job);
				graph.get(i + 1).add(job);	//한명이 일을 2개씩 맡을 수 있다. 이분매칭에서 유량이 1인 간선을 전제하므로 똑같은 정점을 하나 더 만들어 유량이 1임을 유지한다.
			}
		}
		
		Arrays.fill(employee, -1);
		Arrays.fill(job, -1);
		
		int match = 0;
		for(int i = 1; i < N * 2 + 1; i++) {
			if(employee[i] == -1) {
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
	
	static boolean dfs(int curr) {
		visited[curr] = true;
		for(int next : graph.get(curr)) {
			if(job[next] == -1 || (!visited[job[next]] && dfs(job[next]))) {
				employee[curr] = next;
				job[next] = curr;
				return true;
			}
		}
		return false;
	}
}
