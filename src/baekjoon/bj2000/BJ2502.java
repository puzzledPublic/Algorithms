package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//떡먹는 호랑이
public class BJ2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int prevX = 0, X = 1, prevY = 1, Y = 1;
		//day[D] = day[D - 1] + day[D - 2]이므로 day[D] = X * day[1] + Y * day[2]가 되도록 만들 수 있고
		//D를 늘려가며 살펴보면 각 X, Y는 피보나치 수열을 이룬다.
		for(int i = 3; i < D; i++) {	//X, Y를 구한다.
			int tX = prevX + X;
			prevX = X;
			X = tX;
			int tY = prevY + Y;
			prevY = Y;
			Y = tY;
		}
		
		for(int i = 1; i <= 100000; i++) {
			if((K - X * i) % Y == 0) {	//day[1](i)를 정해가며 정수로 만족하는 day[2]((K-Y*i)/Y)를 구한다.
				bw.write(i + "\n" + ((K - X * i) / Y) + "\n");
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
