import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//자릿수
		int size = String.valueOf(N).length();
		
		int post = (int) ((N - Math.pow(10, (size-1)))+1) * size;
	
		int pre = 0;
		for(int i = 0; i < size-1; i++) {
			pre += (9*Math.pow(10, i)) * (i+1);
		}
		
		System.out.println(post+pre);
	}
}