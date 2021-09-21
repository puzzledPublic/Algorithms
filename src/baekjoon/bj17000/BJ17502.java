package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//클레어와 팰린드롬
public class BJ17502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		int s = 0, e = str.length - 1;
		while(s <= e) {
			char fch = str[s];
			char bch = str[e];
			if(fch == '?' && bch == '?') {	//둘다 ?인 경우 'a'로
				str[s] = str[e] = 'a';
			}else if(fch == '?') {	//한쪽만 ?인 경우 반대쪽 문자로 만든다.
				str[s] = str[e];
			}else if(bch == '?') {
				str[e] = str[s];
			}
			s++;
			e--;
		}
		for(char ch : str) {
			bw.write(ch);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
