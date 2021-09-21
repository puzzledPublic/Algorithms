package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//색종이 만들기
public class BJ2630 {
	static int N, blue, white;
	static int[][] paper;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divideConquer(0, 0, N);
		
		bw.write(white + "\n" + blue + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void divideConquer(int x, int y, int n) {	//(x, y)로 시작하는 nxn구역을 잘랐을때 하얀색, 파란색 종이 개수
		
		int sum = 0;
		for(int i = x; i < x + n; i++) {	//해당 구역 조사
			for(int j = y; j < y + n; j++) {
				sum += paper[i][j];
			}
		}
		
		if(sum == 0) {	//합이 0이라면 white
			white++;
		}else if(sum == n * n) {	//합이 구역 크기와 같다면 blue
			blue++;
		}else {	//그 외인 경우
			//4분할
			divideConquer(x, y, n / 2);
			divideConquer(x + n / 2, y, n / 2);
			divideConquer(x, y + n / 2, n / 2);
			divideConquer(x + n / 2, y + n / 2, n / 2);
		}
	}
}
