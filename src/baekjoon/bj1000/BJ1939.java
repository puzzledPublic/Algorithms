package baekjoon.bj1000;

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

//중량제한 (BFS, Binary Search)
public class BJ1939 {
	static class Vertex{
		int number, weight;
		Vertex(int number, int weight) {
			this.number = number;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//정점 개수
		int M = Integer.parseInt(st.nextToken());	//다리 정보 개수
		
		List<List<Vertex>> graph = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		
		//그래프 생성
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph.get(A).add(new Vertex(B, C));
			graph.get(B).add(new Vertex(A, C));
		}
		
		st = new StringTokenizer(br.readLine(), " ");	//시작점, 끝점
		int sVertex = Integer.parseInt(st.nextToken());
		int eVertex = Integer.parseInt(st.nextToken());
		
		int start = 1, end = 1_000_000_001;
		while(start + 1 < end) {	//시작점에서 출발해 mid 중량 이상으로 끝점까지 갈 수 있는가?
			int mid = (start + end) / 2;
			boolean arrived = false;
			
			//BFS
			Queue<Integer> queue = new LinkedList<>();
			boolean[] chk = new boolean[N + 1];
			queue.add(sVertex);
			chk[sVertex] = true;
			while(!queue.isEmpty()) {
				int here = queue.poll();
				
				if(here == eVertex) {
					arrived = true;
					break;
				}
				
				for(Vertex v : graph.get(here)) {
					if(!chk[v.number] && v.weight >= mid) {
						chk[v.number] = true;
						queue.add(v.number);
					}
				}
			}

			if(arrived) {	//도착 가능하면 중량을 높인다.
				start = mid;
			}else {			//도착 불가능하면 중량을 낮춘다.
				end = mid;
			}
		}	
		
		bw.write(start + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
