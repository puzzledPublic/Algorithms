package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수도요금
public class BJ10707 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int X = A * P;
		int Y = C < P ? B + (P - C) * D : B;
		System.out.println(X < Y ? X : Y);
	}
}
