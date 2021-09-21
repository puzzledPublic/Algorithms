package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//이진수씨의 하루 일과
public class BJ17830 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
			//이진 수를 곱했을때 자리수는 최초 1의 위치와 그 뒤의 1의 존재 여부로 알 수 있다.
			int firstMaxOneIndex = -1;	//왼쪽에서부터 1이 최초로 등장하는 위치('?' 포함)
			int firstMinOneIndex = -1;	//왼쪽에서부터 1이 최초로 등장하는 위치
			boolean hasSecondMaxOne = false;	//최초 1외의 1이 존재하는지 여부('?' 포함)
			boolean hasSecondMinOne = false;	//최초 1외의 1이 존재하는지 여부
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(firstMaxOneIndex == -1) {
					if(ch == '?' || ch == '1') {
						firstMaxOneIndex = i;
					}
				}
				else if(firstMaxOneIndex != -1) {
					if(ch == '?' || ch == '1') {
						hasSecondMaxOne = true;
					}
				}
				
				if(firstMinOneIndex == -1) {
					if(ch == '1') {
						firstMinOneIndex = i;
					}
				}
				else if(firstMinOneIndex != -1) {
					if(ch == '1') {
						hasSecondMinOne = true;
					}
				}
			}
			
			int max = 1, min = 1;	//최소 자리수는 1부터 시작한다. 1 * 0 = 0 -> 1자리 수
			if(firstMaxOneIndex != -1) {
				max = N + N - firstMaxOneIndex - 1;		//곱했을때 최대 자리 수
				if(hasSecondMaxOne) {	//1이 더 있다면 자리수 + 1
					max++;
				}
			}
			if(firstMinOneIndex != -1) {
				min = N + N - firstMinOneIndex - 1;	//곱했을때 최소 자리 수
				if(hasSecondMinOne) {	//1이 더 있다면 자리수 + 1
					min++;
				}
			}
			bw.write(max + " " + min + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
