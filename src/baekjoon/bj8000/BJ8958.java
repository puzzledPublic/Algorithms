package baekjoon.bj8000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ox퀴즈
public class BJ8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int s = 0, k = 1;
			String ss = br.readLine();
			for(int j = 0; j < ss.length(); j++) {
				if(ss.charAt(j) == 'O') {
					s += k;
					k++;
				}else {
					k = 1;
				}
			}
			System.out.println(s);
		}
	}
}
