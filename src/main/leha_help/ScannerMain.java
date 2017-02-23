package leha_help;

import java.util.Scanner;

/**
 * Created by скурихин on 25.11.2016.
 */
public class ScannerMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        String next = scan.next();
        String s = scan.nextLine();
        double d = scan.nextDouble();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}