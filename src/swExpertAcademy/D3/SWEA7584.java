package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//자가 복제 문자열
//규칙을 찾아보면..
//0이 오는 경우는 4n-3으로 시작하는 경우. (각 수에 대해 2배씩 증가하여도 0이다.)
//ex) 1, 2, 4, 8... , 5, 10, 20, 40...
//1이 오는 경우는 4n-1으로 시작하는 경우. (각 수에 대해 2배씩 증가하여도 1이다.) 
//ex) 3, 6, 12, 24..., 7, 14, 28, 56...
public class SWEA7584 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			long k = Long.parseLong(br.readLine());
			while(k % 2 == 0) {	//k가 2의 배수가 아닐때까지 2로 나눈다.
				k /= 2;
			}
			if((k + 3) % 4 == 0) {	//나눈 수(k)가 0이 오는 수열(4n-3)에 위치하면 원래 k의 위치에 오는 것은 0이다.
				bw.write("#" + i + " 0\n");
			}else {	//1이 오는 수열(4n-1)에 위치하면 1이다.
				bw.write("#" + i + " 1\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
