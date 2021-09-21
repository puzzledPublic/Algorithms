package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//숨바꼭질
public class BJ1697 {
	static class Pos {
		int position, time;
		public Pos(int position, int time) {
			this.position = position;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		if(N == K) {
			System.out.println(0);
		}else {
			solve(N, K);
		}
		br.close();
	}
	
	static void solve(int N, int K) {	//BFS
		boolean[] check = new boolean[100001];
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(N, 0));
		check[N] = true;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			int current = p.position;
			if(p.position == K) {								//도착한 경우 출력
				System.out.print(p.time + " ");
				break;
			}
			if(current + 1 <= 100000 && !check[current + 1]) {	//현재위치 + 1로 가는 경우
				queue.add(new Pos(current + 1, p.time + 1));
				check[current + 1] = true;
			}
			if(current - 1 >= 0 && !check[current - 1]) {		//현재위치 - 1로 가는 경우
				queue.add(new Pos(current - 1, p.time + 1));
				check[current - 1] = true;
			}
			if(current * 2 <= 100000 && !check[current * 2]) {	//현재위치 * 2로 가는 경우
				queue.add(new Pos(current * 2, p.time + 1));
				check[current * 2] = true;
			}
		}
	}
}
