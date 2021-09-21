package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//ZOAC 2
public class BJ18238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] alpha = new char[26];
		
		for(int i = 0; i < alpha.length; i++) {
			alpha[i] = (char)('A' + i);
		}
		
		String str = br.readLine();
		int curr = 0;
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int left = curr, leftCount = 0;
			int right = curr, rightCount = 0;
			while(alpha[left] != ch) {	//왼쪽으로 가는 횟수
				left = left - 1 < 0 ? 25 : left - 1;
				leftCount++;
			}
			while(alpha[right] != ch) {	//오른쪽으로 가는 횟수
				right = right + 1 > 25 ? 0 : right + 1;
				rightCount++;
			}
			
			if(leftCount < rightCount) {	//비교 후 최소 값을 더한다.
				curr = left;
				count += leftCount;
			}else {
				curr = right;
				count += rightCount;
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
