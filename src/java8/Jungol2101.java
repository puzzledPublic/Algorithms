package java8;

import java.util.Scanner;

//연속부분최대곱
//연속된 N개의 실수가 있을 때 한 개 이상의 연속된 수들의 곱이 최대가 되는 부분을 찾아 그 곱을 출력하라
//1 <= N <= 10,000과 N개의 실수들이 입력으로 주어진다. 
//소수점 이하 넷째 자리에서 반올림하여 소수점 이하 셋째 자리까지 출력
public class Jungol2101 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		double[] silsu = new double[n];
	
		for(int i = 0 ; i < n; i++){
			silsu[i] = scanner.nextDouble();
		}
		
		double ret = 0.0;
		for(int i = 0 ; i < n; i++){
			ret = Math.max(ret, mSilsu(i, silsu));
		}
		System.out.printf("%.3f", ret);
	}
	static double mSilsu(int n, double[] silsu){
		if(n < 2){
			return silsu[0]; 
		}
		double ret = silsu[n-1];
		//for(int i = 0; i < n ;i++){
			ret = Math.max(ret, ret*mSilsu(n-1, silsu));
		//}
		return ret;
	}

}
