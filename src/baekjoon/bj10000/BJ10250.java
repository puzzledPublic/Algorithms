package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//ACM 호텔
public class BJ10250 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			solve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), bw);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int h, int w, int n, Writer ww) throws IOException {
		int a = (n % h);
        int b = (n / h) + 1;

        if(a == 0) {
            a = h;
            b--;
        }
        String result = "" + a;

        if(b < 10) {
        	result += "0" + b;
        }
        else {
        	result += "" + b;
        }
        ww.write(result + "\n");
	}
}
