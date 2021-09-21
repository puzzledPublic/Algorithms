package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다음 팰린드롬 수
public class BJ1334 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		if(N.length() == 1 && N.charAt(0) != '9') {	//한자리 수일때
			System.out.println((char)(N.charAt(0) + 1));
		}else {
			solve(isPalindrom(N));
		}
		br.close();
	}
	static String isPalindrom(String n) {
		int count = 0;
		for(int i = 0; i < n.length() / 2; i++) {	//팰린드롬이 아니면 그대로 검사
			if(n.charAt(i) != n.charAt(n.length() - 1 - i)) {
				return n;
			}
		}
		for(int i = 0; i < n.length(); i++) {	//9로만 이루어져있는지 검사
			if(n.charAt(i) == '9') {
				count++;
			}
		}
		//원래 수에 1을 더한다. 
		StringBuilder sb = new StringBuilder();
		if(count== n.length()) {
			sb.append("1");
			for(int i = 0; i < count; i++) {
				sb.append("0");
			}
			return sb.toString();
		}else {	
			sb.append(n);
			int index = sb.length() - 1;
			if(sb.charAt(index) == '9') {
				while(sb.charAt(index) == '9') {
					sb.setCharAt(index--, '0');
				}
			}
			sb.setCharAt(index, (char)(sb.charAt(index) + 1));
			return sb.toString();
		}
	}
	//팰린드롬이므로 중간에서 끊어 검사
	static void solve(String n) {
		int mid = n.length() / 2;
		if(n.length() % 2 == 1) {	//수가 홀수자리인 경우
			StringBuilder first = new StringBuilder(n.substring(0, mid + 1));
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < mid; i++) {
				if(n.charAt(mid + i + 1) > first.charAt(mid - i - 1)) {
					int k = mid;
					if(first.charAt(k) == '9') {
						while(first.charAt(k) =='9') {
							first.setCharAt(k--, '0');
						}
					}
					first.setCharAt(k, (char)(first.charAt(k) + 1));
					result.append(first);
					result.append(first.reverse().substring(1));
					System.out.println(result);
					return;
				}else if(n.charAt(mid + i + 1) < first.charAt(mid - i - 1)) {
					break;
				}
			}
			result.append(first);
			result.append(first.reverse().substring(1));
			System.out.println(result);
		}else {	//수가 짝수자리인 경우
			StringBuilder result = new StringBuilder();
			StringBuilder first = new StringBuilder(n.substring(0, mid));
			for(int i = 0; i < mid; i++) {
				if(n.charAt(mid + i) > first.charAt(mid - i - 1)) {
					int k = mid - 1;
					if(first.charAt(k) == '9') {
						while(first.charAt(k) == '9') {
							first.setCharAt(k--, '0');
						}
					}
					first.setCharAt(k, (char)(first.charAt(k) + 1));
					result.append(first);
					result.append(first.reverse());
					System.out.println(result);
					return;
				}else if(n.charAt(mid + i) < first.charAt(mid - i - 1)) {
					break;
				}
			}
			result.append(first);
			result.append(first.reverse());
			System.out.println(result);
		}
	}
}
