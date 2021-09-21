package java8_1;

public class Lg2 {
	public static void main(String[] args) {
		int[] N = {1, 3};
		int[][][] house = {
				{{0, 0}, {1, 0}, {5, 100}},
				{{0, 0}, {1, 0}, {100, 100}, {-100, 100}, {-100, -100}, {100, -100}}
		};
//		for(int i = 0; i < N.length; i++) {
//			System.out.println("answer " + solution(N[i], house[i]));
//		}
		System.out.println("answer " + solution(N[0], house[0]));
	}
	static int solution(int N, int[][] house) {
        int answer = 0;
        boolean[][] chk = new boolean[201][201];
        for(int i = 0; i < house.length; i++) {
        	chk[house[i][0] + 100][house[i][1] + 100] = true;
        }
        int maxX = 0, maxY = 0;
        for(int k = 0; k < N; k++) {
        	maxX = 0;
        	maxY = 0;
        	long tempmax = 0;
	        for(int i = -100; i < 101; i++) {
	        	for(int j = -100; j < 101; j++) {
	        		if(!chk[i + 100][j + 100]) {
	        			int dist = 0;
	        			int min = 987654321;
	        			for(int h = 0; h < house.length; h++) {
	        				dist = distance(i, j, house[h][0], house[h][1]);
	        				if(min > dist) {
	        					min = dist;
	        				}
	        			}
	        			if(tempmax < min) {
	        				tempmax = min;
	        				maxX = i;
	        				maxY = j;
	        			}
	        			
	        		}
	        	}
	        }
	        System.out.println(maxX + " " + maxY);
	        chk[maxX + 100][maxY + 100] = true;
        }
        System.out.println(maxX + " " + maxY);
        int min = 987654321;
        for(int i = 0; i < house.length; i++) {
        	int dist = distance(maxX, maxY, house[i][0], house[i][1]);
        	System.out.println(dist);
        	if(min > dist) {
        		min = dist;
        	}
        }
        return answer = min;
    }
	static int distance(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}
}
