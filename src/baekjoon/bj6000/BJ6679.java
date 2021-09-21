package baekjoon.bj6000;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

//싱기한 네자리 숫자
public class BJ6679 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 2992; i < 10000; i++) {
			if(digit(10, i) == digit(12, i) && digit(12, i) == digit(16, i)) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	static int digit(int n, int k) {
		int result = 0;
		while(k > 0) {
			result += (k % n);
			k /= n;
		}
		return result;
	}
}
