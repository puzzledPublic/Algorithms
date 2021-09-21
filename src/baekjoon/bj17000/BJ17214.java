package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//다항 함수의 적분
public class BJ17214 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String polynomial = br.readLine();
		
		if(polynomial.contains("x")) {
			String[] poly = polynomial.split("x");
			int coeffi1 = Integer.parseInt(poly[0]) / 2;
			if(coeffi1 != 0) {
				if(coeffi1 == 1 || coeffi1 == -1) {
					if(coeffi1 == -1) {
						bw.write("-");
					}
				}else {
					bw.write(coeffi1 + "");
				}
				bw.write("xx");
			}
			int coeffi2 = 0;
			if(poly.length == 2) {
				coeffi2 = Integer.parseInt(poly[1]);
				if(coeffi2 != 0) {
					if(coeffi2 == 1 && coeffi1 != 0) {
						bw.write("+");
					}
					else if(coeffi2 == -1) {
						bw.write("-");
					}else if(coeffi2 > 0){
						bw.write((coeffi1 == 0 ? "" : "+") + coeffi2 + "");
					}else {
						bw.write(coeffi2 + "");
					}
					bw.write("x");
				}
			}
			if(coeffi1 != 0 || coeffi2 != 0) {
				bw.write("+W\n");
			}else {
				bw.write("W\n");
			}
			
		}else {
			int coeffi = Integer.parseInt(polynomial);
			if(coeffi == 1 || coeffi == -1) {
				if(coeffi == -1) {
					bw.write("-x+W\n");
				}else {
					bw.write("x+W\n");
				}
			}else if(coeffi == 0){
				bw.write("W\n");
			}else {
				bw.write(coeffi + "x+W\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
