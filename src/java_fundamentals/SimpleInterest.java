package java_fundamentals;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double principal = scanner.nextDouble();
        double rate = scanner.nextDouble();
        double time = scanner.nextDouble();
        double Simpleinterest= (principal * rate * time) / 100;
        System.out.println(Simpleinterest);


    }
}
