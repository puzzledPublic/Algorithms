package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//공주님의 정원 (그리디) ...ing
public class Jungol2461 {
	
	static class Days{
		int startM, startD, endM, endD;
		public Days(int startM, int startD, int endM, int endD) {
			this.startM = startM;
			this.startD = startD;
			this.endM = endM;
			this.endD = endD;
		}
	}
	
	static ArrayList<Days> days;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		Days initialDay = new Days(3, 1, 11, 30);
		
		days = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++){
			days.add(new Days(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()));
		}
		days.sort((o1, o2)->{
			if(o1.startM < o2.startM){
				return -1;
			}
			else if(o1.startM == o2.startM){
				if(o1.startD < o2.startD){
					return -1;
				}
				else if(o1.startD > o2.startD){
					return 1;
				}
				else if(o1.startD == o2.startD){
					if(o1.endM < o2.endM){
						return -1;
					}
				}
			}
			return 1;
		});
		
		for(Days day : days){
			System.out.println(day.startM +" "+ day.startD + " " + day.endM + " " + day.endD);
		}
		System.out.println();
		
		int index = 0;
		int count = 0;
		for(int i = 1 ; i < days.size() ; i++){
			if(initialDay.startM >= initialDay.endM && initialDay.startD >= initialDay.endD){
				break;
			}
			if(days.get(i).startM < initialDay.startM || (days.get(i).startM == initialDay.startM && days.get(i).startD <= initialDay.startD)){
				if(days.get(i).endM > days.get(i-1).endM ||(days.get(i).endM == days.get(i-1).endM && days.get(i).endD >= days.get(i-1).endD)){
					index = i;
				}
			}else{
				initialDay.startM = days.get(index).endM;
				initialDay.startD = days.get(index).endD;
				index = i;
				count++;
				System.out.println(i+" "+initialDay.startM + " " + initialDay.startD);
			}
		}
		System.out.println(count);
	}
}
