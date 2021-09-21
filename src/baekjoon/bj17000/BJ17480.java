package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//개구쟁이 준석이
public class BJ17480 {
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[][] alpha = new int[N][2];
		int len = 0;	//목격한 총 알파벳 갯수
		for(int i = 0; i < N; i++) {
			alpha[i][0] = st.nextToken().charAt(0);
			alpha[i][1] = Integer.parseInt(st.nextToken());
			len += alpha[i][1];
		}
		
		String word = br.readLine();
		
		for(int i = 0; i < word.length() - len + 1; i++) {
			int[] tmp = new int[N];
			for(int j = 0; j < N; j++) {
				tmp[j] = alpha[j][1];
			}
			
			for(int j = i; j < i + len; j++) {	//부분문자열이 목격한 알파벳 갯수와 같은지 검사.
				for(int k = 0; k < N; k++) {
					if(word.charAt(j) == alpha[k][0]) {
						tmp[k]--;
						break;
					}
				}
			}
			boolean isCorrect = true;
			for(int j = 0; j < N; j++) {
				if(tmp[j] != 0) {
					isCorrect = false;
					break;
				}
			}
			if(isCorrect) {	//해당하는 부분문자열인 경우
				solve(0, len, word.substring(i, i + len));
			}
		}
		bw.write(set.size() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int left, int right, String str) {	//[left ~ right]를 반으로 나눠 한쪽을 뒤집음을 반복했을때 얻는 문자열
		int len = right - left;
		if(len <= 2) {	//길이가 2이하라면 바꿔도 그대로이다. 바로 종료
			set.add(str);
			return;
		}
		
		if(len % 2 == 0) {	//길이가 짝수인 경우
			int mid = (left + right) / 2;
			String leftStr = str.substring(0, left);
			String reversedStr = new StringBuilder(str.substring(left, mid)).reverse().toString();
			String rightStr = str.substring(mid);
			
			solve(mid, right, leftStr + reversedStr + rightStr);
			
			leftStr = str.substring(0, mid);
			reversedStr = new StringBuilder(str.substring(mid, right)).reverse().toString();
			rightStr = str.substring(right);
			
			solve(left, mid, leftStr + reversedStr + rightStr);
		}else {	//길이가 홀수인 경우
			int mid = (left + right) / 2;
			
			String leftStr = str.substring(0, left);
			String reversedStr = new StringBuilder(str.substring(left, mid)).reverse().toString();
			String rightStr = str.substring(mid);
			
			solve(mid, right, leftStr + reversedStr + rightStr);
			
			leftStr = str.substring(0, mid);
			reversedStr = new StringBuilder(str.substring(mid, right)).reverse().toString();
			rightStr = str.substring(right);
			
			solve(left, mid, leftStr + reversedStr + rightStr);
			
			mid = (left + right) / 2 + 1;
			
			leftStr = str.substring(0, left);
			reversedStr = new StringBuilder(str.substring(left, mid)).reverse().toString();
			rightStr = str.substring(mid);
			
			solve(mid, right, leftStr + reversedStr + rightStr);
			
			leftStr = str.substring(0, mid);
			reversedStr = new StringBuilder(str.substring(mid, right)).reverse().toString();
			rightStr = str.substring(right);
			
			solve(left, mid, leftStr + reversedStr + rightStr);
		}
	}
}
