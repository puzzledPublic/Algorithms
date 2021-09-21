package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2007년
public class BJ1924 {
	static int[] idays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	//달 별 일수
	static String[] sDays ={"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), ss = 0;
		for(int i = 0; i < a - 1; i++) {
			ss += idays[i];
		}
		ss += b;
		System.out.println(sDays[ss % 7]);
	}
}
