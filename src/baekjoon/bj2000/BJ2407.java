package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//조합
public class BJ2407 {
	static long DIV = 1;
	static class BigNum {	//큰 수를 위한 클래스
		long front;	//앞 18자리
		long back;	//뒤 17자리
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 18; i++) {	//뒤 17자리가 18자리로 넘어가는지 체크할 변수 생성 (10^18)
			DIV *= 10;
		}
		solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), bw);
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, int k, Writer w) throws IOException {
		BigNum[][] bignums = new BigNum[n + 1][n + 1];
		for(int i = 0; i < n + 1; i++) {	//DP를 위한 초기값들 설정
			bignums[i][0] = new BigNum();
			bignums[i][i] = new BigNum();
			bignums[i][1] = new BigNum();
			bignums[i][0].back = bignums[i][i].back = 1;
			bignums[i][1].back = i;
		}
		for(int i = 2; i < n + 1; i++) {
			for(int j = 1; j < k + 1; j++) {	//DP생성
				if(i >= j) {
					if(i - 1 < j) {	//n < k인 경우는 없으므로 f(n - 1, k)를 0인 객체로 설정 (ex, f(2,2) = f(1, 1) + f(1, 2) -> x)
						bignums[i][j] = add(bignums[i - 1][j - 1], bignums[0][1]);
					}else {
						bignums[i][j] = add(bignums[i - 1][j - 1], bignums[i - 1][j]);
					}
				}
			}
		}
		w.write((bignums[n][k].front == 0 ? "" : bignums[n][k].front + "") + bignums[n][k].back + "\n");
	}
	static BigNum add(BigNum a, BigNum b) {	//뒷자리수가 18자리가 넘어가면 17자리를 유지하고 앞자리에 + 1
		BigNum t = new BigNum();
		t.front = a.front + b.front;
		t.back = a.back + b.back;
		if(t.back >= DIV) {
			t.front++;
			t.back -= DIV;
		}
		return t;
	}
}
