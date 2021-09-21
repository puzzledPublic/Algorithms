package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//연결 요소의 개수
public class BJ11724 {
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		chk = new boolean[N + 1];
		List<List<Integer>> list = new ArrayList<>(N + 1);
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		int count = 0;
		for(int i = 1; i < N + 1; i++) {
			if(!chk[i]) {
				count++;
				//solve(list, i);
				solve2(list, i);
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(List<List<Integer>> list, int start) {	//bfs
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		chk[start] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i : list.get(current)) {
				if(!chk[i]) {
					chk[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
	static void solve2(List<List<Integer>> list, int start) {	//dfs
		chk[start] = true;
		for(Integer i : list.get(start)) {
			if(!chk[i]) {
				solve2(list, i);
			}
		}
	}
}
