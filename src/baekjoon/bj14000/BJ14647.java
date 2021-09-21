package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//준오는 조류혐오야!!
public class BJ14647 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int totalCount = 0;	//총 9 개수
		int maxCount = 0;	//행,열 중 최대 9 개수
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = nineCount(st.nextToken());	//9 개수
				totalCount += arr[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {	//행 중 최대 9 개수 
			int row = 0;
			for(int j = 0; j < M; j++) {
				row += arr[i][j];
			}
			maxCount = Math.max(maxCount, row);
		}
		
		for(int i = 0; i < M; i++) {	//열 중 최대 9 개수
			int col = 0;
			for(int j = 0; j < N; j++) {
				col += arr[j][i];
			}
			maxCount = Math.max(maxCount, col);
		}
		
		bw.write((totalCount - maxCount) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int nineCount(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			count += (str.charAt(i) == '9' ? 1 : 0);
		}
		return count;
	}
}
