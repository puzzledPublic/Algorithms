package java8;

import java.awt.CardLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//ī�����(not yet)
public class Jungol1311 {
	static char[] cardColor;
	static int[] cardNumber;
	static int result = 0 ;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		cardColor = new char[5];
		cardNumber = new int[5];
		for(int i = 0 ; i < 5; i++){
			cardColor[i] = input.next().charAt(0);
			cardNumber[i] = input.nextInt();
		}
		Arrays.sort(cardNumber);
		
		if(isAllSameColor() && isConsecutive()){
			result += (900 + cardNumber[cardNumber.length-1]);
		}
		
		
	}
	static boolean isAllSameColor()
	{
		for(int i = 0 ; i < cardColor.length - 1; i++){
			if(cardColor[i] != cardColor[i+1]){
				return false;
			}
		}
		return true;
	}
	static boolean isConsecutive(){
		for(int i = 0 ; i < cardNumber.length - 1; i++){
			if(cardNumber[i + 1] - cardNumber[i] != 1){
				return false;
			}
		}
		return true;
	}
	
	
}
