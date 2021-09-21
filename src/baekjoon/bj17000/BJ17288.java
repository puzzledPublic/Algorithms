package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//3개만!
public class BJ17288 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] input = br.readLine().toCharArray();
		
		int check1 = 1, check2 = 1;
		int count = 0;
		for(int i = 1; i < input.length; i++) {
			if(input[i] - input[i - 1] == 1) {
				check1++;
			}else {
				if(check1 == 3) {
					count++;
				}
				check1 = 1;
			}
			if(input[i - 1] - input[i] == 1) {
				check2++;
			}else {
				if(check2 == 3) {
					count++;
				}
				check2 = 1;
			}
		}
		if(check1 == 3) {
			count++;
		}
		if(check2 == 3) {
			count++;
		}
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
