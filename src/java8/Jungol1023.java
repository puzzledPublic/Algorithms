package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jungol1023 {

	public static void main(String args[]){
		/*
		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int n;
		n= scanner.nextInt();
		scanner.nextLine();
		for(int i = 0 ; i < n;i++){
			list.add(scanner.nextLine());
		}
		String[] str = list.get(0).split(" ");
		*/
		String[] str = "AH KH QH TH JH".split(" ");
		
		System.out.println("°á°ú :"+ isRoyalFlush(str));
	}
	static boolean isRoyalFlush(String[] str){
		String RF= "AKQJT";
		if(isFlush(str)){
			for(int i = 0 ; i < 5; i++){
				if(RF.contains(str[i].subSequence(0, 1))){
					RF.replace(str[i].charAt(0)+"", " ");
				}
			}
			System.out.println(RF);
			if(RF=="     "){
				return true;
			}
		}
		return false;
	}
	static boolean isFlush(String[] str){
		char t = str[0].charAt(1);
		for(int i =0;i<5;i++){
			if(str[i].charAt(1) != t){
				return false;
			}
		}
		return true;
	}
}
