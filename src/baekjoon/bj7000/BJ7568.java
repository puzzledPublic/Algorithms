package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//덩치
public class BJ7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
		}
		solve(N, data, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int N, int[][] data, Writer w) throws IOException {
		int count;
		for(int i = 0; i < N; i++) {	//모든 사람에 대해
			count = 1;
			for(int j = 0; j < N; j++) {
				if(i != j) {	//자기자신을 제외한 사람하고 비교
					if(data[i][0] < data[j][0] && data[i][1] < data[j][1]) { //내 덩치가 작다면 등수 증가
						count++;
					}
				}
			}
			data[i][2] = count;
		}
		for(int i = 0; i < N - 1; i++) {	//출력
			w.write(data[i][2] + " "); 
		}
		w.write(data[N - 1][2] + "\n"); 
	}
}
