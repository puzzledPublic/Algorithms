package java8;

import java.util.Scanner;

//숫자카드 (다이나믹) 카드숫자가 1~34인 것을 주의
public class Jungol1407 {
	
	static int count = 0;
	static String strNum;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		strNum = input.next();
		
		solve(0);
		System.out.println(count);
		
	}
	
	static void solve(int start){
		if(start == strNum.length()){
			count++;
			return;
		}
		if(strNum.charAt(start) == '0'){
			return;
		}
		solve(start + 1);
		if(start + 2 <= strNum.length()){
			int b = Integer.parseInt(strNum.substring(start, start + 2));
			if(b > 9 && b < 35){
				solve(start + 2);
			}
		}
		
	}
}
