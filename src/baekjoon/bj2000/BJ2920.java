package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//음계
public class BJ2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()); //1,2 번째 음
		int c = a - b;	//음 차이
		while(st.hasMoreTokens()) {
			a = Integer.parseInt(st.nextToken());	//다음 음
			if(a + c != b) {	//음 차이만큼 안나면 mixed
				c = 2;
				break;
			}
			b = a;
		}
		if(c == 1) {
			System.out.println("descending");
		}else if(c == -1) {
			System.out.println("ascending");
		}else {
			System.out.println("mixed");
		}
	}
}
