package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//기차 여행
public class BJ10713 {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] order = new int[M];	//도착 도시 순서
		tree = new long[N + 1];		//펜윅 트리
		long[][] trainCost = new long[N][3];	//i 철도의 비용(티켓, ic결제, ic카드)
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			trainCost[i][0] = Integer.parseInt(st.nextToken());
			trainCost[i][1] = Integer.parseInt(st.nextToken());
			trainCost[i][2] = Integer.parseInt(st.nextToken());
		}
		//도시를 도는데 order[i-1]에서 order[i]번째 도시로 가려면 그 사이의 도시를 모두 지나쳐야 한다. 
		//a -> b도시(a < b)로 가는 경우 a->a+1->a+2...->b처럼 이동해야하므로
		//k -> k+1번째 도시를 이동하는 횟수를 펜윅트리로 계산해보자
		//a -> b도시(a < b)는 1~a까지의 이용횟수를 1~b까지의 이용횟수로 빼서 갱신
		//sum(i) = i번째 철도를 이용하는 횟수
		for(int i = 1; i < M; i++) {	
			if(order[i] > order[i - 1]) {	
				update(order[i - 1], 1);	
				update(order[i], -1);
			}else {
				update(order[i - 1], -1);
				update(order[i], 1);
			}
		}
		//철도 이용횟수를 알면 이용하는 최소값을 알 수 있다.
		long result = 0;
		for(int i = 1; i < N + 1; i++) {
			long t = sum(i);
			if(t > 0) {
				result += Math.min(trainCost[i - 1][0] * t, trainCost[i - 1][1] * t + trainCost[i - 1][2]);
			}
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//펜윅트리 부분 합 연산
	static int sum(int pos) {
		int result = 0;
		while(pos > 0) {
			result += tree[pos];
			pos = pos & (pos - 1);
		}
		return result;
	}
	//펜윅트리 변경 연산
	static void update(int pos, int val) {
		while(pos < tree.length) {
			tree[pos] += val;
			pos += (pos & -pos);
		}
	}
}
