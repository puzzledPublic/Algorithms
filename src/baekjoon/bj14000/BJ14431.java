package baekjoon.bj14000;

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

//소수마을
//채점 데이터에 \f \n \t \r 중에 몇개가 섞여있는지 입력 런타임 에러 발생.
public class BJ14431 {
	static class Edge {
		int num, x, y, d;
		Edge(int num, int x, int y, int d) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] notPrime = new boolean[9000];
		notPrime[0] = notPrime[1] = true;
		for(int i = 2; i * i < 9000; i++) {	//소수 구하기.
			if(!notPrime[i]) {
				for(int j = i + i; j < 9000; j += i) {
					notPrime[j] = true;
				}
			}
		}
		
		List<Edge> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		list.add(new Edge(0, x1, y1, 0));
		list.add(new Edge(1, x2, y2, 0));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Edge(i + 2, x, y, 0));
		}
		
		int[] dist = new int[N + 2];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.d - b.d);
		dist[0] = 0;
		pq.add(list.get(0));
		
		while(!pq.isEmpty()) {	//다익스트라.
			Edge curr = pq.poll();
			
			if(curr.d > dist[curr.num]) {
				continue;
			}
			
			for(Edge next : list) {	//인접정점에 대해
				//거리 구하기
				int distance = (int)Math.sqrt((double)((next.x - curr.x) * (next.x - curr.x) + (next.y - curr.y) * (next.y - curr.y)));
				//거리가 소수이고 최소가 되면 계속 탐색
				if(curr.num != next.num && !notPrime[distance] && curr.d + distance < dist[next.num]) {
					dist[next.num]= curr.d + distance;
					pq.add(new Edge(next.num, next.x, next.y, curr.d + distance));
				}
			}
		}
		
		bw.write((dist[1] == Integer.MAX_VALUE ? -1 : dist[1]) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
