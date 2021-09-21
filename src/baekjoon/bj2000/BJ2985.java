package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//세 수
public class BJ2985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		if(a + b == c) {
			bw.write(a + "+" + b + "=" + c + "\n");
		}else if(a - b == c) {
			bw.write(a + "-" + b + "=" + c + "\n");
		}else if(a * b == c) {
			bw.write(a + "*" + b + "=" + c + "\n");
		}else if(a / b == c) {
			bw.write(a + "/" + b + "=" + c + "\n");
		}else if(a == b + c) {
			bw.write(a + "=" + b + "+" + c + "\n");
		}else if(a == b - c) {
			bw.write(a + "=" + b + "-" + c + "\n");
		}else if(a == b * c) {
			bw.write(a + "=" + b + "*" + c + "\n");
		}else if(a == b / c) {
			bw.write(a + "=" + b + "/" + c + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
