package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//복불복으로 지구 멸망
public class BJ17358 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Integer.parseInt(br.readLine());
		long mod = 1000000007;
		
		long count = 1;
		//컵 하나를 잡고 나머지와 교환하는 경우의 수 * 
		//앞에서 교환한 컵 2개 제외하고 또 다시 컵 하나를 잡고 나머지와 교환하는 경우의 수 * 
		//앞에서 교환한 컵 4개를 제외하고 또 다시 컵 하나를 잡고 나머지와 교환하는 경우의 수 ...
		//이를 수식으로 나타내면 (N - 1) * (N - 3) * (N - 5) ... 1이 된다.
		for(int i = 1; N - i != 1; i += 2) {
			count = (count * (N - i)) % mod;
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
