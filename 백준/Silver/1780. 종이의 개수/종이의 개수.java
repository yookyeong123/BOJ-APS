import java.util.Scanner;

public class Main {
	static int[][] board;
	static int A = 0; // -1
	static int B = 0; // 0
	static int C = 0; // 1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		board = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		partition(0, 0, N);
		
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
	}

	private static void partition(int row, int col, int size) {
		if(colorCheck(row, col, size)) {
			if(board[row][col] == -1) {
				A++;
			}
			else if(board[row][col] == 0) {
				B++;
			}
			else {
				C++;
			}
			return;
		}
		int newSize = size/3;
		
		//board를 총 9등분으로 나누어서 생각
		//젤윗줄 왼쪽, 중간, 오른쪽 
		partition(row, col, newSize); 
		partition(row, col + newSize, newSize); 
		partition(row, col + (newSize*2), newSize); //오른쪽으로 newSize만큼 한번더가면 되니까 *2
		
		//가운데줄 왼쪽, 중간, 오른쪽 
		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);
		partition(row + newSize, col + (newSize*2), newSize);
		
		//마지막줄 왼쪽, 중간, 오른쪽 
		partition(row+(newSize*2), col, newSize);
		partition(row+(newSize*2), col + newSize, newSize);
		partition(row+(newSize*2), col + (newSize*2), newSize);
	}

	private static boolean colorCheck(int row, int col, int size) {
		int color = board[row][col];
		
		for(int i = row; i < row+size; i++) {
			for(int j = col; j < col+size; j++) {
				if(color != board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}