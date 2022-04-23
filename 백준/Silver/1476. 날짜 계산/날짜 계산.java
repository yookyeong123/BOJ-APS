import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//E 1~15
		//S 1_28
		//M 1~19
		

			int E = sc.nextInt();
			int S = sc.nextInt();
			int M = sc.nextInt();
			
			int year = 0;
			while(true) {
				year ++;
				if((year-E) %15==0 && (year - S)%28 == 0 && (year - M) % 19 == 0)
					break;
			}
			
			System.out.println(year);
			
		
	}
}