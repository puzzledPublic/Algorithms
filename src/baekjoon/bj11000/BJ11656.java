package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

//접미사 배열
public class BJ11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		List<String> list = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			list.add(s.substring(i));
		}
		
		list.sort((a, b) -> a.compareTo(b));
		for(String str : list) {
			bw.write(str + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
