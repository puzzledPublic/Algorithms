package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//NN
public class BJ11944 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder sb = new StringBuilder();
		String N = st.nextToken();
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < Integer.parseInt(N); i++) {	//N을 N번 반복하여 출력
			sb.append(N);
		}
		
		bw.write(sb.substring(0, Math.min(sb.length(), M)));	//그 길이가 M을 넘으면 M길이 만큼 잘라 출력
		bw.flush();
		bw.close();
		br.close();
		
	}
}
