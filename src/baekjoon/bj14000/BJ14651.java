package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//걷다보니 신천역 삼(Large)
//3의 배수는 모든 자릿수를 더하면 3의 배수가 된다.
///0,1,2가 자리수로 나오기 때문에 앞에 무슨 숫자가 나와도 뒤에 0,1,2 중에 선택해서 하나만 붙이면 3의 배수가 될 수 있기 때문에, n-1자릿수로 만들수 있는 모든 경우의 수 가 정답이 된다.
//1번째 자리는 1,2만 나올수 있으므로 공식화하면 3^(n-2) * 2 이다.
public class BJ14651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long result = 2;
		for(int i = 0; i < N - 2; i++) {
			result = (result * 3) % 1000000009;
		}
		
		bw.write((N == 1 ? 0 : result) + "\n");
		
		bw.flush();
		bw.close();
	}
}
