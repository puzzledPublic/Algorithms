package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//궁금한 민호	(플로이드 와샬을 이용한 풀이 공부 필요)
public class BJ1507 {
	static class RoadInfo {
		int a, b, time;
		RoadInfo(int a, int b, int time) {
			this.a = a;
			this.b = b;
			this.time = time;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<RoadInfo> list = new ArrayList<>();
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				list.add(new RoadInfo(i, j, arr[i][j]));
			}
		}
		
		int[][] graph = new int[N][N];
		boolean[] chk = new boolean[N];
		
		Collections.sort(list, (a, b) -> a.time - b.time);
		boolean impossible = false;
		for(int i = 0; i < list.size(); i++) {
			RoadInfo ri = list.get(i);
			for(int j = 0; j < N; j++) {
				chk[j] = false;
			}
			chk[ri.a] = true;
			min = 987654321;
			dfs(graph, chk, ri.a, ri.b, 0);
			if(min > ri.time) {
				graph[ri.a][ri.b] = graph[ri.b][ri.a] = ri.time; 
			}else if(min< ri.time){
				impossible = true;
				break;
			}
		}
		if(impossible) {
			bw.write("-1\n");
		}else {
			int sum = 0;
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					sum += graph[i][j];
				}
			}
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int min = 987654321;
	static void dfs(int[][] graph, boolean[] chk, int start, int end, int dist) {
		if(min < dist) {
			return;
		}
		if(start == end) {
			if(min > dist) {
				min = dist;
			}
		}
		for(int i = 0; i < graph.length; i++) {
			if(!chk[i] && graph[start][i] != 0) {
				chk[start] = true;
				dfs(graph, chk, i, end, dist + graph[start][i]);
				chk[start] = false;
			}
		}
	}
}
