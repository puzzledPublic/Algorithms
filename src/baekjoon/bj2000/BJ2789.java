package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//유학금지
public class BJ2789 {
	static char[] districted = {'C','A','M','B','R','I','D','G','E'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < districted.length; i++) {
			set.add(districted[i]);
		}
		String word = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < word.length(); i++) {
			if(!set.contains(word.charAt(i))) {
				sb.append(word.charAt(i));
			}
		}
		System.out.println(sb);
		br.close();
	}
}
