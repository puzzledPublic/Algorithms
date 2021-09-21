package java8;

import java.util.Scanner;

//달력 (2000년 1월 1일은 토요일)
public class Jungol1007 {
	static int years[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static String days[] = {"","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}; 
	static int yearinit[] = new int[12];
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		int y, m, d;
		calcYearInit();
		while(true){
			y = input.nextInt();
			m = input.nextInt();
			d = input.nextInt();
			
			if(y > 1999 && y <2011 && m > 0 && m < 13){
				//윤년인 경우 2월달은 29일
				if(yearinit[y%2000+1] == 366){
					years[2] = 29;
				}
				if(d > 0 && d < years[m]+1){
					int temp = 0;
					for(int i = 0 ; i < y%2000+1; i++){
						temp += yearinit[i];
					}
					for(int i = 1 ; i < m ; i++){
						temp += years[i];
					}
					int startDay = temp%7;// - 1 + 1;
					if(startDay == 0){
						startDay = 7;
					}
					System.out.println(y + ". "+ m);
					print(startDay, years[m]);
					
					temp += (d-1);
					
					int specifiedDay = temp %7;
					if(specifiedDay == 0){
						specifiedDay = 7;
					}
					System.out.println(days[specifiedDay]);
				}
				else{
					System.out.println("INPUT ERROR!");
				}
				years[2] = 28; //while문이므로 초기화
			}
			else{
				System.out.println("INPUT ERROR!");
			}
		}
	}
	static void calcYearInit(){
		for(int y = 2000; y <= 2010; y++){
			if(y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)){
				yearinit[y%2000+1] = 366;
			}
			else{
				yearinit[y%2000+1] = 365;
			}
		}
	}
	static void print(int startDay, int monthDays){
		System.out.println("sun mon tue wed thu fri sat");
		for(int i = 1; i < startDay; i++){
			System.out.print("    ");
		}
		int num = 1;
		for(int i = 0 ; i < 8-startDay; i++){
			System.out.printf(" %2d ", num++);
		}
		System.out.println();
		for(int i = 0; i < (monthDays - (8 - startDay))/7; i++){
			for(int j = 0; j < 7; j++){
				if(num < 10){
					System.out.printf(" %2d ", num++);
				}else{
					System.out.printf(" %2d ",num++);
				}
			}
			System.out.println();
		}
		for(int i = num; i < monthDays+1; i++){
			System.out.printf(" %2d ", i);
		}
		System.out.println();
		
	}
}
