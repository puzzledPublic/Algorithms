package baekjoon.bj13000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주식 투자
public class BJ13416 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] arr = new int[1000][3];
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for(int i = 0; i < N; i++) {
				if(!(arr[i][0] < 0 && arr[i][1] < 0 && arr[i][2] < 0)) {	//3곳 모두 음수라면 구매하지 않고 그 외의 경우 최대값을 갖는 곳을 고른다.
					result += Math.max(arr[i][0], Math.max(arr[i][1], arr[i][2]));
				}
			}
			
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
