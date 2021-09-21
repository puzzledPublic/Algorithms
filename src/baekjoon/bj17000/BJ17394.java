package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//핑거 스냅
public class BJ17394 {
	static class Organism {
		int amounts, snap;	//인구 수, 스냅 횟수
		Organism(int amounts, int snap) {
			this.amounts = amounts;
			this.snap = snap;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[100001];
		boolean[] visited = new boolean[1000001];
	
		for(int i = 2; i * i <= 100000; i++) {	//범위가 2 ~ 10만이므로 10만 내의 소수들을 에라토스테네스의 체로 구해 놓는다.
			if(!prime[i]) {
				for(int j = i * 2; j <= 100000; j += i) {
					prime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Arrays.fill(visited, false);
			int snap = -1;
			Queue<Organism> queue = new LinkedList<>();
			queue.add(new Organism(N, 0));
			while(!queue.isEmpty()) {	//BFS
				Organism org = queue.poll();
				if(A <= org.amounts && org.amounts <= B) {	//인구수가 A ~ B 사이이고
					if(!prime[org.amounts]) {	//소수라면 바로 종료.
						snap = org.snap;
						break;
					}
				}
				if(!visited[org.amounts / 2]) {
					visited[org.amounts / 2] = true;
					queue.add(new Organism(org.amounts / 2, org.snap + 1));
				}
				if(!visited[org.amounts / 3]) {
					visited[org.amounts / 3] = true;
					queue.add(new Organism(org.amounts / 3, org.snap + 1));
				}
				if(org.amounts + 1 < 300001 && !visited[org.amounts + 1]) {
					visited[org.amounts + 1] = true;
					queue.add(new Organism(org.amounts + 1, org.snap + 1));
				}
				if(org.amounts > 0 && !visited[org.amounts - 1]) {
					visited[org.amounts - 1] = true;
					queue.add(new Organism(org.amounts - 1, org.snap + 1));
				}
			}
			bw.write(snap + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
