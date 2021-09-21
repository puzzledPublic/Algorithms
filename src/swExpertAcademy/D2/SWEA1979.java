package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//어디에 단어가 들어갈 수 있을까
public class SWEA1979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][N];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < N; k++) {
					arr[j][k] = st.nextToken().charAt(0);
				}
			}
			int result = 0;
			for(int j = 0; j < N; j++) {	//가로 검사
				for(int k = 0; k < N; k++) {
					if(arr[j][k] == '0') {
						continue;
					}else {
						int count = 0;
						while(k < N && arr[j][k] != '0') {
							count++;
							k++;
						}
						if(count == K) {
							result++;
						}
					}
				}
			}
			for(int j = 0; j < N; j++) {	//세로 검사
				for(int k = 0; k < N; k++) {
					if(arr[k][j] == '0') {
						continue;
					}else {
						int count = 0;
						while(k < N && arr[k][j] != '0') {
							count++;
							k++;
						}
						if(count == K) {
							result++;
						}
					}
				}
			}
			bw.write("#" + i + " " + result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
