import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //put your code here
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int ans = ((num +1) * num + 2) * num + 3;
    System.out.println(ans);
  }
}