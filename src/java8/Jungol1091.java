package java8;

import java.util.Scanner;

//질량계산
public class Jungol1091 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		String chemicalWord = input.next();
		char[] temp = chemicalWord.toCharArray();
		int[] counts = new int[4];
		for(int i = 0 ; i < temp.length; i++){
			if(temp[i] == 'C'){
				if(i+1 < temp.length && temp[i+1] >= '1' && temp[i+1] <= '9'){
					if(i+2 < temp.length && temp[i+2] >= '0' && temp[i+2] <= '9'){
						counts[0] += Integer.parseInt(temp[i+1]+""+temp[i+2]);
					}else{
						counts[0] += Integer.parseInt(String.valueOf(temp[i+1]));
					}
				}else{
					counts[0]++;
				}
			}
			else if(temp[i] == 'H'){
				if(i+1 < temp.length && temp[i+1] >= '1' && temp[i+1] <= '9'){
					if(i+2 < temp.length && temp[i+2] >= '0' && temp[i+2] <= '9'){
						counts[1] += Integer.parseInt(temp[i+1]+""+temp[i+2]);
					}else{
						counts[1] += Integer.parseInt(String.valueOf(temp[i+1]));
					}
				}else{
					counts[1]++;
				}
			}
			else if(temp[i] == 'O'){
				if(i+1 < temp.length && temp[i+1] >= '1' && temp[i+1] <= '9'){
					if(i+2 < temp.length && temp[i+2] >= '0' && temp[i+2] <= '9'){
						counts[2] += Integer.parseInt(temp[i+1]+""+temp[i+2]);
					}else{
						counts[2] += Integer.parseInt(String.valueOf(temp[i+1]));
					}
				}else{
					counts[2]++;
				}
			}	
			else if(temp[i] == 'N'){
				if(i+1 < temp.length && temp[i+1] >= '1' && temp[i+1] <= '9'){
					if(i+2 < temp.length && temp[i+2] >= '0' && temp[i+2] <= '9'){
						counts[3] += Integer.parseInt(temp[i+1]+""+temp[i+2]);
					}else{
						counts[3] += Integer.parseInt(String.valueOf(temp[i+1]));
					}
				}else{
					counts[3]++;
				}
			}
		}
		for(int i = 0 ; i <4; i++){
			System.out.println(counts[i]);
		}
		double result = counts[0] * 12.01 + counts[1] * 1.008 + counts[2] * 16.00 + counts[3] * 14.01;
		System.out.printf("%.3f",result);
	}
}
