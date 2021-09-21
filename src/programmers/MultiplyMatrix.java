package programmers;

import java.util.Arrays;

//행렬의 곱셈
public class MultiplyMatrix {
	public static void main(String[] args) {
		int[][][] arr1 = {
				{
					{1, 4},
					{3, 2},
					{4, 1}
				},
				{
					{2, 3, 2},
					{4, 2, 4},
					{3, 1, 4}
				}
		};
		int[][][] arr2 = {
				{
					{3, 3},
					{3, 3},
				},
				{
					{5, 4, 3},
					{2, 4, 1},
					{3, 1, 1}
				}
		};
		for(int i = 0; i < arr1.length; i++) {
			int[][] result = solution(arr1[i], arr2[i]);
			for(int j = 0; j < result.length; j++) {
				System.out.println(Arrays.toString(result[j]));
			}
			System.out.println();
		}
	}
	//(NxM) * (MxK) = (NxK)
	static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int row = arr1.length;
        int col = arr2[0].length;
        answer = new int[row][col];
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		for(int k = 0; k < arr1[0].length; k++) {
        			answer[i][j] += (arr1[i][k] * arr2[k][j]);
        		}
        	}
        }
        return answer;
    }
}
