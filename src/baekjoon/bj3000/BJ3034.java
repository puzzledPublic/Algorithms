package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//앵그리 창영
public class BJ3034 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
		
		int limit = W * W + H * H;
		
		for(int i = 0; i < N; i++) {
			int matches = Integer.parseInt(br.readLine());
			if(matches * matches <= limit) {
				bw.write("DA\n");
			}else {
				bw.write("NE\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
