package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//승현이의 수학공부
//N = 9 이고 X = 234라고하자.
//X를 10진수로 나타내면 2*9^2 + 2*9^1 + 2*9^0 = 193이다.
//이를 N-1로 modular연산을 하면 193 % (N-1) = ((2*9^2) % (N-1) + (2*9^1) % (N-1) + (2*9^0) % (N-1)) % (N-1)과 같다.
//N^i를 N-1로 나눈 나머지를 식으로 나타내면 N^i = N^(i-1)*(N-1) + 1이며 (나머지정리), 양변에 K를 곱하면 K*(N^i) = K*N^(i-1)*(N-1) + K가 된다.
//이를 X = 234에 비교해보면 각 자리 숫자(K)는 N-1로 나눴을때 나머지가 되고 이를 다 더해서 다시 N-1으로 나누면 우리가 원하는 나머지가 된다. (ex 234 -> (2+3+4) % 8 = 1)
public class SWEA7193 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			long sum = 0;
			String num = st.nextToken();
			for(int j = 0; j < num.length(); j++) {
				sum += num.charAt(j) - '0';
			}
			bw.write("#" + i + " " + (sum % (N - 1)) + "\n"); 
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
