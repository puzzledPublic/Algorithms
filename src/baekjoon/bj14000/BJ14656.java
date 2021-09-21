package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//조교는 새디스트야!!
public class BJ14656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for(int i = 0; i < N; i++) {
			int in = Integer.parseInt(st.nextToken());
			if(i + 1 != in) {
				sum++;
			}
		}
		
		bw.write(sum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
