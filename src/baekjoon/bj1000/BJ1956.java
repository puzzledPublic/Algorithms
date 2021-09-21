package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//운동
public class BJ1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		long[][] graph = new long[V + 1][V + 1];
		
		for(int i = 0; i < V + 1; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);	//초기값을 높게 줘서 floyd시 최소 값을 구할 수 있도록 한다.
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A][B] = C;
		}
		
		//floyd 알고리즘.
		//graph[i][j]와 graph[j][i]가 존재하면 사이클이 존재함을 알 수 있다.
		for(int k = 1; k < V + 1; k++) {
			for(int i = 1; i < V + 1; i++) {
				for(int j = 1; j < V + 1; j++) {
					if(i != j && graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}
		
		long min = Integer.MAX_VALUE;
		for(int i = 1; i < V + 1; i++) {
			for(int j = 1; j < V + 1; j++) {
				min = Math.min(min, graph[i][j] + graph[j][i]);	//i->j->i로 오는 길이가 최소인 것을 찾는다. (사이클)
			}
		}
		
		bw.write((Integer.MAX_VALUE <= min ? "-1" : min) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
