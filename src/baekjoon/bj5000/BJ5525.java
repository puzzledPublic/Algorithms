package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//IOIOI
public class BJ5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int result = 0;
		
		Pattern pattern = Pattern.compile("I(OI)+");	//IOIOIOI..가 연속되는 패턴 매칭
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()) {	//문자열내 모든 매칭되는 그룹에 대해
			String group = matcher.group();
			int count = (group.length() - 1) / 2;	//'O'의 개수
			if(count >= N) {	//N개 보다 크거나 같으면
				result += (count - (N - 1));	//포함된 개수를 알 수 있다.
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
