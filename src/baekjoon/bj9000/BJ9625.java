package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BABBA
public class BJ9625 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine()); 
		
		int a = 1, b = 0;	//처음 A, B의 갯수
		for(int i = 0; i < K; i++) {	//K번 버튼을 누른다.
			int t = b;	//현재 B의 갯수 임시 저장.
			b += a;		//A는 모두 B로 변하고 B는 BA로 변하므로 B의 갯수 + A의 갯수 = 다음 B의 갯수
			a = t;		//B는 BA로 변하므로 현재 B의 갯수가 다음 A의 갯수가 된다.
		}
		bw.write(a + " " + b + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
