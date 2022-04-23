import java.util.Scanner;

public class Main {
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		//맵 만들기
		map = new int[n][m];
		sc.nextLine();
		
		//n만큼 돌면서 문자열입력받기
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			//하나씩 끊어서 배열에 넣어주기
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n-7; i++) {
			for (int j = 0; j < m-7; j++) {
				min = Math.min(min, f(i,j));
			}
		}
		System.out.println(min);
	}
	
	public static int f(int x, int y) {
		int B = 0; // B부터 시작할 때 다시 칠해야 하는 정사각형 수
		int W = 0; // W부터 시작할 때 다시 칠해야 하는 정사각형 수
		
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if((i + j) % 2 == 0) {
					if(map[i][j] == 'B') W++;
					else B++;
				}else { // (i + j) % 2 == 1)
					if(map[i][j] == 'W') W++;
					else B++;
				}
			}
		}
		return Math.min(B,W);
	}
}
