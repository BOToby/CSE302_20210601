package LastProject;

import java.util.Scanner;

public class Niude {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give function as y=Kx+B, you can change the value of K and B:");
            scanner.close();
        } catch (Exception e) {
            System.out.println("Input Illegal");
        }
    }
}
