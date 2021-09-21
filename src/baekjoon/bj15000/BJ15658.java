package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//연산자 끼워넣기
public class BJ15658 {
	static int N;
	static int[] nums;
	static int[] op;
	static int maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
	static int[] opOrder; // + = 0, - = 1, * = 2, / = 3

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		opOrder = new int[N - 1];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			int t = Integer.parseInt(st.nextToken());
			if (t > 10) {	//N이 최대 11이므로 한 연산자가 11개 이상일 필요는 없다.
				op[i] = 10;
			} else {
				op[i] = t;
			}
		}
		//각 연산자 개수가 최대 10개씩이고 최대 10군데 놓을 수 있으므로 4^10 = 2^20 = 100만정도 이므로 bruteForce 가능
		solve(0);
		
		bw.write(maxVal + "\n" + minVal + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static void solve(int n) {
		if (n == N - 1) {
			int value = nums[0];
			for (int i = 0; i < N - 1; i++) {	//연산자 순서에 따라 계산
				switch (opOrder[i]) {
				case 0:
					value += nums[i + 1];
					break;
				case 1:
					value -= nums[i + 1];
					break;
				case 2:
					value *= nums[i + 1];
					break;
				default:
					value /= nums[i + 1];
					break;
				}
			}
			if(minVal > value) {	//최소값 갱신
				minVal = value;
			}
			if(maxVal < value) {	//최대값 갱신
				maxVal = value;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {	//가능한 연산자 순서를 만든다.
			if (op[i] > 0) {
				op[i]--;
				opOrder[n] = i;
				solve(n + 1);
				op[i]++;
			}
		}
	}
}
