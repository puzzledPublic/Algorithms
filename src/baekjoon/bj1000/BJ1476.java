package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//날짜 계산
public class BJ1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 1;
		int a = 1, b = 1, c = 1;
		while(true){
			if(E == a && S == b && M == c) {
				break;
			}
			a = (a + 1) % 16 == 0 ? 1 : a + 1;
			b = (b + 1) % 29 == 0 ? 1 : b + 1;
			c = (c + 1) % 20 == 0 ? 1 : c + 1;
			count++;
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
