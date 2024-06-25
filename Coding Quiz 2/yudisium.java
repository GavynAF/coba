import java.util.Scanner;

/**
 * yudisium
 */
public class yudisium {

    public static void main(String[] args) {
        int n;
        double total=0;
        boolean isPending=true;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        char[] nilai = new char[n];

        if (n>0) {
            for (int i = 0; i < n; i++) {
                nilai[i] = input.next().charAt(0);
                total += hitungNilai(nilai[i]);
                if (nilai[i]=='E') {
                    isPending = false;
                }
            }
        }

        if (isPending) {
            statusYudisium(total, n);
        } else {
            System.out.println("Pending");
        }  
        
    }

    public static int hitungNilai(char nilai) {
        int jumlah=0;

        switch (nilai) {
            case 'A':
                jumlah = 4;
                break;
            case 'B':
                jumlah = 3;
                break;
            case 'C':
                jumlah = 2;
                break;
            case 'D':
                jumlah = 1;
                break;
            case 'E':
                jumlah = 0;
                break;
            default:
                break;
        }
        return jumlah;
    }

    public static void statusYudisium(Double total, int n) {
        double ipk;
        String status="";

        ipk = total/n;

        if (ipk >= 3.5) {
            status = "Cum Laude";
        } else if(ipk >= 2.75&&ipk <3.5){
            status = "Sangat Memuaskan";
        }else if(ipk >= 2&&ipk <2.75){
            status = "Memuaskan";
        }else if(ipk <2){
            status = "Pending";
        }

        System.out.println(status);
    }
}