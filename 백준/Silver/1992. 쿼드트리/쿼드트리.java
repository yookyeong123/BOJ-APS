import java.util.Scanner;

//첫번째시도 메모리초과.. 왜..??????

public class Main {
	static int[][] board;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		board = new int[N][N];
		
		for(int i =0; i < N; i++) {
			String s = sc.next();
			for(int j = 0; j < N; j++) {
				board[i][j] = s.charAt(j)-'0';
			}
		}//입력완료
		
		partition(0,0,N);
		System.out.println(sb);
	}
	private static void partition(int row, int col, int size) {
		if(colorCheck(row, col, size)) {
			sb.append(board[row][col]);
			return;
		}
		
		int newSize = size/ 2;
		
		sb.append('(');
		
		
		partition(row, col, newSize);
		partition(row, col+newSize, newSize);
		partition(row+newSize, col, newSize);
		partition(row+newSize, col+newSize, newSize);
		
		sb.append(')');
	}
	private static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col];
		
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col + size; j++) {
				if(color != board[i][j])
					return false;
			}
		}
		return true;
	}
}