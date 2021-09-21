package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이상한 곱셈
//ABC * DE를 문제대로 계산해보면 A*D + A*E + B*D + B*E + C*D + C*E => A*(D+E) + B*(D+E) + C*(D+E) => (A+B+C) * (D+E)가 된다.
//즉 첫번째 수의 각 자리수를 더한것과 두번째 수의 각 자리수를 더한것을 곱하면 답이된다.
public class BJ1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String strA = st.nextToken(), strB = st.nextToken();
		long sumA = 0, sumB = 0;
		
		for(int i = 0; i < strA.length(); i++) {	//A 문자열의 각 수를 더한다.
			sumA += (strA.charAt(i) - '0');
		}
		
		for(int i = 0; i < strB.length(); i++) {	//B 문자열의 각 수를 더한다.
			sumB += (strB.charAt(i) - '0');
		}
		
		bw.write((sumA * sumB) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
