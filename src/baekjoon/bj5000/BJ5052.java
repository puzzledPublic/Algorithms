package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//전화번호 목록
public class BJ5052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Set<String> set = new HashSet<>();
			String[] strs = new String[N];
			for(int j = 0; j < N; j++) {
				strs[j] = br.readLine();
			}
			Arrays.sort(strs, (a, b) -> a.length() - b.length());	//길이순으로 정렬
			int minLen = strs[0].length();	//가장 작은 번호 길이
			for(int j = 0; j < N; j++) {	//모든 번호에 대해
				boolean dont = false;
				for(int k = minLen; k < strs[j].length(); k++) {	//가장 작은 번호길이 ~ 현재 번호길이까지 현재번호에서 잘라내(접두어) 이미 존재하는지 검사
					if(set.contains(strs[j].substring(0, k))) {
						dont = true;
						break;
					}
				}
				if(!dont) {
					set.add(strs[j]);
				}else {
					break;
				}
			}
			if(set.size() == strs.length) {	//set 크기가 번호 갯수랑 동일하면 일관성 있다.
				bw.write("YES\n");
			}else {							//아니라면 일관성 없다.
				bw.write("NO\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
