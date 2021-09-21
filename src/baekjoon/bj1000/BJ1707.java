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

//이분그래프
public class BJ1707 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
			
			List<Integer>[] graph = new List[V + 1];
			int[] vertex = new int[V + 1];
			
			for(int j = 0; j < V + 1; j++) {
				graph[j] = new ArrayList<>();
			}
			
			for(int j = 0; j < E; j++) {	//그래프 생성
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			boolean escape = false;
			for(int j = 1; j < V + 1; j++) {	//그래프 컴포넌트가 여러개일 수 있으니 모든 정점에 대해 탐색
				if(vertex[j] == 0) {
					Queue<Integer> queue = new LinkedList<>();
					queue.add(j);
					vertex[j] = 1;	//각 정점을 1과 2로 칠한다.
					while(!queue.isEmpty()) {
						int current = queue.poll();
						for(int k : graph[current]) {
							if(vertex[k] == 0) {	//아직 방문 안한 정점이라면 현재 정점과 반대되게 칠한다.
								queue.add(k);
								vertex[k] = 3 - vertex[current];
							}
							else if(vertex[current] == vertex[k]) {	//이미 방문한 정점이고 같은 색이라면 이분 그래프가 아니다. 종료.
								escape = true;
								break;
							}
						}
						if(escape) {
							break;
						}
					}
				}
				if(escape) {
					break;
				}
			}
			if(escape) {
				bw.write("NO\n");
			}else {
				bw.write("YES\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
