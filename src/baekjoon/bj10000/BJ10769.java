package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//행복한지 슬픈지
public class BJ10769 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		Pattern p1 = Pattern.compile("(:-\\))");
		Pattern p2 = Pattern.compile("(:-\\()");
		
		Matcher m1 = p1.matcher(str);
		Matcher m2 = p2.matcher(str);
		int happy = 0, sad = 0;
		while(m1.find()) {
			happy++;
		}
		while(m2.find()) {
			sad++;
		}
		if(happy == 0 && sad == 0) {
			bw.write("none\n");
		}
		else if(happy == sad) {
			bw.write("unsure\n");
		}else if(happy > sad) {
			bw.write("happy\n");
		}else {
			bw.write("sad\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
