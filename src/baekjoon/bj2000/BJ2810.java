package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//컵홀더
public class BJ2810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		boolean C = false;
		int count = 1;	//컵 개수
		int p = 0;	//사람 수
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == 'S') {
				count++;	//좌석 오른쪽 컵 홀더
				p++;	//사람 수 증가
			}else {
				if(C) {
					count++;
					p += 2;	//2인석이므로 2증가
					C = false;
				}else {
					C = true;
				}
			}
		}
		
		//사람 수, 컵 홀더 수 중 작은 것을 출력 (컵 홀더를 이용할 사람 수를 출력해야 하므로)
		bw.write((p < count ? p : count) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
