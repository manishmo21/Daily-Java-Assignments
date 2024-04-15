import java.util.Scanner;

public class factorial {

    public static void fact(int a) {
        int n = 1;
        for (int i = a; i >= 1; i--) {
            n = n * i;
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        fact(a);
    }
}
