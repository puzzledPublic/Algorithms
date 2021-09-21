package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//해킹
public class BJ10282 {
	static class Edge {
		int v, w;
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	//컴퓨터 개수
			int D = Integer.parseInt(st.nextToken());	//의존성 개수
			int C = Integer.parseInt(st.nextToken());	//해킹당한 컴퓨터
			
			List<List<Edge>> graph = new ArrayList<>();	//컴퓨터 의존관계 그래프
			for(int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}
			
			int[] dist = new int[N + 1];	//i번 컴퓨터가 해킹당하는 최소 시간.
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken());	//A 컴퓨터가 B 컴퓨터에 의존한다.
				int B = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken());	//B 컴퓨터가 감염된 후 A 컴퓨터는 S초 후에 감염된다.
				graph.get(B).add(new Edge(A, S));
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
			pq.add(new Edge(C, 0));
			dist[C] = 0;
			while(!pq.isEmpty()) {	//다익스트라 알고리즘으로 해킹당한 C 컴퓨터부터 시작하여 모든 컴퓨터가 해킹당하는 최소 시간을 구한다.
				Edge curr = pq.poll();
				
				if(curr.w > dist[curr.v]) {
					continue;
				}
				
				for(Edge next : graph.get(curr.v)) {
					if(curr.w + next.w < dist[next.v]) {
						dist[next.v]= curr.w + next.w;
						pq.add(new Edge(next.v, curr.w + next.w));
					}
				}
			}
			
			int count = 0, time = 0;
			for(int i = 1; i <= N; i++) {	//dist 배열을 조사.
				if(dist[i] != Integer.MAX_VALUE) {	//도달가능(해킹가능)한 컴퓨터이면.
					count++;	//해킹당한 컴퓨터 수 증가
					time = Math.max(time, dist[i]);	//컴퓨터 중 제일 늦게 해킹당하는 시간을 구한다.
				}
			}
			
			bw.write(count + " " + time + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
