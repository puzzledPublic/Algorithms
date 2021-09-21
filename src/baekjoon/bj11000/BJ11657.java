package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//타임머신
public class BJ11657 {
	static class Node {
		int vertex;
		long weight;
		public Node(int vertex, long weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		List<List<Node>> list = new ArrayList<>(N);
		for(int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
			list.get(a).add(new Node(b, w));
		}
		solve(list, 1, N, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(List<List<Node>> list, int start, int n, Writer w) throws IOException {	//벨만-포드
		long[] upper = new long[n + 1];
		for(int i = 0; i < n + 1; i++) {
			upper[i] = Long.MAX_VALUE;
		}
		upper[start] = 0;	//시작점은 distance가 0으로 초기화
		boolean updated = false;
		for(int i = 1; i < n + 1; i++) {
			updated = false;
			for(int here = 1; here < n + 1; here++) {
				for(Node node : list.get(here)) {
					long cost = node.weight;
					int there = node.vertex;
					if(upper[here] != Long.MAX_VALUE && upper[there] > upper[here] + cost) {	//upper[here] == INF라는것은 시작점(1) ~ here까지의 경로가 아직 없다는 것
						upper[there] = upper[here] + cost;
						updated = true;
					}
				}
			}
			if(!updated) {
				break;
			}
		}
		if(updated) {	//음수 사이클이 존재하면
			w.write("-1\n");
		}else {	//아니라면 시작점을 제외한 모든 정점들까지 최단 거리 출력
			for(int i = 2; i < upper.length; i++) {
				if(upper[i] >= 5000000000L) {	//도달 불가능하면 -1	, 음수간선만 있다면 (987654321 + 음수)가 최소값이 되어버리므로 하한선을 더 낮게 잡자.
					w.write("-1\n");
				}else {
					w.write(upper[i] + "\n");
				}
			}
		}
	}
}
