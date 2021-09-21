package swExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//[Professional] 운동
//실제 제출 코드는 Scanner로 입력을 받아야 Runtime Error 안남..
public class SWEA5684 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long[][] floyd = new long[N + 1][N + 1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					floyd[i][j] = 9876543210L;
				}
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				floyd[s][e] = c;
			}
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						if(floyd[i][j] > floyd[i][k] + floyd[k][j]) {
							floyd[i][j] = floyd[i][k] + floyd[k][j];
						}
					}
				}
			}
			long min = 9876543210L;
			for(int i = 1; i <= N; i++) {
				if(min > floyd[i][i]) {
					min = floyd[i][i];
				}
			}
			bw.write("#" + t + " " + (min == 9876543210L ? -1 : min) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
