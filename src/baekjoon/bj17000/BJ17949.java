package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Drop The Byte!
public class BJ17949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String code = br.readLine();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int index = 0;
		for(int i = 0; i < N; i++) {
			String format = st.nextToken();
			int offset = 0;
			switch (format) {
			case "char":
				offset = 2;
				break;
			case "int":
				offset = 8;
				break;
			case "long_long":
				offset = 16;
				break;
			default:
				break;
			}
			long decimal = hexToDecimal(code.substring(index, index + offset));
			index += offset;
			
			bw.write(decimal + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
	
	static long hexToDecimal(String hex) {	//16진수 문자열을 정수형으로 만드는 함수
		long decimal = 0;
		long bi = 1;
		for(int i = hex.length() - 1; i >= 0; i--) {
			char ch = hex.charAt(i);
			if('a' <= ch && ch <= 'f') {
				decimal += (ch - 'a' + 10) * bi;
			}else {
				decimal += (ch - '0') * bi;
			}
			bi *= 16;
		}
		return decimal;
	}
}
