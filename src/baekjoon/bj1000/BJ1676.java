package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//팩토리얼 0의 개수
public class BJ1676 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		bw.write(solve(n) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//n!을 소인수 분해 했을때 5의 갯수가 n!의 뒤에 붙는 0의 갯수이다.
	//두 소수를 곱해 10을 생성하는데 2, 5가 필요하다. 근데 2의 갯수 >= 5의 갯수이므로 5의 갯수에 따라 10의 갯수가 결정된다.
	//25, 125.. 5^n은 5가 여러개므로 더 추가 해야한다.
	//1~n까지 돌면서 5의 갯수를 세면 된다. 여기서는 n을 5, 25, 125..로 나눠 셌다.
	static int solve(int n) {	
		int f = 0;
		for(int i = 5; i <= n; i *= 5) {
			f += n / i;
		}
		return f;
	}
}
