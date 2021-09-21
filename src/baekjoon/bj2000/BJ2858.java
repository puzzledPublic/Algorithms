package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//기숙사 바닥
public class BJ2858 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		for(int i = 1; i * i <= B; i++) {
			if(B % i == 0) {
				if((((B / i) + 2) * (i + 2)) - B == R) {	//1xN, 2x(N/2)... nx(N/n)(N%n==0)를 검사하며 전체 바닥갯수를 구할 수 있고 여기서 B의 갯수를 뺀 갯수가 R이라면 B의 세로,가로를 확정 지을 수 있다.
					bw.write(((B / i) + 2) + " " + (i + 2));
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
