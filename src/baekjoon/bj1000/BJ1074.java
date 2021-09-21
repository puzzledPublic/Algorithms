package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Z
public class BJ1074 {
	static int r, c;
	static long count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		solve(n, 0, 0);
	}
	
	static void solve(int n, int x, int y) {
		if(n == 1) {	//2x2가 되면
			if(x == r && y + 1 == c) {
				count++;
			}else if(x + 1 == r && y == c) {
				count += 2;
			}else if(x + 1 == r && y + 1 == c) {
				count += 3;
			}
			System.out.println(count);
			return;
		}
		int k = (int)Math.pow(2, n - 1);
		
		if(x + k > r && y + k > c) {		//2사분면
			solve(n - 1, x, y);
		}else if(x + k > r && y + k <= c) {	//1사분면
			if(n > 1){ count += (k * k); }	//탐색하지 않는 나머지 분면에 대한 원소 갯수 계산
			solve(n - 1, x, y + k);
		}else if(x + k <= r && y + k > c) {	//3사분면
			if(n > 1) { count += (k * k * 2); }
			solve(n - 1, x + k, y);
		}else {								//4사분면
			if(n > 1) { count += (k * k * 3); }
			solve(n - 1, x + k, y + k);
		}
	}
}
