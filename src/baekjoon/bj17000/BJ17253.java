package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//삼삼한 수 2
public class BJ17253 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		
		if(N != 0) {	//N = 0인 경우 삼삼한 수가 아니다.
			long[] pow = new long[40];	//pow[i] = 3^i, 3^39 < 2^63
			pow[0] = 1;
			for(int i = 1; i < pow.length; i++) {
				pow[i] = pow[i - 1] * 3;
			}
		
			for(int i = pow.length - 1; i >= 0; i--) {	//3^i이 N보다 같거나 작을 경우 N에서 빼준다.
				if(N >= pow[i]) {
					N -= pow[i];
				}
			}
			
			if(N == 0) {	//N을 감소 시켰을때 0이되면 삼삼한 수.
				bw.write("YES\n");				
			}else {
				bw.write("NO\n");
			}
		}else {
			bw.write("NO\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
