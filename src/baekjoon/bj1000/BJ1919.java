package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//애너그램 만들기
public class BJ1919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String first = br.readLine();
		String second = br.readLine();
		int[] alpha = new int[26];	//해당 알파벳의 제거 개수
		
		for(int i = 0; i < first.length(); i++) {	//첫째 문자열의 각 문자 인덱스 대해 +1
			alpha[first.charAt(i) - 'a']++;
		}
		for(int i = 0; i < second.length(); i++) {	//두번째 문자열의 각 문자 인덱스 대해 -1
			alpha[second.charAt(i) - 'a']--;
		}
		
		int count = 0;
		for(int i = 0; i < alpha.length; i++) {
			count += Math.abs(alpha[i]);	//양수인 경우 첫째 문자열의 문자 제거 개수, 음수인 경우 둘째 문자열의 문자 제거 개수
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
