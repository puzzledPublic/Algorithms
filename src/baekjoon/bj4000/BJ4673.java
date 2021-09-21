package baekjoon.bj4000;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

//셀프 넘버
public class BJ4673 {
	static boolean[] chk = new boolean[10001];
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 1; i <= 10000; i++) {
			if(!chk[i]) {
				bw.write(i + "\n");
				solve(i);
			}
		}
		bw.flush();
		bw.close();
	}
	
	static void solve(int n) {
		if(n > 10000) {
			return;
		}
		int sum = n;
		while(n > 0) {
			sum += (n % 10);
			n /= 10;
		}
		if(sum <= 10000 && !chk[sum]) {
			chk[sum] = true;
		}
		solve(sum);
	}
}
