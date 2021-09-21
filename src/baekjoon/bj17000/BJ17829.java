package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//222-풀링
public class BJ17829 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(divCon(0, 0, N) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int divCon(int x, int y, int n) {	//분할 정복
		if(n == 1) {
			return arr[x][y];
		}
		
		int next = n / 2;
		int[] tmp = new int[4];
		tmp[0] = divCon(x, y, next);
		tmp[1] = divCon(x + next, y, next);
		tmp[2] = divCon(x, y + next, next);
		tmp[3] = divCon(x + next, y + next, next);
		Arrays.sort(tmp);
		
		return tmp[2];	//4개 숫자중 2번째로 큰 숫자 반환
	}
}
