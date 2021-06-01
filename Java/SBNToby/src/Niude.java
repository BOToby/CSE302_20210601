import java.util.Scanner;

public class Niude {
    public static void main(String[] args){
        int k;
        int b;
        boolean add;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give function as y=Kx+B, you can change the value of K and B:");
                String inp = scanner.nextLine();
                k = Integer.parseInt(inp.substring(inp.indexOf('=') + 1, inp.indexOf('x')));
                if (inp.charAt(inp.indexOf('x') + 1) == '+') add = true;
                else add = false;
                if (add) b = Integer.parseInt(inp.substring(inp.indexOf('+') + 1));
                else b = Integer.parseInt(inp.substring(inp.indexOf('-') + 1));
                break;
            } catch (Exception e) {
                System.out.println("Input Illegal, try again.");
            }
        }
        char[][] graph = new char[301][301];
        for (int row = -150; row <= 150; row++) {
            for (int col = -150; col <= 150; col++) {
                graph[row + 150][col + 150] = ' ';
            }
        }
        for (int col = -150; col <= 150; col++) graph[150][col + 150] = '-';
        for (int row = -150; row <= 150; row++) graph[row + 150][150] = '|';
        graph[150][150] = '+';
        for (int row = -150; row <= 150; row++) {
            for (int col = -150; col <= 150; col++) {
                int x = col;
                int y;
                if (add) y = k * x + b;
                else y = k * x - b;
                if (y >= -150 && y <= 150) {
                    graph[300 - (y + 150)][x + 150] = '#';
                }
            }
        }
        for (int row = -150; row <= 150; row++) {
            for (int col = -150; col <= 150; col++) {
                System.out.print(graph[row + 150][col + 150]);
            }
            System.out.println();
        }
    }
}
