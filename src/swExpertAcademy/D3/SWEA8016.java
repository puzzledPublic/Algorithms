package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//홀수 피라미드
//홀수 피라미드를 일렬로 나열했을때 n층의 왼쪽 숫자와 오른쪽 숫자의 위치를 알아보자
//각 n층의 숫자 개수는 2n - 1개 이다.
//n층을 시작하는 숫자 위치는 피라미드의 모든 숫자 개수(2n-1의 1~n까지의 합) - n층의 숫자개수(2n - 1) + 1이 된다.
//즉 (n * (2 + (n - 1) * 2) / 2) - (2n - 1) + 1= n^2 - 2n + 1 + 1= (n - 1)^2 + 1이 된다.
//그러므로 n층의 가장 왼쪽 숫자 위치는 (n - 1)^2 + 1이 되고 가장 오른쪽 숫자 위치는 n^2이 된다.
//피라미드를 이루는 숫자도 2k - 1를 일반항으로 등차수열을 이루므로 여기에 대입하면
//왼쪽 숫자는 2 * ((n - 1)^2 + 1) - 1이고 오른쪽 숫자는 2 * n^2 - 1
public class SWEA8016 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			long N = Long.parseLong(br.readLine());
			long left = 2 * (N - 1) * (N - 1) + 1;
			long right = 2 * N * N - 1;
			
			bw.write("#" + t + " " + left + " " + right + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
