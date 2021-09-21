package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//수학숙제
public class BJ2870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		solve(list, str);
		
		Collections.sort(list, (a, b) -> {	//숫자 문자열 정렬
			int diff = a.length() - b.length();
			if(diff == 0) {
				int i = 0;
				while(i < a.length()) {
					if(a.charAt(i) < b.charAt(i)) {
						return -1;
					}else if(a.charAt(i) > b.charAt(i)) {
						return 1;
					}
					i++;
				}
			}
			return diff;
		});
		for(String i : list) {
			bw.write(i + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(List<String> list, String[] str) {
		for(int i = 0; i < str.length; i++) {
			for(int j = 0; j < str[i].length(); j++) {
				if('0' <= str[i].charAt(j) && str[i].charAt(j) <= '9') {
					int t = j;
					while(j < str[i].length() && '0' <= str[i].charAt(j) && str[i].charAt(j) <= '9') {
						j++;
					}		
					String ss = str[i].substring(t, j);
					int index = 0;
					while(index < ss.length() - 1) {	//앞의 0제거
						if(ss.charAt(index) != '0') {
							break;
						}
						index++;
					}
					list.add(ss.substring(index));
					j--;
				}
			}
		}
	}
}
