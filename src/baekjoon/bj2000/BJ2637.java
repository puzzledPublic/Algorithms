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

//장난감 조립
public class BJ2637 {
	static int[] indegree;
	static int[] copyDegree;
	static int[][] fromTo;
	static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		indegree = new int[N + 1];	//진입차수
		copyDegree = new int[N + 1];	//초기 진입차수가 0인것들이 기본부품이 된다.
		fromTo = new int[N + 1][N + 1];	//i -> j를 만들때 드는 i부품의 개수
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			fromTo[Y][X] = K;
			indegree[X]++;
			copyDegree[X]++;
			graph.get(Y).add(X);
		}
				
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {	//위상정렬을 위해 진입차수가 0인 부품들을 추가
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {	//위상정렬
			int curr = queue.poll();
			
			for(int next : graph.get(curr)) {
				indegree[next]--;	//진입차수 감소
				for(int i = 1; i <= N; i++) {	//i -> next로 가는 부품들의 개수는 i -> curr의 개수 * curr -> next 개수가 된다.
					fromTo[i][next] += (fromTo[i][curr] * fromTo[curr][next]);
				}
				if(indegree[next] == 0) {	//진입차수가 0이 되면 큐에 추가
					queue.add(next);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(copyDegree[i] == 0) {	//기본부품들만 출력
				bw.write(i + " " + fromTo[i][N] + "\n");	//기본부품 -> 완제품까지 만드는데 사용되는 기본부품의 개수
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
