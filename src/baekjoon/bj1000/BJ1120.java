package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//문자열
public class BJ1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken(), B = st.nextToken();
		//A문자열의 앞뒤에 아무 문자를 삽입할 수 있으니 결국 A와 B를 겹쳐 비교했을때 가장 작은 차이가 날때가 A를 B로 만들때 최소가 된다.
		int diff = B.length() - A.length();
		
		int min = 987654321;
		
		for(int i = 0; i <= diff; i++) {
			int diffSize = 0;
			for(int j = 0; j < A.length(); j++) {
				if(A.charAt(j) != B.charAt(i + j)) {
					diffSize++;
				}
			}
			if(diffSize < min) {
				min = diffSize;
			}
		}
		
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
