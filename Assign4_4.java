import java.util.*;
public class Assign4_4 {
    public static void shortestPath(int a, int b, int c) {
        if (a <= b && a <= c) {
            System.out.println("The shortest path is Edinburgh-Glasgow-Stirling-Perth-Dundee: " + a);
        } else if (b <= c && b <= a) {
            System.out.println("The shortest path is Edinburgh-Stirling-Perth-Dundee: " + b);
        } else {
            System.out.println("The shortest path is Edinburgh-Perth-Dundee: " + c);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter costs");
        System.out.println("Perth-Dundee(60): ");
        int PD = scanner.nextInt();
        System.out.println("Edinburgh-Perth(100): ");
        int EP = scanner.nextInt();
        System.out.println("Stirling-Perth(40): ");
        int SP = scanner.nextInt();
        System.out.println("Edinburgh-Stirling(50): ");
        int ES = scanner.nextInt();
        System.out.println("Glasgow-Stirling(50): ");
        int GS = scanner.nextInt();
        System.out.println("Edinburgh-Glasgow(70): ");
        int EG = scanner.nextInt();
        System.out.println("\n");

        shortestPath(EG + GS + SP + PD, ES + SP + PD, EP + PD);
    }
}
