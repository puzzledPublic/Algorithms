package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//단어 뒤집기2
public class BJ17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		char[] arr = new char[str.length() + 1];	//단어를 뒤집기 위해 사용할 스택 배열
		int i = 0, top = 0;
		while(i < str.length()){
			char ch = str.charAt(i);
			if(ch == '<') {	// '<'라면 지금까지 스택에 쌓인걸 출력.
				while(top > 0) {
					bw.write(arr[top--]);
				}
				bw.write(ch);	//'<' ~ '>'까지 모든 문자 그대로 출력
				while(ch != '>') {
					i++;
					ch = str.charAt(i);
					bw.write(ch);
				}
			}else if(ch == ' ') {	//' '라면 지금까지 스택에 쌓인걸 출력.
				while(top > 0) {
					bw.write(arr[top--]);
				}
				bw.write(ch);
			}else {	//그 외의 경우 스택에 저장.
				top++;
				arr[top] = ch;
			}
			i++;
		}
		while(top > 0) {	//아직 스택에 남은게 있다면 출력
			bw.write(arr[top--]);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
