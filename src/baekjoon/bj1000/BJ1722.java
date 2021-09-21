package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//순열의 순서
public class BJ1722 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		if(Integer.parseInt(st.nextToken()) == 1) {
			long k = Long.parseLong(st.nextToken()); 
			solve(k, N, bw);
		}else {
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			solve2(arr, N, bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//1번 소문제
	static void solve(long k, int N, Writer w) throws IOException {
		boolean[] chk = new boolean[N + 1];
		int f = N - 1;
		//k가 있을때 (N - 1)!으로 나누면 전체 구간에서 k/(N - 1)!의 구간에 존재한다. (구간은 0 부터 시작)
		while(f != 0) {
			long fac = facto(f--);	//f!을 구하고 다음 자리 숫자들 위해 f를 내려놓는다.
			int t = (int)((k / fac) + 1);	//현재 구간을 구한다.
			if(k % fac == 0) {	//나눠 떨어지는 구간은 +1되어 있으므로 조심
				t--;
			}
			int count = 0;
			for(int i = 1; i < N + 1; i++) {
				if(!chk[i]) {	//아직 쓰인 숫자가 아니면
					count++;	//구간 t만큼 올리기위해 count++
				}
				if(!chk[i] && count == t) {	//구간 t만큼 올렸으면 그 숫자가 쓰일 차례
					chk[i] = true;
					w.write(i + " ");
					break;
				}
			}
			k %= fac;	//다음 k를 계산
		}
		for(int i = N; i > 0; i--) {
			if(!chk[i]) {
				w.write(i + " ");
			}
		}
	}
	//2번 소문제
	static void solve2(int[] arr, int N, Writer w) throws IOException {
		boolean[] chk = new boolean[N + 1];
		int f = N - 1;
		long result = 0;
		for(int i = 0; i < N; i++) {
			chk[arr[i]] = true;	//현재 자리의 숫자를 체크하고
			int count = 0;
			for(int j = arr[i] - 1; j > 0; j--) {	//그 이전 숫자들의 개수를 센다.
				if(!chk[j]) {
					count++;
				}
			}
			result += (count * facto(f--));	//시작점에서 f! * count만큼 떨어져있다.
		}
		w.write((result + 1) + "\n");
	}
	static long facto(int f) {	//팩토리얼 구하기
		long result = 1;
		for(int i = f; i >= 2; i--) {
			result *= i;
		}
		return result;
	}
}
