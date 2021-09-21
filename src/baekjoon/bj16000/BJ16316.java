package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Baby Bites
public class BJ16316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		boolean isCorrect = true;
		for(int i = 1; i <= N; i++) {
			String curr = st.nextToken();
			if(!curr.equals("mumble") && Integer.parseInt(curr) != i) {	//mumble이 아니고 숫자 숫서가 안맞으면 잘못 세는 중
				isCorrect = false;
				break;
			}
		}
		
		bw.write((isCorrect ? "makes sense" : "something is fishy"));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
