package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//Fly me to the Alpha Centauri
public class BJ1011 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int a, int b, Writer w) throws IOException {
		int len = b - a; //a부터 b까지의 거리
		long i = 1;	//b - a < 2^31이므로 i^2일때 int범위를 넘어설 수 있으므로 long으로 선언해야한다. (int면 아래 while에서 무한루프 가능)
		while(true) {
			if(len <= i * i) {	//규칙을 찾아보면 i^2일때 1~i까지 워프가능하며 이는 대칭된다.(1,2,3 ... i-1, i, i-1, ... 3,2,1)			 
				break;			
			}
			i++;
		}
		long r = 2 * i;			//(i-1)^2 < m <= i^2-i 일때 2*i-2번 워프하며 i^2-i < m <= i^2 일때 2*i-1번 워프한다.
		if(i * i - i >= len) {
			w.write(r - 2 + "\n");
		}else {
			w.write(r - 1 + "\n");
		}
	}
}
