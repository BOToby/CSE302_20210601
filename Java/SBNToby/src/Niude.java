import java.util.Scanner;

public class Niude {

    private static int row;
    private static int col;
    private static char sym;

    public static void ask() {
        while (true) {
            try {
                String inp;
                Scanner scanner = new Scanner(System.in);
                System.out.print("A)New graph\nB)Change sets\nC)Exit\n>>>");
                inp = scanner.nextLine();
                if (inp.equals("A") || inp.equals("a")) body();
                else if (inp.equals("B") || inp.equals("b")) askSet();
                else if (inp.equals("C") || inp.equals("c")) break;
                else System.out.println("<Input error, try again, give your choose as a, b, etc.>");
            } catch(Exception e) {
                System.out.println("<Input error, try again, give your choose as a, b, etc.>");
            }
        }
    }

    public static void askSet() {
        while (true) {
            try {
                String inp;
                Scanner scanner = new Scanner(System.in);
                System.out.print("A)Change graph size\nB)Change symbol\nC)Exit\n>>>");
                inp = scanner.nextLine();
                if (inp.equals("A") || inp.equals("a")) {
                    Scanner s = new Scanner(System.in);
                    System.out.print("Give the size as row*col (tacitly 300*300)\nrow:");
                    row = s.nextInt();
                    System.out.print("col:");
                    col = s.nextInt();
                    break;
                }
                else if (inp.equals("B") || inp.equals("b")) {
                    Scanner ss = new Scanner(System.in);
                    System.out.print("Give the the symbol you want to use in graph (tacitly '#'):");
                    sym = ss.next().charAt(0);
                    ss.close();
                    break;
                }
                else if (inp.equals("C") || inp.equals("c")) break;
                else System.out.println("<Input error, try again, give your choose as a, b, etc.>");
            } catch(Exception e) {
                System.out.println("<Input error, try again, give your choose as a, b, etc.>");
            }
        }
    }

    public static void body() {
        int k;
        int b;
        boolean add;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Give function as y=Kx+B, you can change the value of K and B\n>>>");
                String inp = scanner.nextLine();
                k = Integer.parseInt(inp.substring(inp.indexOf('=') + 1, inp.indexOf('x')));
                if (inp.charAt(inp.indexOf('x') + 1) == '+') add = true;
                else add = false;
                if (add) b = Integer.parseInt(inp.substring(inp.indexOf('+') + 1));
                else b = Integer.parseInt(inp.substring(inp.indexOf('-') + 1));
                break;
            } catch (Exception e) {
                System.out.println("<Input Illegal, try again, give the function like y=1x+0, etc.>");
            }
        }
        try {
            char[][] graph = new char[row + 1][col + 1];
            for (int r = -(row / 2); r <= (row / 2); r++) {
                for (int c = -(col / 2); c <= (col / 2); c++) {
                    graph[r + (row / 2)][c + (col / 2)] = ' ';
                }
            }
            for (int c = -(col / 2); c <= (col / 2); c++) graph[row / 2][c + (col / 2)] = '-';
            for (int r = -(row / 2); r <= (row / 2); r++) graph[r + (row / 2)][col / 2] = '|';
            graph[row / 2][col / 2] = '+';
            for (int r = -(row / 2); r <= (row / 2); r++) {
                for (int c = -(col / 2); c <= (col / 2); c++) {
                    int x = c;
                    int y;
                    if (add) y = k * x + b;
                    else y = k * x - b;
                    if (y >= -(row / 2) && y <= (row / 2)) {
                        graph[row - (y + (row / 2))][x + (col / 2)] = sym;
                    }
                }
            }
            for (int r = -(row / 2); r <= (row / 2); r++) {
                for (int c = -(col / 2); c <= (col / 2); c++) {
                    System.out.print(graph[r + (row / 2)][c + (col / 2)]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        row = 300;
        col = 300;
        sym = '#';
        ask();
    }
}
