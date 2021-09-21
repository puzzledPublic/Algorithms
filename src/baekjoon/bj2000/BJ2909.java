package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//캔디 구매
public class BJ2909 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int T = (int)Math.pow(10.0, (double)K);	//10^k
		int result;
		if(K != 0) {	//10^0 = 1이고 1원으로 모든 돈을 그대로 낼 수 있다.
			result = (C / T) * T;
			if(C % T >= T / 2) {	//반올림
				result += T;
			}
		}else {
			result = C;
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
