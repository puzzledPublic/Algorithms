package baekjoon.bj1000;

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

//최소 비용 구하기
public class BJ1916 {
	static class Bus {
		int vertex;
		long weight;
		Bus(int vertex, long weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
		List<Bus>[] graph = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
			graph[s].add(new Bus(e, w));	//시작점 s에서 도착점 e인 버스 비용w
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
		
		long[] dist = new long[N + 1];	//dist[i] = i까지의 가는데 드는 최소비용.
		Arrays.fill(dist, 9876543210L);
		dist[start] = 0;	//시작점 start는 비용이 0이다.
		
		PriorityQueue<Bus> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));		
		pq.add(new Bus(start, 0));
		
		while(!pq.isEmpty()) {
			Bus current = pq.poll();
			//이미 구해놓은 현재 정점까지의 길이가 더 작다면 더 탐색할 필요가 없으므로 넘어간다.
			if(dist[current.vertex] < current.weight) {
				continue;
			}
			for(Bus bus : graph[current.vertex]) {
				//이미 구한 정점(dist[bus.vertex])까지의 비용보다 현재 정점까지 왔을때 비용(current.weight) + 현재 정점에서 다음 정점까지의 비용(bus.weight)이 더 적다면 갱신. 
				if(dist[bus.vertex] > current.weight + bus.weight) {
					dist[bus.vertex] = current.weight + bus.weight;
					pq.add(new Bus(bus.vertex, dist[bus.vertex]));
				}
			}
		}
		
		bw.write(dist[end] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
