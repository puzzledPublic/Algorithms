package java8;

import java.util.ArrayList;
import java.util.Scanner;

public class MailProgramming {
	static ArrayList<Integer> arr;
	static ArrayList<Integer> result;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n;
		n = input.nextInt();
		arr = new ArrayList<>(n);
		result = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			arr.add(input.nextInt());
		}
		
		arr.sort((a,b) -> {
			int ta = (a / (int)Math.pow(10, (int)Math.log10(a)));
			int tb = (b / (int)Math.pow(10, (int)Math.log10(b)));
			return ta == tb ? 0 : ta > tb ? -1 : 1;  
		});
		
		for(int i = 0; i < arr.size(); i++) {
			
		}
	}
	
}
