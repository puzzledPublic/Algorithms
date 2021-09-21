package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//한윤정이 이탈리아에 가서 아이스크림을 사먹는데
public class BJ2422 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[3];
		boolean[][][] tak = new boolean[N + 1][N + 1][N + 1];
		int count = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= N; j++) {
				if(j != a && j != b) {
					arr[0] = a;
					arr[1] = b;
					arr[2] = j;
					Arrays.sort(arr);
					if(!tak[arr[0]][arr[1]][arr[2]]) {
						tak[arr[0]][arr[1]][arr[2]] = true;
						count++;
					}
				}
			}
		}
		
		bw.write(((N * (N - 1) * (N - 2) / 6) - count) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
