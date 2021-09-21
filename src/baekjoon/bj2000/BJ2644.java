package baekjoon.bj2000;

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

//촌수 계산
public class BJ2644 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<List<Integer>> list = new ArrayList<>(N + 1);
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		bw.write(solve(list, x, y, N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//bfs
	static int solve(List<List<Integer>> list, int x, int y, int N) {
		int[] visited = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);	//x부터 시작
		visited[x] = 1;	//0을 아직 방문 안함 그 외 다음 노드와의 촌수
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(Integer i : list.get(current)) {
				if(visited[i] == 0) {
					if(i == y) {	//y에 도달하면 바로 리턴
						return visited[current];
					}
					visited[i] = visited[current] + 1;
					queue.add(i);
				}
			}
		}
		return -1;	//연관된 노드들을 다 탐색해도 없으면 x와 y는 친척이 아니다.
	}
}
