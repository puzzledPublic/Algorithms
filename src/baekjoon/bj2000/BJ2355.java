package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//시그마
public class BJ2355 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
		if(a > b) {	//a <= b가 되도록
			long temp = a;
			a = b;
			b = temp;
		}
		long result = 0;
		if(a <= 0 && b >= 0) {	//a가 음수 b는 양수
			a = -a;
			a = (a * (a + 1) / 2);
			b = (b * (b + 1) / 2);
			result = b - a;
		}else if(b <= 0) {	//a, b 음수
			a = -a;
			b = -b;
			a = (a * (a + 1) / 2);
			b = (b * (b - 1) / 2);
			result = -(a - b);
		}else if(a >= 0) {	//a, b 양수
			a = (a * (a - 1) / 2);
			b = (b * (b + 1) / 2);
			result = b - a;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
