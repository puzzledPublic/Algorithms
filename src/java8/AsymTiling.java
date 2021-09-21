package java8;

import java.util.Arrays;
import java.util.Scanner;

//비대칭 타일링
//종만북 8.12문제
//2xn 크기의 직사각형을 2x1 크기의 타일로 채우려고한다.
//서로 겹쳐서는 안되며 90도로 돌려 사용 가능하다
//단 좌우대칭인 경우에는 제외한다. 
//n이 주어질때 가능한 비대칭 타일링 방법의 수를 계산하라 ( 방법의 수가 매우 클 수 있으ㅡ로 1,000,000,007로 나눈 나머지를 출력한다)
// 1 <= n <= 100
public class AsymTiling {
	static int[] cache = new int[101];
	static int[] cache2 = new int[101];
	final static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int width = scanner.nextInt();
		//캐쉬 -1 로 초기화
		Arrays.fill(cache, -1);
		Arrays.fill(cache2, -1);
		System.out.println(asymTile(width));
	}
	static int asymTile(int width){
		//대칭되는 경우를 볼때 크게 2가지다 width가 홀수, 짝수인 경우
		//홀수인 경우 가운데 2x1인 타일이 있고 좌우로 대칭되는 경우
		//짝수인 경우 가운데 1x2인 2개 타일이 위아래 있고 좌우로 대칭되는 경우와 단순히 가운데 위치를 기준으로 대칭인 경우
		
		//width가 홀수일 때 1가지 경우 
		if(width%2==1){
			return (tiling(width)-tiling(width/2) + mod)%mod;
		}
		//width가 짝수일 때 2가지 경우
		int ret = tiling(width);
		//단순히 가운데 위치를 기준으로 대칭인 경우 (음수가 되는 경우를 방지하기 위해 mod를 더함)
		ret = (ret - tiling(width/2)+mod)%mod;
		//가운데 1x2인 2개 타일이 위아래 있고 좌우로 대칭되는 경우
		ret = (ret - tiling(width/2-1)+mod)%mod;
		return ret;
	}
	//일일히 비대칭되는 경우를 세는 방법
	//양쪽에서 좁혀진다고 생각하고 크게 4가지 경우가 있다
	static int asymTile2(int width){
		//width가 2 이하면 비대칭인 경우가 없으므로 0 리턴
		if(width <= 2){
			return 0;
		}
		//메모이제이션
		if(cache2[width] != -1){
			return cache2[width];
		}
		//왼쪽 오른쪽에 2x1타일이 하나씩 있는 경우(대칭인 경우이므로 남은 벽면이 비대칭이 되어야함)
		cache2[width] = asymTile2(width-2) % mod;
		//왼쪽 오른쪽에 1x2타일 2개씩 있는 경우(대칭인 경우이므로 남은 벽면이 비대칭이 되어야함)
		cache2[width] = (cache2[width] + asymTile2(width-4)) % mod;
		//왼쪽에 2x1타일 하나 오른쪽에 1x2타일 2개가 있는 경우(이때는 비대칭이므로 모든 수를 구하면 된다)
		cache2[width] = (cache2[width] + tiling(width-3)) % mod;
		//왼쪽에 1x2타일 2개 오른쪽에 2x1타일 하나가 있는 경우(비대칭이므로 모든 수를 구한다)
		cache2[width] = (cache2[width] + tiling(width-3)) % mod;
		return cache2[width];
	}
	//모든 타일링 방법의 수를 구하는 재귀 함수(비대칭+대칭)
	static int tiling(int width){
		if(width <= 1){
			return 1;
		}
		if(cache[width] != -1){
			return cache[width];
		}
		return cache[width] = (tiling(width-1)+tiling(width-2))%mod;
	}
}
