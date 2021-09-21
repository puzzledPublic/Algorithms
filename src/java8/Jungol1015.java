package java8;

import java.util.Scanner;
import java.util.Stack;

//브라우저 East Central North America 2001
public class Jungol1015 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String operation;
		String currentPage = "http://www.acm.org/";
		Stack<String> backwardStack = new Stack<String>();
		Stack<String> forwardStack = new Stack<String>();
		
		while(true){
			operation = input.nextLine();
			if(operation.startsWith("VISIT")){
				backwardStack.push(currentPage);
				currentPage = operation.substring(6);
				forwardStack.clear();
				System.out.println(currentPage);
			}
			else if(operation.equals("BACK")){
				if(backwardStack.size() > 0){
					forwardStack.push(currentPage);
					currentPage = backwardStack.pop();
					System.out.println(currentPage);
				}else{
					System.out.println("Ignored");
				}
			}
			else if(operation.equals("FORWARD")){
				if(forwardStack.size() > 0){
					backwardStack.push(currentPage);
					currentPage = forwardStack.pop();
					System.out.println(currentPage);
				}else{
					System.out.println("Ignored");
				}
			}else{
				break;
			}
		}
		
	}
}
