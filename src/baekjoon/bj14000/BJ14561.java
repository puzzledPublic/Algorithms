package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//회문
public class BJ14561 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] numeral = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			long A = Long.parseLong(st.nextToken());
			long N = Long.parseLong(st.nextToken());
			StringBuilder sb = new StringBuilder();
			while(A >= N) {	//N진수로 만든다.
				sb.append(numeral[(int)(A % N)]);
				A /= N;
			}
			sb.append(numeral[(int)A]);
			if(sb.toString().equals(sb.reverse().toString())) {	//만든 N진수를 뒤집어도 똑같으면 회문.
				bw.write("1\n");
			}else {
				bw.write("0\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
