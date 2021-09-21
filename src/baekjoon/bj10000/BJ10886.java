package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0 = not cute / 1 = cute
public class BJ10886 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int y = 0, n = 0;
		for(int i = 0; i < N; i++) {
			if(Integer.parseInt(br.readLine()) == 0) {
				n++;
			}else{
				y++;
			}
		}
		if(y > n) {
			System.out.println("Junhee is cute!");
		}else {
			System.out.println("Junhee is not cute!");
		}
	}
}

