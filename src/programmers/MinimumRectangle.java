package programmers;

//최소직사각형
public class MinimumRectangle {
    public static void main(String[] args) {
        int[][][] sizess = {
                {
                        {60, 50},
                        {30, 70},
                        {60, 30},
                        {80, 40},
                },  //4000
                {
                        {10, 7},
                        {12, 3},
                        {8, 15},
                        {14, 7},
                        {5, 15},
                },  //120
                {
                        {14, 4},
                        {19, 6},
                        {6, 16},
                        {18, 7},
                        {7, 11},
                },  //133
        };

        for(int[][] sizes : sizess) {
            System.out.println(solution(sizes));
        }
    }

    static int solution(int[][] sizes) {
        int answer = 0;

        int boxH = 0, boxW = 0;

        for(int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            boxH = Math.max(boxH, max);
            boxW = Math.max(boxW, min);
        }

        answer = boxH * boxW;

        return answer;
    }
}
