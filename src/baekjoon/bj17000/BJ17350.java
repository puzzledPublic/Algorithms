package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2루수 이름이 뭐야
//문제롤 멋대로 해석하지 말자.
//'뭐(anj)'를 포함하는 이름을 가진 사람이 있는지 알아내는게 아니고
//이름 자체가 '뭐(anj)'인 사람이 있는지 알아내는거..
public class BJ17350 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		boolean is = false;
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			if(name.equals("anj")) {
				is = true;
				break;
			}
		}
		
		bw.write(is ? "뭐야;" : "뭐야?");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
