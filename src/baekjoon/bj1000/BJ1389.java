package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//케빈 베이컨이 6단계 법칙
public class BJ1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] relation = new int[N + 1][N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			for(int j = 0; j < N + 1; j++) {
				relation[i][j] = 987654321;
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			relation[a][b] = relation[b][a] = 1;
		}
		//플로이드 와샬
		for(int k = 1; k < N + 1; k++) {
			for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(i != j && relation[i][j] > relation[i][k] + relation[k][j]) {
						relation[i][j] = relation[i][k] + relation[k][j];
					}
				}
			}
		}
		
		int lowest = 0, min = 987654321;
		for(int i = 1; i < N + 1; i++) {	//해당 번호의 케빈베이컨의 합을 센다.
			int sum = 0;
			for(int j = 1; j < N + 1; j++) {
				if(i != j) {
					sum += relation[i][j];
				}
			}
			if(min > sum) {					//그 중 가장 최소값을 가지는 번호를 계산
				min = sum;
				lowest = i;
			}
		}
		bw.write(lowest + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
