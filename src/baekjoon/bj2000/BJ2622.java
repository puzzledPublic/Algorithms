package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//삼각형 만들기
//삼각형을 만드려면 a, b, c 각 변의 길이가 a <= b <= c일때 a + b > c이어야 한다. (a, b, c > 0)
//a <= b <= c이므로 a는 1 ~ N / 3까지 탐색하고 b는 a ~ (N - a) / 2까지만 탐색하면 된다.
//a와 b가 정해지면 c도 정해지므로 a + b > c가 만족하는지 검사한다.
public class BJ2622 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int a = 1; a < N / 3 + 1; a++) {
			for(int b = a; b <= (N - a) / 2 ; b++) {
				if(a + b > N - (a + b)) {
					count++;
				}
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
