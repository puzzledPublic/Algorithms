package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//크로아티아 알파벳
public class BJ2941 {
	static int[] alpha = new int[34];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve(br.readLine());
		int result = 0;
		for(int i = 0; i < alpha.length; i++) {
			result += alpha[i];
		}
		System.out.println(result);
	}
	//너무 지저분하다.
	//lj = 26, c= = 27, c- = 28, dz= =29, d- =30, nj = 31, s= =32, z= =33
	static void solve(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(i + 1 < s.length() && s.charAt(i) == 'l' && s.charAt(i + 1) =='j') {
				alpha[26]++;
				i++;
			}else if(i + 1 < s.length() && s.charAt(i) == 'c') {
				if(s.charAt(i + 1) == '=') {
					alpha[27]++;
					i++;
				}else if(s.charAt(i + 1) == '-') {
					alpha[28]++;
					i++;
				}else {
					alpha[s.charAt(i) - 97]++;
				}
			}else if(s.charAt(i) == 'd') {
				if(i + 2 < s.length() && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
					alpha[29]++;
					i += 2;
				}else if(i + 1 < s.length() && s.charAt(i + 1) == '-') {
					alpha[30]++;
					i++;
				}else {
					alpha[s.charAt(i) - 97]++;
				}
			}else if(i + 1 < s.length() && s.charAt(i) == 'n' && s.charAt(i + 1) == 'j') {
				alpha[31]++;
				i++;
			}else if(i + 1 < s.length() && s.charAt(i) == 's' && s.charAt(i + 1) == '=') {
				alpha[32]++;
				i++;
			}else if(i + 1 < s.length() && s.charAt(i) == 'z' && s.charAt(i + 1) == '='){
				alpha[33]++;
				i++;
			}else {
				alpha[s.charAt(i) - 97]++;
			}
		}
	}//좀 더 간결한 버전
	static void solve2(String s) {
		int cnt = 0;
		for(int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if(temp == '=') {
				if(s.charAt(i - 1) == 'z') {
					cnt--;
					if(s.charAt(i - 2) == 'd') {
						cnt--;
					}
				} else {
					cnt--;
				}
			} else if(temp == '-') {
				cnt--;
			} else if(temp == 'j') {
				if(s.charAt(i - 1) == 'l' || s.charAt(i - 1) == 'n') {
					cnt--;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
