import java.util.Scanner;

public class MatriksIdentitas {
    public static void main(String[] args) {
        int n;

        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int[][] matriks = new int[n][n];

        if (n>=1&&n<=7) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n; j++) {              
                    if (i==j) {
                        matriks[i][j] = 1;
                    } else {
                        matriks[i][j] = 0;
                    }
                    System.out.print(matriks[i][j]);
                }
                System.out.println();
            }
        }
    }
}
