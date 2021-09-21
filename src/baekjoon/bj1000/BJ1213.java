package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//팰린드롬 만들기
public class BJ1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alpha = new int[26];
		for(char i : br.readLine().toCharArray()) {	//알파벳 갯수 세기
			alpha[i - 65]++;
		}
		int odd = 0;
		for(int i = 0; i < alpha.length; i++) {
			if(odd > 1) {	//홀수 갯수인 알파벳이 1개 초과면 팰린드롬 불가능
				break;
			}
			if(alpha[i] % 2 == 1) {
				odd++;
			}
		}
		StringBuilder sb = new StringBuilder();
		if(odd > 1) {	//팰린드롬 못만들면 해당 문구 출력
			sb.append("I'm Sorry Hansoo\n");
		}else {
			char middle = '\0';
			for(int i = 0; i < alpha.length; i++) {
				if(alpha[i] % 2 == 1) {	//홀수 갯수인 알파벳
					middle = (char)(i + 65);
				}
				for(int j = 0; j < alpha[i] / 2; j++) {	//사전순이므로 A -> Z까지 순회하며 (알파벳 개수 / 2개)만큼씩 알파벳을 채운다.
					sb.append((char)(i + 65));
				}
			}
			String reverse = sb.reverse().toString();	//팰린드롬에서 뒤를 채울 문자열
			sb.reverse();	//원본을 다시 되돌린다.
			if(middle != '\0') {	//만일 홀수 갯수인 알파벳이 없었다면 middle은 없다.
				sb.append(middle);
			}
			sb.append(reverse);	//앞 + 뒤 합체
		}
		System.out.println(sb);
	}
}
