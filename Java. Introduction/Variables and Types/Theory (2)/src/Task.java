// You can experiment here, it won’t be checked


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task {
  public static void main(String[] args) throws IOException {
    // put your code here
    // the object for reading
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // it takes a string and splits it by whitespaces
    String[] values = reader.readLine().split("\\s+");
    int a = Integer.parseInt(values[0]); // It converts the first value to integer
    int b = Integer.parseInt(values[1]); //It converts the second value to integer
    System.out.println("The final results = "+a+b);
  }
}
