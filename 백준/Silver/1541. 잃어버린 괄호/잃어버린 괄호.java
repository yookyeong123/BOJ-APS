import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = Integer.MAX_VALUE;
		
		String s = sc.nextLine();
		
		//-기준으로 split해준다. 
		String[] minus = s.split("\\-");
		//minus로 나눠진배열의 크기만큼 그안에서 또 +기준으로 split해준다.
		for(int i = 0; i < minus.length; i++) {
			int num = 0;
			String[] plus = minus[i].split("\\+");
			
			//split되었다면 먼저 다 더한다.
			for(int j= 0; j < plus.length; j++) {
				num += Integer.parseInt(plus[j]);
			}
			
			//첫번째수라면 sum에 그 수를 넣어주고 
			if(sum == Integer.MAX_VALUE) {
				sum = num;
			}
			//그게 아니라면 다 빼준다. 
			else {
				sum -= num;
			}
		}
		System.out.println(sum);
	}
}