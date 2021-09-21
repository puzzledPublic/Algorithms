package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//숫자 배열 회전
public class SWEA1961 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[7][7];
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < N; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			bw.write("#" + i + "\n");
			//시계방향으로 회전
			for(int j = 0; j < N; j++) {
				for(int k = N - 1; k >= 0; k--) {	//90도
					bw.write(arr[k][j] + 48);
				}
				bw.write(" ");
				for(int k = N - 1; k >= 0; k--) {	//180도
					bw.write(arr[N - j - 1][k] + 48);
				}
				bw.write(" ");
				for(int k = 0; k < N; k++) {		//270도
					bw.write(arr[k][N - j - 1] + 48);
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
