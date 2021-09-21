package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알람 시계
public class BJ2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		solve(H, M);
	}
	
	static void solve(int h, int m) {	//45분 뒤로 되돌리기
		if(m >= 45) {	//45분 이상이면 분만 조정
			m -= 45;
		}else {	//45분 미만이면
			if(h == 0) {	//0시라면 23시로
				h = 23;
			}else {	//그 외 시간은 전 시간으로
				h -= 1;
			}
			m = 60 - (45 - m);	//분 조정
		}
		System.out.println(h + " " + m);
	}
}
