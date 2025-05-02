package trials2;
/*Ignore these
 * import java.util.Scanner;
import java.util.Arrays;
*/
import java.util.*;
public class LOL {
	public static void main(String[] args) {
		int n , status = 1 , num = 3;
		Scanner sc = new Scanner(System.in);
		
		print("Enter the number of prime numbers you want: ");
		n = sc.nextInt();
		if(n >= 1 ) {
			print("First " + n + " prime numbers are :\n");
			System.out.println(2);
		}
		for(int count = 2 ; count <= n ; ) {
			for (int j = 2; j <= Math.sqrt(num) ; j++) 
			{
				if (num % j == 0)
				{
					break;  
				}
			}
			if (status != 0 ) {
				System.out.println(num);
				count++;
			}
			status = 1;
			num++;
		}
		status = 0;
	}
	public static void print ( String s) {
	System.out.print(s);
	}
}
