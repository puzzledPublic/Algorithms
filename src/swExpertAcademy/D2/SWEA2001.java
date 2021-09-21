package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//파리퇴치
public class SWEA2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int j = 0; j < N - M + 1; j++) {
				for(int k = 0; k < N - M + 1; k++) {
					int count = 0;
					for(int u = j; u < j + M; u++) {
						for(int h = k; h < k + M; h++) {
							count += arr[u][h];
						}
					}
					if(max < count) {
						max = count;
					}
				}
			}
			bw.write("#" + i + " " + max + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
