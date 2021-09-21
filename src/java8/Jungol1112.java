package java8;

import java.util.Scanner;

//줄자접기
//줄자의 길이(10 <= 길이 <=1000)와 빨간점, 파란점, 노란점의 위치가 각각 2개씩 주어진다.(위치는 서로 겹치지 않는다.)
//이때 빨 - 파 - 노의 순서로 점들을 맞닫게 줄자를 접는다면 줄자의 길이는 몇인지 구하라
public class Jungol1112 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double rulerLength;
		//줄자 처음 길이 입력
		rulerLength = scanner.nextInt();
		//점들의 위치 배열
		double[][] dots = new double[3][2];
		//점들의 위치 입력 dots[0] = 빨, dots[1] = 파, dots[2] = 노
		for (int i = 0; i < dots.length; i++) {
			dots[i][0] = scanner.nextDouble();
			dots[i][1] = scanner.nextDouble();
		}
		//빨-파-노 순으로 돌며
		for (int i = 0; i < dots.length; i++) {
			//점의 위치가 같으면 맞닿아 있는 것이므로 무시
			if (dots[i][0] != dots[i][1]) {
				//현재 색깔에 해당되는 점들의 중앙 위치 계산
				double middle = (dots[i][0] + dots[i][1]) / 2;
				//System.out.println(rulerLength + " " + middle + " "
				//		+ dots[i][0] + " " + dots[i][1]);
				//중앙 위치를 기준으로 왼쪽이 더 짧으면(위치의 시작이 0이 아니므로 0으로 맞춰주기 위해 접히는 부분 기준 왼쪽과 오른쪽 둘다 조정이 필요함)
				if (middle < rulerLength - middle) {
					//현재 색깔 이후에 탐색할 색깔 점 위치를 조정한다.
					for (int j = i + 1; j < dots.length; j++) {
						for (int k = 0; k < dots[0].length; k++) {
							//중앙 위치보다 큰 위치들은 0을 기준으로 맞춰준다
							if (dots[j][k] > middle) {
								dots[j][k] = dots[j][k] - middle;
							}
							//작은 위치들도 위치 조정
							else {
								dots[j][k] = middle - dots[j][k];
							}
						}
					}
					//줄자 길이를 줄인다
					rulerLength -= middle;
				}
				//중앙 위치를 기준으로 오른쪽이 더 짧으면(시작위치는 0이므로 접히는 부분 기준 오른쪽만 조정 해주면 됨)
				else {
					for (int j = i + 1; j < dots.length; j++) {
						for (int k = 0; k < dots[0].length; k++) {
							//중앙 위치보다 큰 위치들을 조정한다
							if (dots[j][k] > middle) {
								dots[j][k] = middle - (dots[j][k]-middle);
							}
						}

					}
					//줄자 길이를 줄인다
					rulerLength = middle;
				}
			}
		}
		//줄자 길이 출력
		System.out.println(rulerLength);
	}
}
