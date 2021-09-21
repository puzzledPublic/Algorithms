package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//오일러 회로(a.k.a 한붓 그리기)
//오일러 회로가 존재하기 위해선 모든 정점의 차수가 짝수여야한다.
//오일러 트레일(한 점에서 시작하여 모든 간선을 한번씩 지나 다른 정점에 도착하는 경로)의 경우 시작점, 끝점은 차수가 홀수이며 나머지 정점의 차수는 짝수여야한다.
public class BJ1199 {
	static List<Integer> list = new ArrayList<>();
	static int[][] graph;	//i 정점과 j 정점이 연결된 간선의 개수
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		boolean existEulerCircuit = true;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				sum += graph[i][j];	//i 정점에 대해 연결된 간선의 개수를 센다.
			}
			if(sum % 2 != 0) {	//짝수가 아니라면 오일러 회로는 존재할 수 없다.
				existEulerCircuit = false;
				break;
			}
		}
		
		if(existEulerCircuit) {
			eulerianCircuit(0);
			for(int i : list) {
				bw.write(i + " ");
			}
		}else {
			bw.write("-1\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//오일러 회로 만들기
	static void eulerianCircuit(int here) {
		for(int there = 0; there < N; there++) {
			while(graph[here][there] > 0) {	//갈 수 있는 경로가 남아 있으면
				graph[here][there]--;	//무방향 그래프이므로 오는것 가는것 둘다 지운다.
				graph[there][here]--;
				eulerianCircuit(there);
			}
		}
		list.add(here + 1);	//오일러 회로의 마지막서부터 정점을 만들도록 한다.
	}
}
