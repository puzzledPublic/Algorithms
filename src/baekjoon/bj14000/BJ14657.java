package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//준오는 최종인재야!!
public class BJ14657 {
	static class Edge {
		int v, t;
		Edge(int v, int t) {
			this.v = v;
			this.t = t;
		}
	}
	static List<List<Edge>> tree = new ArrayList<>();
	static boolean[] chk;
	static int maxV, maxDist, minTime = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			tree.get(A).add(new Edge(B, C));
			tree.get(B).add(new Edge(A, C));
		}
		
		//문제의 그래프가 트리형태이다. 최대한 많은 문제를 풀되 시간을 최소화 시켜야한다.
		//정점을 방문했을때 다시 돌아올 수 없고 최대한 많은 정점을 지나가야 하므로 트리의 지름을 구하는 문제라고 생각할 수 있다.
		
		chk = new boolean[N + 1];	
		dfs(1, 0, 0);	//아무 정점(여기서는 1번)을 골라 그 정점에서 가장 먼 거리의 정점을 구한다.
			
		Arrays.fill(chk, false);
		maxDist = 0;
		minTime = Integer.MAX_VALUE;
		dfs(maxV, 0, 0);	//구한 정점에서 다시 가장 먼 거리의 정점을 구한다.
		
		bw.write((minTime % T != 0 ? minTime / T + 1 : minTime / T) + "\n");
		
		bw.flush();
		br.close();
		br.close();
	}
	
	static void dfs(int curr, int dist, int time) {
		chk[curr] = true;
		int count = 0;
		for(Edge next : tree.get(curr)) {
			if(!chk[next.v]) {
				dfs(next.v, dist + 1, time + next.t);
				count++;
			}
		}
		if(count == 0) {	//마지막 정점인 경우.
			if(maxDist < dist) {	//최대 거리 갱신.
				maxDist = dist;
				maxV = curr;
				minTime = time;
			}
			else if(maxDist == dist && minTime > time) {	//거리가 같다면 시간이 최소한으로 드는 정점으로 바꾼다.
				maxV = curr;
				minTime = time;
			}
		}
	}
}
