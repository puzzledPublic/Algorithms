package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//안경이 없어!
public class SWEA7272 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] alpha = {0, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}; 
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken(), B = st.nextToken();
			boolean flag = false;
			
			if(A.length() != B.length()) {	//길이가 다르면 다른 문자열
				flag = true;
			}else {
				for(int j = 0; j < A.length(); j++) {
					if(alpha[A.charAt(j) - 'A'] != alpha[B.charAt(j) - 'A']) {	//각 A,B 알파벳에 대해 같은 그룹이 아니면 다른 문자열
						flag = true;
						break;
					}
				}
			}
			
			if(flag) {
				bw.write("#" + i + " " + "DIFF\n");
			}else {
				bw.write("#" + i + " " + "SAME\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
