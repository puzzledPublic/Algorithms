package java8;

import java.util.Scanner;

//장난감 조립 KOI 2000 중등부
public class Jungol1021 {
	static int items[][] = new int[111][111];	//items[i][j] -> 부품 i에 대해 필요한 부품 j의 개수
	static int middleItem[] = new int[111];		//middleItem[i] -> 부품 i가 중간 or 완성 부품이라면 -1로 하여 기본부품과 구별
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int x, y, z; 
		for(int i = 0; i < M; i++){
			x = input.nextInt();
			y = input.nextInt();
			z = input.nextInt();
			items[x][y] = z;
			middleItem[x] = -1;
		}
		
		assemble(N);	//재귀호출 
		
		for(int i = 1 ; i < N; i++){	//출력
			if(middleItem[i] != -1){
				System.out.println(i + " " + middleItem[i]);
			}
		}
	}
	static void assemble(int n){
		if(middleItem[n] != -1){	//기본부품이라면
			middleItem[n]++;	//기본부품 개수 추가
			return;
		}
		for(int i = 1; i < items[n].length; i++){	//모든 아이템 중에서
			if(items[n][i] != 0){	//items[i]에 필요한 부품이라면
				for(int j = 0; j < items[n][i]; j++){	//필요한 부품 개수만큼
					assemble(i);	//다음 부품으로
				}
			}
		}
	}
}
