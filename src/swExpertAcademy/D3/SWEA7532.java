package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//세영이의 SEM력 연도
public class SWEA7532 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int LCM = getLCM(365, getLCM(24, 29));
			int s = 0, e = 0, m = 0, time = 0;
			
			for(int j = S; j <= LCM; j += 365) {	//년도를 S에 맞추고 시뮬레이션한다. LCM까지 돌면 처음으로 돌아간다
				s = (j - 1) % 365 + 1;
				e = (j - 1) % 24 + 1;
				m = (j - 1) % 29 + 1;
				if(s == S && e == E && m == M) {
					bw.write("#" + i + " " + j + "\n");
					break;
				}
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static int getGCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		return getGCD(b, a % b);
	}
	static int getLCM(int a, int b) {
		return (a * b) / getGCD(a, b);
	}
}
