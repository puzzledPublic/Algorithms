package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//서강그라운드
public class BJ14938 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[] items = new int[N + 1];
		int[][] map = new int[N + 1][N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(map[i], 987654321);
		}
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = l;	//양방향 도로
		}
		
		//플로이드
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i != j && map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int max = -1;
		for(int i = 1; i <= N; i++) {	//i에 떨어졌을때
			int sum = items[i];
			for(int j = 1; j <= N; j++) {
				if(map[i][j] <= M) {	//i -> j 가는 거리가 M보다 작으면 아이템 습득.
					sum += items[j];
				}
			}
			if(max < sum) {
				max = sum;
			}
		}
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
