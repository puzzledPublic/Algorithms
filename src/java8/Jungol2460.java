package java8;

import java.util.Scanner;

// 나는 학급 회장이다.(투표)
// N명이 모인 학급에 3명의 회장 후보들이 있다
// 각자의 학생들이 3명 후보에 대한 선호도를 1,2,3으로 표시할때 가장 높은 선호도를 가진 후보의 번호와 최고점수를 출력하라
// 만일 후보들 중 선호도가 같다면 3점을 가장 많이 받은 후보를 선정한다, 3점 횟수도 같다면 2점 횟수로 정한다.
// 하지만 2점도 횟수가 같다면 회장을 결정 할 수 없으므로 0과 최고 점수를 출력한다.
public class Jungol2460 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n; // 학생 수
		n = scanner.nextInt(); 
		int clazz[][] = new int[n][3]; //학생들의 선호도
		int presidents[][] = new int[3][3]; //각 후보들의 선호도 개수
		int presidentPoint[] = new int[3]; // 각 후보들의 총 선호도 점수
		//입력
		for(int i = 0; i < clazz.length; i++){
			for(int j = 0 ; j < clazz[0].length; j++){
				clazz[i][j] = scanner.nextInt();
			}
		}
		//각 후보들의 점수와 선호도 갯수 처리
		for(int i = 0 ; i < clazz[0].length; i++){
			for(int j = 0 ; j < clazz.length; j++){
				presidentPoint[i]+=clazz[j][i];
				switch(clazz[j][i]){
				case 1:
					presidents[i][0]++;
					break;
				case 2:
					presidents[i][1]++;
					break;
				case 3:
					presidents[i][2]++;
					break;
				}
			}
		}
		//3개 모두 같은 숫자일 경우 1,2,3 개수들은 모두 같음
		if(presidentPoint[0]==presidentPoint[1]&&presidentPoint[1]==presidentPoint[2]){
				System.out.print("0 "+presidentPoint[0]);
				return;
		}
		//2개가 같은 숫자일 경우
		//(1,2)(2,3)(1,3)가 같은 경우를 돌면서
		for(int i = 0 ; i < presidentPoint.length - 1;i++){
			for(int j = i+1; j <presidentPoint.length; j++){
				//두 수가 같으며 나머지 한 수 보다 클때
				if(presidentPoint[i] == presidentPoint[j] && presidentPoint[i] > presidentPoint[3-(i+j)]){
					//두 수의 선호도3이 누가 더 많은가
					if(presidents[i][2]>presidents[j][2]){
						System.out.println((i+1)+" "+presidentPoint[i]);
						return;
					}
					//선호도 3 개수가 같다면
					else if(presidents[i][2]==presidents[j][2]){
						//선호도 2개 수가 누가 더 많은가
						if(presidents[i][1]>presidents[j][1]){
							System.out.println((i+1)+" "+presidentPoint[i]);
							return;
						}
						//선호도 2 개수가 같다면
						else if(presidents[i][1]==presidents[j][1]){
							//아무도 반장이 되질 않으므로 0으로 출력
							System.out.println("0 "+presidentPoint[i]);
							return;
						}
						else{
							System.out.println((j+1)+" "+presidentPoint[j]);
							return;
						}
					}
					else{
						System.out.println((j+1)+" "+presidentPoint[j]);
						return;
					}
				}
			}
		}
		//셋다 점수가 다른 경우
		int highest[][] = new int[1][2];
		highest[0][1] = 0;
		for(int i = 0 ; i < presidentPoint.length; i++){
				if(highest[0][1] < presidentPoint[i]){
					highest[0][0] = i;
					highest[0][1] = presidentPoint[i];
				}

		}
		System.out.println((highest[0][0]+1)+" "+highest[0][1]);
	}
}
