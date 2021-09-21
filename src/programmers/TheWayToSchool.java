package programmers;

import java.util.Arrays;

//등굣길
public class TheWayToSchool {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		System.out.println(solution(m, n, puddles));
	}
	
	static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        int[][] arr = new int[n][m];
        //물웅덩이를 -1로 표시
        for(int i = 0; i < puddles.length; i++) {
        	arr[puddles[i][1] - 1][puddles[i][0] - 1] = -1; 
        }
        //직선의 경로 수는 1이므로 물 웅덩이가 없을때까지 1로 채운다.
        //오른쪽
        for(int i = 0; i < m; i++) {
        	if(arr[0][i] == -1) {
        		break;
        	}
        	arr[0][i] = 1;
        }
        //아래
        for(int i = 0; i < n; i++) {
        	if(arr[i][0] == -1) {
        		break;
        	}
        	arr[i][0] = 1;
        }
        
        //(0, 0) -> (n, m)까지 최단경로로 가려면 오른쪽, 아래로만 가야한다.
        //arr[i][j] = (i, j)까지 오는데 최단 경로의 수 = arr[i - 1][j] + arr[i][j - 1] (arr[i - 1][j], arr[i][j - 1] != -1)
        for(int i = 1; i < n; i++) {
        	for(int j = 1; j < m; j++) {
        		if(arr[i][j] == -1) {
        			continue;
        		}
        		if(arr[i - 1][j] != -1 && arr[i][j - 1] != -1) {	//바로 위, 왼쪽길 둘다 물웅덩이가 없는 경우
        			arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % mod;
        		}else if(arr[i - 1][j] != -1) {		//바로 위에만 물웅덩이가 없는 경우
        			arr[i][j] = arr[i - 1][j];
        		}else if(arr[i][j - 1] != -1) {		//바로 왼쪽에만 물웅덩이가 없는 경우
        			arr[i][j] = arr[i][j - 1];
        		}
        	}
        }
        answer = arr[n - 1][m - 1];
        return answer;
    }
}
